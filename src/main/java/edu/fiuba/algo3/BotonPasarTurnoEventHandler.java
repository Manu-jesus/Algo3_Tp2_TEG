package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Turno;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
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
        BackgroundImage backgroundMapa= new BackgroundImage(new Image("https://pbs.twimg.com/media/EbYRjuBXkAUfado.png:large",1550,800,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        columnaPais.setBackground(new Background(backgroundMapa));
        var mapa = new Scene(columnaPais, 1550,800);
        this.stage.setScene(mapa);
        this.stage.show();

    }
}
