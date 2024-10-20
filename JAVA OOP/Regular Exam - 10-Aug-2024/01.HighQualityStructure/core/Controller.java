package furnitureFactory.core;

import furnitureFactory.entities.factories.Factory;

public interface Controller {

    String buildFactory(String factoryType, String factoryName);

    Factory getFactoryByName(String factoryName);
    String buildWorkshop(String workshopType, int woodCapacity);
    String addWorkshopToFactory(String factoryName, String workshopType);
    String buyWoodForFactory(String woodType);
    String addWoodToWorkshop(String factoryName, String workshopType, String woodType);
    String produceFurniture(String factoryName);
    String getReport();

    String getStatistics();

    void exit();
}
