package agh.ics.oop;

import java.util.*;


public class GrassField extends AbstractWorldMap{
    int numberOfGrass;
    Vector2d lowerLeftGrass, upperRightGrass;
    Map<Vector2d, Grass> grasses = new HashMap<>();
    private final MapBoundary mapBoundary;

    public GrassField(int n){
        this(new MapBoundary(), n);
    }

    public GrassField(MapBoundary mapBoundary, int n){
        this.mapBoundary = mapBoundary;
        this.numberOfGrass = n;
        this.lowerLeftGrass = new Vector2d(0,0);
        this.upperRightGrass = new Vector2d((int)Math.sqrt(n*10), (int)Math.sqrt(n*10));
        this.lowerLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        this.upperRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        for(int i=0; i<n; i++){
            PlantGrass();
        }
    }

    public void PlantGrass(){
        int maxX = this.upperRightGrass.x;
        int maxY = this.upperRightGrass.y;
        int x, y;
        Vector2d newPosition;
        Random rand = new Random();
        while(true) {
            x = rand.nextInt(maxX);
            y = rand.nextInt(maxY);
            newPosition = new Vector2d(x, y);
            if (!isOccupied(newPosition)){
                break;
            }
        }
        Grass grass = new Grass(newPosition);
        grasses.put(newPosition, grass);
        mapBoundary.add(grass);
    }

    public void EatAndPlantNewGrass(Vector2d position){
        PlantGrass();
        this.grasses.remove(position);
        mapBoundary.remove(position);
    }

    public boolean isPlanted(Vector2d position){
        return grasses.containsKey(position);
    }

    public boolean isOccupied(Vector2d position){
        return super.isOccupied(position) || isPlanted(position);
    }

    public Vector2d[] setBorders(){
        return new Vector2d[]{mapBoundary.lowerLeft(), mapBoundary.upperRight()};
    }

    @Override
    public boolean place(Animal animal) throws IllegalArgumentException{
        if (!canMoveTo(animal.getPosition())){
            throw new IllegalArgumentException("You cannot place an animal in the position outside the map");
        }
        if (this.isOccupied(animal.getPosition())){
            if (this.objectAt(animal.getPosition()) instanceof Animal)
                throw new IllegalArgumentException("You cannot place an animal in the position of another animal");
            else if (this.objectAt(animal.getPosition()) instanceof Grass){
                EatAndPlantNewGrass(animal.getPosition());
            }
        }
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);
        mapBoundary.add(animal);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)){
            return animals.get(position);
        }
        else if (grasses.containsKey(position)){
            return grasses.get(position);
        }
        return null;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        super.positionChanged(oldPosition, newPosition);
        mapBoundary.positionChanged(oldPosition, newPosition);
    }

}
