package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonEjercitosASumarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Button botonAtacante;
    private Pais atacante;
    private InicializadorTeg juego;

    public BotonEjercitosASumarEventHandler(Stage stage, Button botonAtacante, Pais atacante, InicializadorTeg juego){

        this.stage = stage;
        this.botonAtacante = botonAtacante;
        this.atacante = atacante;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextField texto = new TextField();

        Button botonSumar = new Button("Sumar");
        BotonSumarEventHandler sumarEvent = new BotonSumarEventHandler(stage, texto, botonAtacante, atacante, juego);
        botonSumar.setOnAction(sumarEvent);

        TextoEventHandler textoEvent = new TextoEventHandler(botonSumar);
        texto.setOnKeyPressed(textoEvent);

        VBox botones = new VBox(texto, botonSumar);
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 640, 480);

        stage.setScene(menu);
    }
}
