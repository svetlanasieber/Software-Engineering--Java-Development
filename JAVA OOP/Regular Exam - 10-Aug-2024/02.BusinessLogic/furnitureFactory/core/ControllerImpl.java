package furnitureFactory.core;

import furnitureFactory.repositories.*;
import furnitureFactory.entities.factories.AdvancedFactory;
import furnitureFactory.entities.factories.Factory;
import furnitureFactory.entities.factories.OrdinaryFactory;
import furnitureFactory.entities.wood.OakWood;
import furnitureFactory.entities.wood.Wood;
import furnitureFactory.entities.workshops.TableWorkshop;
import furnitureFactory.entities.workshops.DeckingWorkshop;
import furnitureFactory.entities.workshops.Workshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class ControllerImpl implements Controller {

    private WoodRepository woodRepository;
    private WorkshopRepository workshopRepository;
    private Collection<Factory> factories;

    public ControllerImpl() {
        this.woodRepository = new WoodRepositoryImpl();
        this.workshopRepository = new WorkshopRepositoryImpl();
        this.factories = new HashSet<>();
    }

    @Override
    public String buildFactory(String factoryType, String factoryName) {
        Factory factory;
        switch (factoryType) {
            case "OrdinaryFactory":
                factory = new OrdinaryFactory(factoryName);
                break;
            case "AdvancedFactory":
                factory = new AdvancedFactory(factoryName);
                break;
            default:
                throw new IllegalArgumentException("Invalid factory type.");
        }
        if (getFactoryByName(factoryName) != null) {
            throw new NullPointerException("Factory with this name already exists.");
        }
        factories.add(factory);
        return String.format("Successfully build %s %s.", factoryType, factoryName);
    }

    @Override
    public Factory getFactoryByName(String factoryName) {
        for (Factory factory : factories) {
            if (factory.getName().equals(factoryName)) {
                return factory;
            }
        }
        return null;
    }

    @Override
    public String buildWorkshop(String workshopType, int woodCapacity) {
        Workshop workshop;
        switch (workshopType) {
            case "TableWorkshop":
                workshop = new TableWorkshop(woodCapacity);
                break;
            case "DeckingWorkshop":
                workshop = new DeckingWorkshop(woodCapacity);
                break;
            default:
                throw new IllegalArgumentException("Invalid workshop type.");
        }

        this.workshopRepository.add(workshop);
        return String.format("Successfully build workshop of type %s.", workshopType);
    }

    @Override
    public String addWorkshopToFactory(String factoryName, String workshopType) {
        Factory factory = getFactoryByName(factoryName);
        if (factory == null) {
            throw new NullPointerException(String.format("Factory with name %s does not exist.", factoryName));
        }

        Workshop workshop = workshopRepository.findByType(workshopType);
        if (workshop == null) {
            throw new NullPointerException(String.format("There is no workshop of type %s in repository.", workshopType));
        }

        for (Workshop existingWorkshop : factory.getWorkshops()) {
            if (existingWorkshop.getClass().getSimpleName().equals(workshopType)) {
                throw new IllegalArgumentException("Workshop of this type already exists in this factory.");
            }
        }

        if (factory instanceof OrdinaryFactory && workshop instanceof DeckingWorkshop) {
            return "This factory does not support this type of workshop.";
        } else if (factory instanceof AdvancedFactory && workshop instanceof TableWorkshop) {
            return "This factory does not support this type of workshop.";
        }

        factory.addWorkshop(workshop);
        return String.format("Successfully added workshop of type %s in %s.", workshopType, factoryName);
    }

    @Override
    public String buyWoodForFactory(String woodType) {
        Wood wood;

        if ("OakWood".equalsIgnoreCase(woodType)) {
            wood = new OakWood();
        } else {
            throw new IllegalArgumentException("Invalid wood type.");
        }

        this.woodRepository.add(wood);
        return String.format("Successfully bought %s.", woodType);
    }

    @Override
    public String addWoodToWorkshop(String factoryName, String workshopType, String woodType) {
        Factory factory = getFactoryByName(factoryName);
        if (factory == null) {
            throw new NullPointerException(String.format("Factory with name %s does not exist.", factoryName));
        }

        if (factory.getWorkshops().isEmpty()) {
            throw new NullPointerException("There are no added workshops to add wood to.");
        }

        Workshop workshop = factory.getWorkshops().stream()
                .filter(w -> w.getClass().getSimpleName().equals(workshopType))
                .findFirst()
                .orElse(null);

        if (workshop == null) {
            throw new NullPointerException(String.format("There is no workshop of type %s in factory %s.", workshopType, factoryName));
        }

        Wood wood = woodRepository.findByType(woodType);
        if (wood == null) {
            throw new NullPointerException(String.format("There is no %s in wood repository.", woodType));
        }

        workshop.addWood(wood);
        woodRepository.remove(wood);

        return String.format("Successfully added %s to %s.", woodType, workshopType);
    }

    @Override
    public String produceFurniture(String factoryName) {
        Factory factory = getFactoryByName(factoryName);
        if (factory == null) {
            throw new NullPointerException(String.format("Factory with name %s does not exist.", factoryName));
        }

        if (factory.getWorkshops().isEmpty()) {
            throw new NullPointerException(String.format("There are no added workshops in %s factory to produce furniture.", factoryName));
        }

        int producedFurnitureCount = 0;
        Collection<Workshop> workshopsToRemove = new ArrayList<>();

        for (Workshop workshop : factory.getWorkshops()) {
            if (workshop.getWoodQuantity() < workshop.getWoodQuantityReduceFactor()) {
                if (workshop.getWoodQuantity() > 0) {
                    // Do nothing, just skip production for this workshop
                }
                workshopsToRemove.add(workshop);
            } else {
                workshop.produce();
                producedFurnitureCount++;
                if (workshop.getWoodQuantity() <= 0) {
                    workshopsToRemove.add(workshop);
                }
            }
        }

        for (Workshop workshop : workshopsToRemove) {
            factory.getWorkshops().remove(workshop);
            workshopRepository.remove(workshop);
            factory.getRemovedWorkshops().add(workshop);
        }

        if (producedFurnitureCount > 0) {
            return String.format("%d piece%s of furniture was produced in the %s factory.",
                    producedFurnitureCount,
                    producedFurnitureCount > 1 ? "s" : "",
                    factoryName);
        } else {
            return String.format("This time %s factory did not produce anything.", factoryName);
        }
    }

    @Override
    public String getReport() {
        return "";
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Factory factory : factories) {
            sb.append(String.format("Production by %s factory:\n", factory.getName()));

            if (factory.getWorkshops().isEmpty() && factory.getRemovedWorkshops().isEmpty()) {
                sb.append("  No workshops were added to produce furniture.\n");
            } else {
                for (Workshop workshop : factory.getWorkshops()) {
                    sb.append(String.format("  %s: %d furniture produced\n",
                            workshop.getClass().getSimpleName(),
                            workshop.getProducedFurnitureCount()));
                }

                for (Workshop workshop : factory.getRemovedWorkshops()) {
                    sb.append(String.format("  %s: %d furniture produced\n",
                            workshop.getClass().getSimpleName(),
                            workshop.getProducedFurnitureCount()));
                }
            }
        }

        return sb.toString().trim();
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
