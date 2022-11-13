package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    void testOrientation(){
        var map = new RectangularMap(5, 5);
        Animal turtle = new Animal(map);
        Assertions.assertEquals(MapDirection.NORTH, turtle.getOrientation());
        turtle.move(MoveDirection.RIGHT);
        Assertions.assertEquals(MapDirection.EAST, turtle.getOrientation());
        turtle.move(MoveDirection.LEFT);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.LEFT);
        Assertions.assertEquals(MapDirection.WEST, turtle.getOrientation());
        turtle.move(MoveDirection.LEFT);
        turtle.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(MapDirection.SOUTH, turtle.getOrientation());
    }

    @Test
    void testPosition(){
        var map = new RectangularMap(5, 5);
        Animal turtle = new Animal(map);
        Assertions.assertEquals(new Vector2d(2,2), turtle.getPosition());
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(2,3), turtle.getPosition());
        turtle.move(MoveDirection.LEFT);
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(1,3), turtle.getPosition());
        turtle.move(MoveDirection.BACKWARD);
        turtle.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(new Vector2d(3,3), turtle.getPosition());
        turtle.move(MoveDirection.RIGHT);
        turtle.move(MoveDirection.BACKWARD);
        Assertions.assertEquals(new Vector2d(3,2), turtle.getPosition());
    }

    @Test
    void testBorders(){
        var map = new RectangularMap(5, 5);
        Animal turtle = new Animal(map);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(2,4), turtle.getPosition());
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(2,4), turtle.getPosition());
        turtle.move(MoveDirection.LEFT);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(0,4), turtle.getPosition());
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(0,4), turtle.getPosition());
        turtle.move(MoveDirection.LEFT);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(0,0), turtle.getPosition());
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(0,0), turtle.getPosition());
        turtle.move(MoveDirection.LEFT);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.FORWARD);
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(4,0), turtle.getPosition());
        turtle.move(MoveDirection.FORWARD);
        Assertions.assertEquals(new Vector2d(4,0), turtle.getPosition());
    }

    @Test
    void testIsAt(){
        var map = new RectangularMap(5, 5);
        Animal turtle = new Animal(map);
        Assertions.assertTrue(turtle.isAt(new Vector2d(2,2)));
    }
}
