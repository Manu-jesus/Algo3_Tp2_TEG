package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.JugadorNoPuedeHacerCanje;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BotonCanjearTarjetasEventHandler implements EventHandler<ActionEvent> {

    private Stage stageMenu;
    private InicializadorTeg juego;
    private Stage stageMapa;
    private Jugador jugadorActual;

    public BotonCanjearTarjetasEventHandler(Stage stageMenu,InicializadorTeg juego, Stage stageMapa, Jugador jugadorActual){
        this.stageMenu = stageMenu;
        this.juego = juego;
        this.stageMapa = stageMapa;
        this.jugadorActual = jugadorActual;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        try{
        jugadorActual.hacerCanje();
        }catch(JugadorNoPuedeHacerCanje exception){
            this.tratarError("No se puede hacer un canje");
        }
        VBox columnaPais = juego.actualizarTeg(stageMapa);

        BackgroundImage backgroundMapa= new BackgroundImage(new Image("https://pbs.twimg.com/media/EbYRjuBXkAUfado.png:large",1300,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        columnaPais.setBackground(new Background(backgroundMapa));
        var mapa = new Scene(columnaPais, 1300,650);
        stageMenu.close();
        this.stageMapa.setScene(mapa);
    }

    public void tratarError(String mensaje){
        Stage casoError = new Stage();
        var label = new Label(mensaje);
        Scene scene = new Scene(label, 400,100);
        casoError.setScene(scene);
        casoError.showAndWait();
    }
}
