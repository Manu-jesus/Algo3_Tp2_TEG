package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonElegirDefensorEventHandler implements EventHandler<ActionEvent> {
    private InicializadorTeg mapaPais;
    private Button botonAtacante;
    private Pais atacante;
    private Stage stage;

    public BotonElegirDefensorEventHandler(Stage stage, InicializadorTeg mapaPais, Pais atacante, Button botonAtacante){
        this.stage = stage;
        this.mapaPais = mapaPais;
        this.atacante = atacante;
        this.botonAtacante = botonAtacante;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        VBox nuevoMapa = this.mapaPais.copiarMapa(stage, botonAtacante, atacante);

        var mapa = new Scene(nuevoMapa, 640, 480);
        stage.setScene(mapa);
        //stage.showAndWait();

    }
}
