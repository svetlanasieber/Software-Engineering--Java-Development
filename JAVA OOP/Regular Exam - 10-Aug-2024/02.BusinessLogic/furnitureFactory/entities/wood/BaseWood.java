package furnitureFactory.entities.wood;

public abstract class BaseWood implements Wood {
    private int woodQuantity;

    public BaseWood(int woodQuantity) {
        this.woodQuantity = woodQuantity;
    }

    @Override
    public int getWoodQuantity() {
        return woodQuantity;
    }
}

