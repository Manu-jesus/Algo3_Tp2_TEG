package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BotonInit implements EventHandler<ActionEvent> {

    private Stage stage;
    private InicializadorTeg juego;

    public BotonInit (Stage stage, TextField texto){
        this.stage = stage;
        this.juego = new InicializadorTeg(texto);
    }


    @Override
    public void handle(ActionEvent actionEvent){

        VBox columnaPais = juego.actualizarTeg(stage);

        BackgroundImage backgroundMapa= new BackgroundImage(new Image("https://pbs.twimg.com/media/EbYRjuBXkAUfado.png:large",1550,800,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        columnaPais.setBackground(new Background(backgroundMapa));
        var mapa = new Scene(columnaPais, 1550,800);
        this.stage.setScene(mapa);
        this.stage.show();
    }
}
