package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MapDirectionTest {
    @Test
    public void testNext(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("Wschód", MapDirection.NORTH.next().toString()),
                () -> Assertions.assertEquals("Południe", MapDirection.EAST.next().toString()),
                () -> Assertions.assertEquals("Zachód", MapDirection.SOUTH.next().toString()),
                () -> Assertions.assertEquals("Północ", MapDirection.WEST.next().toString())
        );
    }
    @Test
    public void testPrevious(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("Zachód", MapDirection.NORTH.previous().toString()),
                () -> Assertions.assertEquals("Północ", MapDirection.EAST.previous().toString()),
                () -> Assertions.assertEquals("Wschód", MapDirection.SOUTH.previous().toString()),
                () -> Assertions.assertEquals("Południe", MapDirection.WEST.previous().toString())
        );
    }
}
