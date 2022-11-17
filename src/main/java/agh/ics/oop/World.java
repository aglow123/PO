package agh.ics.oop;
import java.util.Arrays;
import java.util.LinkedList;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,3) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        out.println();
        out.println(map);
        out.println("");
        engine.run();
        out.println(map);

//        MoveDirection[] directions = new OptionParser().parse(args);
//        IWorldMap map = new RectangularMap(10, 5);
//        Vector2d[] positions = { new Vector2d(3,4), new Vector2d(3,4) };
//        IEngine engine = new SimulationEngine(directions, map, positions);
//        out.println(map);
//        out.println("");
//        engine.run();
//        out.println(map);

    }
    public static void run(Direction[] dir){
        for (Direction direction : dir) {
            switch (direction) {
                case F:
                    out.println("zwierzak idzie do przodu");
                    break;
                case B:
                    out.println("zwierzak idzie do tyłu");
                    break;
                case R:
                    out.println("zwierzak idzie w prawo");
                    break;
                case L:
                    out.println("zwierzak idzie w lewo");
                    break;
            }
        }
    }
    public static Direction[] convert(String[] arr) {
        Direction[] dir = new Direction[arr.length];
        int j = 0;
        for (String el:arr) {
            if (el.equals("f")){
                dir[j] = Direction.F;
                j++;
            }
            else if (el.equals("b")){
                dir[j] = Direction.B;
                j++;
            }
            else if (el.equals("r")){
                dir[j] = Direction.R;
                j++;
            }
            else if (el.equals("l")) {
                dir[j] = Direction.L;
                j++;
            }
        }
        if (j == arr.length-1){
            return dir;
        }
        else {
            return Arrays.copyOfRange(dir,0,j);
        }
    }
}
//Mechanizm, który wykluczałby pojawienie się dwóch zwierząt
// w tym samym miejscu:
//macierz 5x5 - wielkość mapy
//wartosci 0/1 czy istnieje zwierze na danej pozycji
//przed wykonaniem ruchu sprawdzić czy na docelowej pozycji jest 0
//jezeli tak, wykonac ruch
//w momencie wykonywania ruchu zmienic wartosc opuszczanej pozycji na 0
//i docelowej pozycji na 1