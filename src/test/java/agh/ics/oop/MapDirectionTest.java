package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MapDirectionTest {
    @Test
    public void testNext(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("Wschod", MapDirection.NORTH.next().toString()),
                () -> Assertions.assertEquals("Poludnie", MapDirection.EAST.next().toString()),
                () -> Assertions.assertEquals("Zachod", MapDirection.SOUTH.next().toString()),
                () -> Assertions.assertEquals("Polnoc", MapDirection.WEST.next().toString())
        );
    }
    @Test
    public void testPrevious(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("Zachod", MapDirection.NORTH.previous().toString()),
                () -> Assertions.assertEquals("Polnoc", MapDirection.EAST.previous().toString()),
                () -> Assertions.assertEquals("Wschod", MapDirection.SOUTH.previous().toString()),
                () -> Assertions.assertEquals("Poludnie", MapDirection.WEST.previous().toString())
        );
    }
}
