package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{

    public RectangularMap(int width, int height){
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight = new Vector2d(width-1, height-1);
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)){
            return animals.get(position);
        }
        return null;
    }

    public Vector2d[] setBorders(){
        return new Vector2d[]{this.lowerLeft, this.upperRight};
    }

    public List<Animal> getAnimals(){
        return new ArrayList<>(animals.values());
    }
}
