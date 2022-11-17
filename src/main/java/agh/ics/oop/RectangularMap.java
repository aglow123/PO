package agh.ics.oop;

import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height){
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1, height-1);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: animals) {
            if (animal.getPosition().equals(position))
                return animal;
        }
        return null;
    }

    public Vector2d[] setBorders(){
        Vector2d[] borders = {this.lowerLeft, this.upperRight};
//        //dla dynamicznego liczenia granic
//        if(!animals.isEmpty()){
//            for(Animal animal: animals){
//                borders[0] = borders[0].lowerLeft(animal.getPosition());
//                borders[1] = borders[1].upperRight(animal.getPosition());
//            }
//        }
        return borders;
    }

    public List<Animal> getAnimals(){
        return animals;
    }
}
