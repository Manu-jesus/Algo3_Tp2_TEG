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

public class BotonSumarEjercitosEventHandler implements EventHandler<ActionEvent> {
    private Pais miPais;
    private Button botonPais;

    public BotonSumarEjercitosEventHandler(Button botonPais, Pais pais) {
        this.miPais = pais;
        this.botonPais = botonPais;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage stage = new Stage();
        TextField texto = new TextField();

        Button botonEnviar = new Button("Enviar");
        BotonEnviarEventHandler enviarEvent = new BotonEnviarEventHandler(stage, texto,this.botonPais, this.miPais);
        botonEnviar.setOnAction(enviarEvent);

        TextoEventHandler textoEvent = new TextoEventHandler(botonEnviar);
        texto.setOnKeyPressed(textoEvent);

        VBox botones = new VBox(texto, botonEnviar);
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 640, 480);

        stage.setScene(menu);
        stage.showAndWait();
    }
}