package furnitureFactory.entities.workshops;

import furnitureFactory.entities.wood.Wood;

public interface Workshop {

    int getWoodQuantity();
    int getProducedFurnitureCount();
    int getWoodQuantityReduceFactor();
    void addWood(Wood wood);
    void produce();
}