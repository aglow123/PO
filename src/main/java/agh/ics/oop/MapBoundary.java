package agh.ics.oop;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver{

    private SortedSet<Vector2d> ox = new TreeSet<>(Comparator.comparingInt(o -> o.x));
    private SortedSet<Vector2d> oy = new TreeSet<>(Comparator.comparingInt(o -> o.y));

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        remove(oldPosition);
        add(newPosition);
    }

    private void add(Vector2d position) {
        ox.add(position);
        oy.add(position);
    }

    public void add(IMapElement object) {
        add(object.getPosition());
    }

    public void remove(Vector2d position) {
        ox.remove(position);
        oy.remove(position);
    }

    public Vector2d lowerLeft(){
        return new Vector2d(ox.first().x, oy.first().y);
    }

    public Vector2d upperRight(){
        return new Vector2d(ox.last().x, oy.last().y);
    }
}
