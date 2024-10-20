package furnitureFactory.entities.workshops;

import furnitureFactory.entities.wood.Wood;

public abstract class BaseWorkshop implements Workshop {
    private int woodQuantity;
    private int producedFurnitureCount;
    private int woodQuantityReduceFactor;

    public BaseWorkshop(int woodQuantity, int woodQuantityReduceFactor) {
        this.woodQuantity = woodQuantity;
        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
        this.producedFurnitureCount = 0;
    }

    @Override
    public int getWoodQuantity() {
        return woodQuantity;
    }

    @Override
    public int getProducedFurnitureCount() {
        return producedFurnitureCount;
    }

    @Override
    public int getWoodQuantityReduceFactor() {
        return woodQuantityReduceFactor;
    }

    @Override
    public void addWood(Wood wood) {
        woodQuantity += wood.getWoodQuantity();
    }

    @Override
    public void produce() {
        if (woodQuantity >= woodQuantityReduceFactor) {
            woodQuantity -= woodQuantityReduceFactor;
            producedFurnitureCount++;
        }
        if (woodQuantity < 0) {
            woodQuantity = 0;
        }
    }
}
