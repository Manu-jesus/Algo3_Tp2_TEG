package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonMoverEjercitosEventHandler implements EventHandler<ActionEvent> {

    private Pais atacante;
    private Button botonAtacante;
    private Stage stage;
    private Stage stageMenu;
    private InicializadorTeg mapaPais;

    public BotonMoverEjercitosEventHandler (Stage stageMenu,InicializadorTeg mapaPais ,Stage stage, Pais atacante, Button botonAtacante){
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


        Button botonElegirDefensor = new Button("Seleccinar Pais al que le quitaremos ejercitos");
        BotonElegirDefensorEventHandler elegirDefensorEvent = new BotonElegirDefensorEventHandler(stage,stageMenu,this.mapaPais, this.atacante, this.botonAtacante);
        botonElegirDefensor.setOnAction(elegirDefensorEvent);

        var menu = new Scene(botonElegirDefensor, 640, 480);

        stageMenu.setScene(menu);
        //stageMenu.showAndWait();
    }
}
