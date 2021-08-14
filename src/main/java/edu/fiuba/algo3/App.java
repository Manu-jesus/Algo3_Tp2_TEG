package edu.fiuba.algo3;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Label label = new Label("Cantidad de jugadores: ");

        TextField texto = new TextField();

        Button botonInit = new Button("** PLAY **");
        BotonInit iniciarEvent = new BotonInit(stage, texto);
        botonInit.setOnAction(iniciarEvent);
        botonInit.setMinSize(100, 100);

        TextoEventHandler textoEvent = new TextoEventHandler(botonInit);
        texto.setOnKeyPressed(textoEvent);

        HBox datosIniciales = new HBox(label, texto);
        datosIniciales.setSpacing(5);

        VBox botones = new VBox(datosIniciales, botonInit);
        botones.setMargin(botonInit,new Insets(10,0,0,150));
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 450, 220);

        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}