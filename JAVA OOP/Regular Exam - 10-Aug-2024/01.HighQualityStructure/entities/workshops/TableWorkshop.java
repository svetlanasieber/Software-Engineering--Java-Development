package furnitureFactory.entities.workshops;

public class TableWorkshop extends BaseWorkshop {
    private static final int TABLE_WOOD_QUANTITY_REDUCE_FACTOR = 50;

    public TableWorkshop(int woodQuantity) {
        super(woodQuantity, TABLE_WOOD_QUANTITY_REDUCE_FACTOR);
    }
}