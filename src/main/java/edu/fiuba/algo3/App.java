package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Dados dadosAzul = new Dados();
        Continente america = new Continente();
        tarjetaObjetivo objetivoAzul = new tarjetaObjetivo(america);
        Jugador azul = new Jugador(dadosAzul,objetivoAzul);

        Pais arg = new Pais(4, azul, america);
        Pais eeuu = new Pais(3, azul, america);

        Dados dadosRojo = new Dados();
        tarjetaObjetivo objetivoRojo = new tarjetaObjetivo(america);
        Jugador rojo = new Jugador(dadosRojo,objetivoRojo);
        Pais bra = new Pais(4, rojo, america);
        Pais canada = new Pais(6, rojo, america);

        Button argentina = new Button( Integer.toString(arg.ejercitos()));
        BotonPaisEventHandler botonArgentina = new BotonPaisEventHandler(argentina, arg);
        argentina.setOnAction(botonArgentina);
        argentina.setPrefSize(100,100);

        Button botonEEUU = new Button( Integer.toString(eeuu.ejercitos()));
        botonEEUU.setPrefSize(100,100);

        Button brasil = new Button(Integer.toString(bra.ejercitos()));
        brasil.setPrefSize(100,100);

        Button botonCanada = new Button(Integer.toString(canada.ejercitos()));
        botonCanada.setPrefSize(100,100);

        HBox filaPais = new HBox( botonEEUU, botonCanada);
        filaPais.setSpacing(20);
        filaPais.setPadding(new Insets(35));

        VBox columnaPais = new VBox(filaPais, argentina, brasil );
        columnaPais.setSpacing(20);
        columnaPais.setPadding(new Insets(35));

        var mapa = new Scene(columnaPais, 640, 480);

        stage.setScene(mapa);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}