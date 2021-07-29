package edu.fiuba.algo3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Button botonInit = new Button("** PLAY **");
        BotonInit iniciarEvent = new BotonInit(stage);
        botonInit.setOnAction(iniciarEvent);

        var mapa = new Scene(botonInit, 200, 200);

        stage.setScene(mapa);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}