package agh.ics.oop;

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
            this.positions[i% positions.length] = animal.getPosition();
//            if (map instanceof GrassField && ((GrassField) map).isPlanted(animal.getPosition())) {
//                ((GrassField) map).EatAndPlantNewGrass(animal.getPosition());
//            }
            System.out.println("round " + i + "\n move " + move);
            System.out.println(this.map);
            i++;
        }
    }
}
