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

public class BotonCantidadEjercitosEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Button botonAtacante;
    private Pais atacante;
    private Button botonDefensor;
    private Pais defensor;
    private InicializadorTeg juego;

    public BotonCantidadEjercitosEventHandler(Stage stage, Button botonAtacante, Pais atacante, Button botonDefensor, Pais defensor, InicializadorTeg juego) {

        this.stage = stage;
        this.botonAtacante = botonAtacante;
        this.atacante = atacante;
        this.botonDefensor = botonDefensor;
        this.defensor = defensor;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextField texto = new TextField();

        Button botonEnviar = new Button("Enviar");
        BotonFinalizarAtaqueEventHandler enviarEvent = new BotonFinalizarAtaqueEventHandler(stage, texto,botonAtacante, atacante, botonDefensor,  defensor, juego);
        botonEnviar.setOnAction(enviarEvent);

        TextoEventHandler textoEvent = new TextoEventHandler(botonEnviar);
        texto.setOnKeyPressed(textoEvent);

        VBox botones = new VBox(texto, botonEnviar);
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 640, 480);

        stage.setScene(menu);
    }
}