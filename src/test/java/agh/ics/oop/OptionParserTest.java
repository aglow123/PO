package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class OptionParserTest {
    @Test
    void testParse(){
        String[] test1 = new String[] {"left", "leleleft", "forward", "right", "rajt", "ala"};
        MoveDirection[] res1 = new MoveDirection[] {MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.RIGHT};
        String[] test2 = new String[] {"backward", "buck", "forfgf", "ola", "forward", "right", "forward"};
        MoveDirection[] res2 = new MoveDirection[] {MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD};
        Assertions.assertAll(
                () -> Assertions.assertArrayEquals(res1, OptionParser.parse(test1)),
                () -> Assertions.assertArrayEquals(res2, OptionParser.parse(test2))
        );
    }
}
