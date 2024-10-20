package furnitureShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ShopTests {

    private Shop shop;
    private Furniture furniture;

    @BeforeEach
    public void setUp() {
        shop = new Shop("MyShop", 5);
        furniture = new Furniture("Chair", "Wooden", 100);
    }

    @Test
    public void testConstructor() {
        Assertions.assertEquals("MyShop", shop.getType());
        Assertions.assertEquals(5, shop.getCapacity());
        Assertions.assertEquals(0, shop.getCount());
    }

    @Test
    public void testAddFurniture() {
        shop.addFurniture(furniture);
        Assertions.assertEquals(1, shop.getCount());
        Assertions.assertTrue(shop.getFurnitures().contains(furniture));
    }

    @Test
    public void testAddFurnitureThrowsIfFull() {
        shop = new Shop("MyShop", 1);
        shop.addFurniture(furniture);
        Assertions.assertThrows(IllegalArgumentException.class, () -> shop.addFurniture(new Furniture("Table", "Metal", 150)));
    }

    @Test
    public void testAddFurnitureThrowsIfAlreadyExists() {
        shop.addFurniture(furniture);
        Assertions.assertThrows(IllegalArgumentException.class, () -> shop.addFurniture(new Furniture("Chair", "Wooden", 120)));
    }

    @Test
    public void testAddFurnitureThrowsIfNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> shop.addFurniture(null));
    }

    @Test
    public void testRemoveFurniture() {
        shop.addFurniture(furniture);
        boolean result = shop.removeFurniture(furniture.getType());
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, shop.getCount());
    }

    @Test
    public void testRemoveFurnitureReturnsFalseIfNotFound() {
        boolean result = shop.removeFurniture("Table");
        Assertions.assertFalse(result);
    }

    @Test
    public void testGetCheapestFurniture() {
        shop.addFurniture(furniture);
        shop.addFurniture(new Furniture("Table", "Metal", 80));
        String cheapest = shop.getCheapestFurniture();
        Assertions.assertEquals("Table", cheapest);
    }

    @Test
    public void testGetFurnituresReturnsUnmodifiableList() {
        shop.addFurniture(furniture);
        List<Furniture> furnitures = shop.getFurnitures();
        Assertions.assertThrows(UnsupportedOperationException.class, () -> furnitures.add(new Furniture("Table", "Metal", 80)));
    }

    @Test
    public void testFindAllFurnitureByType() {
        shop.addFurniture(furniture);
        shop.addFurniture(new Furniture("Table", "Wooden", 200));
        List<Furniture> woodenFurniture = shop.findAllFurnitureByType("Wooden");
        Assertions.assertEquals(2, woodenFurniture.size());
    }

    @Test
    public void testSetCapacityThrowsIfNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> shop.setCapacity(-1));
    }
}
