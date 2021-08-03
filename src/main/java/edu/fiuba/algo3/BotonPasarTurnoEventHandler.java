package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonPasarTurnoEventHandler implements EventHandler<ActionEvent> {
    private Turno turno;
    private Stage stage;
    private InicializadorTeg juego;

    public BotonPasarTurnoEventHandler(Turno turno, InicializadorTeg juego, Stage stage){
        this.turno = turno;
        this.juego = juego;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        turno.pasarTurno();
        VBox columnaPais = juego.actualizarTeg(stage);
        var mapa = new Scene(columnaPais, 1280, 600);
        this.stage.setScene(mapa);
        this.stage.show();

    }
}
