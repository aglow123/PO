package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void testEquals(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(0,0);
        Vector2d v3 = new Vector2d(0,1);
        Object v4 = null;
        Assertions.assertTrue(v1.equals(v1));
        Assertions.assertTrue(v1.equals(v2));
        Assertions.assertFalse(v1.equals(v3));
        Assertions.assertFalse(v1.equals(v4));
    }
    @Test
    public void testToString(){
        Vector2d v1 = new Vector2d(0,0);
        Assertions.assertEquals("(0,0)",v1.toString());
    }
    @Test
    public void testPrecedes(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(1,2);
        Assertions.assertTrue(v1.precedes(v2));
        Assertions.assertFalse(v2.precedes(v1));
        Assertions.assertTrue(v2.precedes(v2));
    }
    @Test
    public void testFollows(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(1,2);
        Assertions.assertFalse(v1.follows(v2));
        Assertions.assertTrue(v2.follows(v1));
        Assertions.assertTrue(v2.follows(v2));
    }
    @Test
    public void testUpperRight(){
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(2,0);
        Vector2d v3 = new Vector2d(2,1);
        Assertions.assertTrue(v3.x == v1.upperRight(v2).x && v3.y == v1.upperRight(v2).y);
    }
    @Test
    public void testLowerLeft(){
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(2,0);
        Vector2d v3 = new Vector2d(0,0);
        Assertions.assertTrue(v3.x == v1.lowerLeft(v2).x && v3.y == v1.lowerLeft(v2).y);
    }
    @Test
    public void testAdd(){
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(2,0);
        Vector2d v3 = new Vector2d(2,1);
        Assertions.assertTrue(v3.x == v1.add(v2).x && v3.y == v1.add(v2).y);
    }
    @Test
    public void testSubtract(){
        Vector2d v1 = new Vector2d(0,1);
        Vector2d v2 = new Vector2d(2,0);
        Vector2d v3 = new Vector2d(-2,1);
        Assertions.assertTrue(v3.x == v1.subtract(v2).x && v3.y == v1.subtract(v2).y);
    }
    @Test
    public void testOpposite(){
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(2,1);
        Vector2d v3 = new Vector2d(-2,-1);
        Assertions.assertTrue(v1.x == v1.opposite().x && v1.y == v1.opposite().y);
        Assertions.assertTrue(v3.x == v2.opposite().x && v3.y == v2.opposite().y);
        Assertions.assertTrue(v2.x == v3.opposite().x && v2.y == v3.opposite().y);
    }
    @Test
    public void testHashCode(){
        Vector2d v1 = new Vector2d(2,1);
        Vector2d v2 = new Vector2d(1,1);
        Vector2d v3 = new Vector2d(1,1);
        Assertions.assertEquals(v1.equals(v2), v1.hashCode() == v2.hashCode());
        Assertions.assertEquals(v1.equals(v3), v1.hashCode() == v3.hashCode());
    }
}
