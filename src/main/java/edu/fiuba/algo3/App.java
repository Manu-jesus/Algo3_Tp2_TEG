package edu.fiuba.algo3;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        TextField texto = new TextField();

        Button botonInit = new Button("** PLAY **");
        BotonInit iniciarEvent = new BotonInit(stage, texto);
        botonInit.setOnAction(iniciarEvent);

        TextoEventHandler textoEvent = new TextoEventHandler(botonInit);
        texto.setOnKeyPressed(textoEvent);

        VBox botones = new VBox(texto, botonInit);
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 640, 480);

        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}