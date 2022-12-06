package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OptionParserTest {

    @Test
    void testParseWithWrongDirection() {
        String[] testDirections = new String[] {"left", "leleleft", "forward", "right", "rajt", "ala"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> OptionParser.parse(testDirections));
    }

    @Test
    void testParseWithGoodDirections() {
        String[] test1 = new String[] {"l", "f", "r", "b"};
        String[] test2 = new String[] {"left", "forward", "right", "backward"};
        MoveDirection[] res = new MoveDirection[] {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.BACKWARD};
        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(res, OptionParser.parse(test1)),
                () -> Assertions.assertArrayEquals(res, OptionParser.parse(test2))
        );
    }
}
