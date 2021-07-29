package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonInit implements EventHandler<ActionEvent> {

    private Stage stage;
    private InicializadorTeg juego;

    public BotonInit (Stage stage){
        this.stage = stage;
        this.juego = new InicializadorTeg();
    }


    @Override
    public void handle(ActionEvent actionEvent){

        VBox columnaPais = juego.actualizarTeg(this.stage);

        var mapa = new Scene(columnaPais, 1280, 600);
        this.stage.setScene(mapa);
        this.stage.show();
    }
}
