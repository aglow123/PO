package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap{
    Vector2d lowerLeft, upperRight;
    List<Animal> animals = new ArrayList<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(this.lowerLeft) && position.precedes(this.upperRight);
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())){
            return false;
        }
        if (this.isOccupied(animal.getPosition())){
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal: animals) {
            if (animal.getPosition().equals(position))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        Vector2d[] borders = setBorders();
        return new MapVisualizer(this).draw(borders[0], borders[1]);
    }

    abstract public Vector2d[] setBorders();
}
