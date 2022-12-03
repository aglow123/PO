package agh.ics.oop;

import java.util.*;


public class GrassField extends AbstractWorldMap{
    int numberOfGrass;
    Vector2d lowerLeftGrass, upperRightGrass;
    Map<Vector2d, Grass> grasses = new HashMap<>();

    public GrassField(int n){
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
        grasses.put(newPosition, new Grass(newPosition));
    }

    public void EatAndPlantNewGrass(Vector2d position){
        PlantGrass();
        this.grasses.remove(position);
    }

    public boolean isPlanted(Vector2d position){
        return grasses.containsKey(position);
    }

    public boolean isOccupied(Vector2d position){
        return super.isOccupied(position) || isPlanted(position);
    }

    public Vector2d[] setBorders(){
        Vector2d[] borders = {new Vector2d(0, 0), new Vector2d(0, 0)};
        if (!grasses.isEmpty()) {
            for(Map.Entry<Vector2d, Grass> entry: grasses.entrySet()){
                borders[0] = borders[0].lowerLeft(entry.getValue().getPosition());
                borders[1] = borders[1].upperRight(entry.getValue().getPosition());
            }
        }
        if(!animals.isEmpty()){
            for(Map.Entry<Vector2d, Animal> entry: animals.entrySet()){
                borders[0] = borders[0].lowerLeft(entry.getValue().getPosition());
                borders[1] = borders[1].upperRight(entry.getValue().getPosition());
            }
        }
        return borders;
    }

    @Override
    public boolean place(Animal animal) {
        if (!canMoveTo(animal.getPosition())){
            return false;
        }
        if (this.isOccupied(animal.getPosition())){
            if (this.objectAt(animal.getPosition()) instanceof Animal)
                return false;
            else if (this.objectAt(animal.getPosition()) instanceof Grass){
                EatAndPlantNewGrass(animal.getPosition());
            }
        }
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);

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
}
