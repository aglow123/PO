package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import static java.lang.String.format;


public class App extends javafx.application.Application{

    @Override
    public void start(Stage primaryStage) throws IllegalArgumentException {
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] directions = OptionParser.parse(args);
        AbstractWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 3), new Vector2d(3, 8)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println("ok");
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(20, 20, 20, 20));
        drawHeader(map, grid);
        drawObjects(map, grid);

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void drawHeader(AbstractWorldMap map, GridPane grid){
        Label label = new Label("y\\x");
        grid.add(label, 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));
        GridPane.setHalignment(label, HPos.CENTER);
//        System.out.println(format("lowerleft %d, %d, upperright %d, %d", map.setBorders()[0].x, map.setBorders()[0].y, map.setBorders()[1].x, map.setBorders()[1].y));
        for (int i = map.setBorders()[0].x; i <= map.setBorders()[1].x; i++) {
            label = new Label(format("%d", i));
            grid.add(label, i - map.setBorders()[0].x + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(20));
            GridPane.setHalignment(label, HPos.CENTER);

        }
        for (int j = map.setBorders()[0].y; j <= map.setBorders()[1].y; j++) {
            label = new Label(format("%d", j));
            grid.add(label, 0, map.setBorders()[1].y - j + 1);
            grid.getRowConstraints().add(new RowConstraints(20));
            GridPane.setHalignment(label, HPos.CENTER);
        }
    }

    void drawObjects(AbstractWorldMap map, GridPane grid){
        for (int i = map.setBorders()[0].x; i <= map.setBorders()[1].x; i++) {
            for (int j = map.setBorders()[0].y; j <= map.setBorders()[1].y; j++) {
                Object toAdd = map.objectAt(new Vector2d(i, j));
                if (toAdd == null) {
                    continue;
                }
                Label label = new Label(toAdd.toString());
//                System.out.println(format("%d, %d", i, j));
                grid.add(label, i - map.setBorders()[0].x + 1, map.setBorders()[1].y - j + 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }

    }
}
