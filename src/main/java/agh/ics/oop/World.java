package agh.ics.oop;
import agh.ics.oop.gui.App;
import javafx.application.Application;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
        try {
            Application.launch(App.class, args);
        } catch(Exception ex){
            out.println(ex.getMessage());
            out.println(ex.getClass());
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