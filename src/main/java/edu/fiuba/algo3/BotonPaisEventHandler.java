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
    private Stage stagePaises;
    private InicializadorTeg mapaInicio;

    public BotonPaisEventHandler(InicializadorTeg inicializador, Stage stage, Button botonPais, Pais pais) {
        this.miPais = pais;
        this.botonPais = botonPais;
        this.stagePaises = stage;
        this.mapaInicio = inicializador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stagePaises.close();
        Stage stage = new Stage();

        Button sumarEjercitos = new Button("sumarEjercitos");
        BotonEjercitosASumarEventHandler botonSumaEjercitos = new BotonEjercitosASumarEventHandler(stage, this.botonPais, this.miPais, mapaInicio);//Stage stage, Button botonAtacante, Pais atacante, InicializadorTeg juego
        sumarEjercitos.setOnAction(botonSumaEjercitos);

        Button atacar = new Button("Atacar");
        BotonAtacarEventHandler botonAtacar = new BotonAtacarEventHandler(stage, this.mapaInicio , this.stagePaises, this.miPais, this.botonPais);
        atacar.setOnAction(botonAtacar);

        Button moverEjercitos = new Button("moverEjercitos");

        VBox botones = new VBox(sumarEjercitos, atacar, moverEjercitos);
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 640, 480);

        stage.setScene(menu);
        stage.show();
    }
}
