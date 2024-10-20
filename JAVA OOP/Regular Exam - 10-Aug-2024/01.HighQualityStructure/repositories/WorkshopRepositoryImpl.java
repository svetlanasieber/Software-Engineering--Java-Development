package furnitureFactory.repositories;

import furnitureFactory.entities.workshops.Workshop;
import java.util.ArrayList;
import java.util.Collection;

public class WorkshopRepositoryImpl implements WorkshopRepository {
    private Collection<Workshop> workshops;

    public WorkshopRepositoryImpl() {
        this.workshops = new ArrayList<>();
    }

    @Override
    public void add(Workshop workshop) {
        for (Workshop existingWorkshop : workshops) {
            if (existingWorkshop.getClass().getSimpleName().equals(workshop.getClass().getSimpleName())) {
                throw new IllegalArgumentException("Workshop of this type already exists in the repository.");
            }
        }
        if (workshop.getWoodQuantity() <= 0) {
            throw new IllegalArgumentException("Can not build workshop with zero or less wood quantity.");
        }
        workshops.add(workshop);
    }

    @Override
    public boolean remove(Workshop workshop) {
        return workshops.remove(workshop);
    }

    @Override
    public Workshop findByType(String type) {
        for (Workshop workshop : workshops) {
            if (workshop.getClass().getSimpleName().equals(type)) {
                return workshop;
            }
        }
        return null;
    }
}
