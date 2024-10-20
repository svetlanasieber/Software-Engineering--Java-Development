package furnitureFactory.entities.workshops;

public class DeckingWorkshop extends BaseWorkshop {
    private static final int DECKING_WOOD_QUANTITY_REDUCE_FACTOR = 150;

    public DeckingWorkshop(int woodQuantity) {
        super(woodQuantity, DECKING_WOOD_QUANTITY_REDUCE_FACTOR);
    }
}
