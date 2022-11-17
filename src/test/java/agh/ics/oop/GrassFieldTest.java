package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {

    @Test
    void testPlantGrass(){
        var map = new GrassField(10);
        Assertions.assertEquals(10, map.grasses.size());
    }

    @Test
    void testCanMoveToEmptyCell() {
        var map = new GrassField(10);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(1, 4)));
    }

    @Test
    void testPlaceTwoAnimalsInOneCell() {
        var map = new GrassField(10);
        new Animal(map);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Animal(map));
    }

    @Test
    void testPlaceTwoAnimalsOnMap(){
        var map = new GrassField(10);
        new Animal(map, new Vector2d(2,3));
        Assertions.assertDoesNotThrow(() -> new Animal(map));
    }

    @Test
    void testIsOccupied(){
        var map = new GrassField(10);
        Assertions.assertFalse(map.isOccupied(new Vector2d(2, 2)));
        new Animal(map);
        Assertions.assertFalse(map.isOccupied(new Vector2d(5, 2)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    void testObjectAt() {
        var map = new GrassField(10);
        var turtle = new Animal(map);
        Assertions.assertEquals(null, map.objectAt(new Vector2d(2, 3)));
        Assertions.assertEquals(null, map.objectAt(new Vector2d(6, 2)));
        Assertions.assertEquals(turtle, map.objectAt(new Vector2d(2, 2)));
    }
}
