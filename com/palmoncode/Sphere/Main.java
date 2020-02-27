package com.palmoncode.Sphere;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) throws Exception{
        // create a sphere object
        Sphere sphere = new Sphere(50);

        Group group = new Group();
        group.getChildren().add(sphere);

        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.SILVER);
        scene.setCamera(camera);

        sphere.translateXProperty().set(WIDTH / 2); // moves sphere center horizontally
        sphere.translateYProperty().set(HEIGHT / 2); // moves sphere center vertically

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()){
                case W:
                    sphere.translateZProperty().set(sphere.getTranslateZ() + 1000);
                    break;
                case S:
                    sphere.translateZProperty().set(sphere.getTranslateZ() + -1000);
                    break;
            }
        });

        primaryStage.setTitle("Palmoncode");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
