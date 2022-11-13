package agh.ics.oop;

import java.util.LinkedList;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] positions;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
       this.moves = moves;
       this.map = map;
       this.positions = positions;
        for (Vector2d position: positions) {
            Animal animal = new Animal(this.map, position);
        }
    }
    @Override
    public void run() {
        int i = 0;
        for (MoveDirection move : moves) {
            Animal animal = (Animal) this.map.objectAt(this.positions[i%positions.length]);
            animal.move(move);
//            System.out.println("round " + i);
//            System.out.println(this.map);
            this.positions[i% positions.length] = animal.getPosition();
            i++;
        }
    }
}
