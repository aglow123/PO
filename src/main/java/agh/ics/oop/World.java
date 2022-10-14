package agh.ics.oop;
import java.util.Arrays;
import static java.lang.System.out;
public class World {

    public static void main(String[] args) {
        out.println("system wystartował");
        Direction[] dir = convert(args);
        run(dir);
        out.println("system zakończył działanie");
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
//    public static void run(String args) {
////        System.out.println("zwierzak idzie do przodu");
////        for (int i = 0; i<args.length();i++) {
////            System.out.print(args.toCharArray()[i]);
////            if (i+1<args.length()){
////                System.out.print(", ");
////            }
////            else System.out.print("\n");
////        }
//        for (int i = 0; i < args.length(); i++){
//            if (args.toCharArray()[i] == 'f'){
//                System.out.println("zwierzak idzie do przodu");
//            }
//            else if (args.toCharArray()[i] == 'b'){
//                System.out.println("zwierzak idzie do tyłu");
//            }
//            else if (args.toCharArray()[i] == 'r'){
//                System.out.println("zwierzak idzie w prawo");
//            }
//            else if (args.toCharArray()[i] == 'l'){
//                System.out.println("zwierzak idzie w lewo");
//            }
//        }
//    }
}
