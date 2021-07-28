package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonEnviarEventHandler implements EventHandler<ActionEvent> {
    private TextField texto;
    private Stage stage;
    private Button botonAtacante;
    private Pais atacante;
    private Button botonDefensor;
    private Pais defensor;

    private InicializadorTeg juego;

    public BotonEnviarEventHandler (Stage stage, TextField texto,Button botonAtacante, Pais atacante, Button paisDefensor, Pais defensor, InicializadorTeg juego){
        this.stage = stage;
        this.texto = texto;
        this.botonAtacante = botonAtacante;
        this.atacante = atacante;
        this.botonDefensor = paisDefensor;
        this.defensor = defensor;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        juego.atacar(texto, botonAtacante, atacante, botonDefensor, defensor);

        //this.stage.close();

        VBox actualizado = juego.actualizarTeg(stage);
        var mapa = new Scene(actualizado, 640, 480);

        stage.setScene(mapa);
        //stage.showAndWait();
    }
}
