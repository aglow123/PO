package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    @Test
    void testCanMoveToEmptyCell() {
        var map = new RectangularMap(5, 5);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 4)));
    }

    @Test
    void testCanMoveToCellOutOfTheRange() {
        var map = new RectangularMap(5, 5);
        Assertions.assertFalse(map.canMoveTo(new Vector2d(4, 6)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(-1, 4)));
    }

    @Test
    void testCanMoveToOccupiedCell() {
        var map = new RectangularMap(5, 5);
        new Animal(map);
        Assertions.assertFalse(map.canMoveTo(new Vector2d(2, 2)));
    }

    @Test
    void testPlaceTwoAnimalsInOneCell() {
        var map = new RectangularMap(5, 5);
        new Animal(map);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Animal(map));
    }

    @Test
    void testPlaceTwoAnimalsOnMap(){
        var map = new RectangularMap(5, 5);
        new Animal(map, new Vector2d(2,3));
        Assertions.assertDoesNotThrow(() -> new Animal(map));
    }

    @Test
    void testPlaceAnimalInCellOutOfTheRange() {
        var map = new RectangularMap(5, 5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Animal(map, new Vector2d(5, 5)));
    }
    @Test
    void testIsOccupied(){
        var map = new RectangularMap(5, 5);
        Assertions.assertFalse(map.isOccupied(new Vector2d(2, 2)));
        new Animal(map);
        Assertions.assertFalse(map.isOccupied(new Vector2d(5, 2)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    void testIsOccupiedOutOfIndex() {
        var map = new RectangularMap(5, 5);
        Assertions.assertFalse(map.isOccupied(new Vector2d(5, 2)));
    }

    @Test
    void testObjectAtEmpty() {
        var map = new RectangularMap(5, 5);
        var turtle = new Animal(map);
        Assertions.assertEquals(null, map.objectAt(new Vector2d(2, 3)));
        Assertions.assertEquals(null, map.objectAt(new Vector2d(6, 2)));
        Assertions.assertEquals(turtle, map.objectAt(new Vector2d(2, 2)));
    }
}
