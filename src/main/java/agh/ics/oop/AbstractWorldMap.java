package agh.ics.oop;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    Vector2d lowerLeft, upperRight;
    Map<Vector2d, Animal> animals = new HashMap<>();

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
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    @Override
    public String toString() {
        Vector2d[] borders = setBorders();
        return new MapVisualizer(this).draw(borders[0], borders[1]);
    }

    abstract public Vector2d[] setBorders();

    public void deleteAt(Vector2d position){
        animals.remove(position);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        animals.put(newPosition, animals.get(oldPosition));
        animals.remove(oldPosition);
    }

}
