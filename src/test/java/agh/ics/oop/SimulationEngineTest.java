package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SimulationEngineTest {
    @Test
    void runWithOneAnimal() {
        MoveDirection[] directions = new OptionParser().parse(new String[] {"f","l"});
        RectangularMap map = new RectangularMap(5, 5);
        Vector2d[] positions = {new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Animal> animals = map.getAnimals();
        var animalExpectedPosition = new Vector2d(2, 4);
        var animalExpectedDirection = MapDirection.WEST;
        Assertions.assertEquals(animalExpectedPosition, animals.get(0).getPosition());
        Assertions.assertEquals(animalExpectedDirection, animals.get(0).getOrientation());
    }

    @Test
    void runWithTwoAnimals() {
        MoveDirection[] directions = new OptionParser().parse(new String[] {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        List<Animal> animals = map.getAnimals();
        var animal1ExpectedPosition = new Vector2d(2, 0);
        var animal2ExpectedPosition = new Vector2d(3, 4);
        var animal1ExpectedDirection = MapDirection.SOUTH;
        var animal2ExpectedDirection = MapDirection.NORTH;

        Assertions.assertEquals(animal1ExpectedPosition, animals.get(0).getPosition());
        Assertions.assertEquals(animal1ExpectedDirection, animals.get(0).getOrientation());
        Assertions.assertEquals(animal2ExpectedPosition, animals.get(1).getPosition());
        Assertions.assertEquals(animal2ExpectedDirection, animals.get(1).getOrientation());
    }

}
