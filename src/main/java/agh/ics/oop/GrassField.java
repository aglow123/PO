package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GrassField extends AbstractWorldMap{
    int numberOfGrass;
    Vector2d lowerLeftGrass, upperRightGrass;
    List<Grass> grasses = new ArrayList<>();

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
        grasses.add(new Grass(newPosition));
    }

    public void EatAndPlantNewGrass(Vector2d position){
        int index = 0;
        for (Grass grass: this.grasses){
            if (grass.getPosition().equals(position)) {
                index = grasses.indexOf(grass);
                break;
            }
        }
        PlantGrass();
        this.grasses.remove(index);
    }

    public boolean isPlanted(Vector2d position){
        for (Grass grass: grasses){
            if (grass.getPosition().equals(position))
                return true;
        }
        return false;
    }
    public boolean isOccupied(Vector2d position){
        return super.isOccupied(position) || isPlanted(position);
    }

    public Vector2d[] setBorders(){
        Vector2d[] borders = {new Vector2d(0, 0), new Vector2d(0, 0)};
        if (!grasses.isEmpty()) {
            for(Grass grass: grasses){
                borders[0] = borders[0].lowerLeft(grass.getPosition());
                borders[1] = borders[1].upperRight(grass.getPosition());
            }
        }
        if(!animals.isEmpty()){
            for(Animal animal: animals){
                borders[0] = borders[0].lowerLeft(animal.getPosition());
                borders[1] = borders[1].upperRight(animal.getPosition());
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
                grasses.remove(new Grass(animal.getPosition()));
                PlantGrass();
            }
        }
        animals.add(animal);
        return true;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals) {
            if (animal.getPosition().equals(position))
                return animal;
        }
        for (Grass grass: grasses){
            if(grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }
}
