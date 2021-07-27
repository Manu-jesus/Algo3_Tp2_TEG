package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonPaisEventHandler implements EventHandler<ActionEvent> {
    private Pais miPais;
    private Button botonPais;

    public BotonPaisEventHandler(Button botonPais, Pais pais) {
        this.miPais = pais;
        this.botonPais = botonPais;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        Button sumarEjercitos = new Button("sumarEjercitos");
        BotonSumarEjercitosEventHandler botonSumaEjercitos = new BotonSumarEjercitosEventHandler(this.botonPais, this.miPais);
        sumarEjercitos.setOnAction(botonSumaEjercitos);

        Button Atacar = new Button("Atacar");
        Button moverEjercitos = new Button("moverEjercitos");

        VBox botones = new VBox(sumarEjercitos, Atacar, moverEjercitos);
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 640, 480);

        Stage stage = new Stage();
        stage.setScene(menu);
        stage.showAndWait();
        stage.close();
    }
}
