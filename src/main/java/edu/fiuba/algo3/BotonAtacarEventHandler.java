package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonAtacarEventHandler implements EventHandler<ActionEvent> {
    private Pais atacante;
    private Button botonAtacante;
    private Stage stage;
    private Stage stageMenu;
    private InicializadorTeg mapaPais;

    public BotonAtacarEventHandler (Stage stageMenu,InicializadorTeg mapaPais ,Stage stage, Pais atacante, Button botonAtacante){
        this.stage = stage;
        this.stageMenu = stageMenu;
        this.atacante = atacante;
        this.mapaPais = mapaPais;
        this.botonAtacante = botonAtacante;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //stageMenu.close();
        //stage.close(); //CIERRO EL ORIGINAL.
        //Stage stage = new Stage();

        Button botonFinalizarAtaque = new Button("Enviar");
        //BotonFinalizarAtaqueEventHandler enviarEvent = new BotonFinalizarAtaqueEventHandler(stageMapa,stage, texto,botonAtacante, atacante, botonDefensor,  defensor, juego);
        //botonEnviar.setOnAction(enviarEvent);

        Button botonElegirDefensor = new Button("Seleccinar Pais al que atacaremos");
        BotonElegirDefensorEventHandler elegirDefensorEvent = new BotonElegirDefensorEventHandler(stage,stageMenu,this.mapaPais, this.atacante, this.botonAtacante);
        botonElegirDefensor.setOnAction(elegirDefensorEvent);

        var menu = new Scene(botonElegirDefensor, 640, 480);

        stageMenu.setScene(menu);
        //stageMenu.showAndWait();
    }
}
