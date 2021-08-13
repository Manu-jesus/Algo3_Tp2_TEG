package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonObjetivoEventHandler implements EventHandler<ActionEvent> {

    private InicializadorTeg juego;
    private Stage stage;
    private Jugador jugadorActual;

    public BotonObjetivoEventHandler(InicializadorTeg juego, Stage stage, Jugador jugadorActual){

        this.juego = juego;
        this.stage = stage;
        this.jugadorActual = jugadorActual;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        String texto = jugadorActual.obtenerNombreObjetivo();

        Stage otroStage = new Stage();

        var label = new Label(texto);
        VBox botones = new VBox(label);
        botones.setPadding(new Insets(30));

        var menu = new Scene(botones);

        otroStage.setScene(menu);
        otroStage.showAndWait();
    }
}
