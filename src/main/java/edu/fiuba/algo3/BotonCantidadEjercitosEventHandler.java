package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BotonCantidadEjercitosEventHandler implements EventHandler<ActionEvent> {

    private Stage stageMapa;
    private Button botonAtacante;
    private Pais atacante;
    private Button botonDefensor;
    private Pais defensor;
    private InicializadorTeg juego;
    private boolean esAtaque;

    public BotonCantidadEjercitosEventHandler(boolean esAtaque, Stage stageMapa, Button botonAtacante, Pais atacante, Button botonDefensor, Pais defensor, InicializadorTeg juego) {
        this.stageMapa = stageMapa;
        this.botonAtacante = botonAtacante;
        this.atacante = atacante;
        this.botonDefensor = botonDefensor;
        this.defensor = defensor;
        this.juego = juego;
        this.esAtaque = esAtaque;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TextField texto = new TextField();
        Stage stage = new Stage();

        VBox actualizado = juego.actualizarTeg(stageMapa);
        BackgroundImage backgroundMapa= new BackgroundImage(new Image("https://pbs.twimg.com/media/EbYRjuBXkAUfado.png:large",1300,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        actualizado.setBackground(new Background(backgroundMapa));
        var mapa = new Scene(actualizado, 1300,650);
        stageMapa.setScene(mapa);

        Button botonEnviar = new Button("Enviar ejercitos");
        if (esAtaque) {
            BotonFinalizarAtaqueEventHandler atacarEvent = new BotonFinalizarAtaqueEventHandler(stageMapa, stage, texto, botonAtacante, atacante, botonDefensor, defensor, juego);
            botonEnviar.setOnAction(atacarEvent);
        }
        else {
            BotonFinalizarMovidaEventHandler moverEvent = new BotonFinalizarMovidaEventHandler(stageMapa, stage, texto, botonAtacante, atacante, botonDefensor, defensor, juego);
            botonEnviar.setOnAction(moverEvent);
        }
        TextoEventHandler textoEvent = new TextoEventHandler(botonEnviar);
        texto.setOnKeyPressed(textoEvent);

        VBox botones = new VBox(texto, botonEnviar);
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 640, 480);

        stage.setScene(menu);
        stage.show();
    }
}