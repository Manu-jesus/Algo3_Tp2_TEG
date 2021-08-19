package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonTarjetaPaisEventHandler implements EventHandler<ActionEvent> {

    private InicializadorTeg juego;
    private Stage stage;
    private Jugador jugadorActual;

    public BotonTarjetaPaisEventHandler(InicializadorTeg juego, Stage stage, Jugador jugadorActual){

        this.juego = juego;
        this.stage = stage;
        this.jugadorActual = jugadorActual;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        String texto = "Tus tarjetas pais son: ";
        for(int i=0;i<jugadorActual.tarjetaPais().size();i++){
            texto += jugadorActual.tarjetaPais().get(i).pais().nombre() + "  ";
        }

        Stage otroStage = new Stage();

        Button canjearTarjetas = new Button("Canjear tarjetas");
        BotonCanjearTarjetasEventHandler canjearEvent = new BotonCanjearTarjetasEventHandler(otroStage,this.juego,this.stage,this.jugadorActual);
        canjearTarjetas.setOnAction(canjearEvent);

        Button activarTarjeta = new Button("Activar tarjetas pais");
        BotonActivarTarjetaEventHandler activarTarjetaEvent = new BotonActivarTarjetaEventHandler(otroStage,this.juego,this.stage,this.jugadorActual);
        activarTarjeta.setOnAction(activarTarjetaEvent);

        var label = new Label(texto);
        VBox botones = new VBox(label,canjearTarjetas,activarTarjeta);
        botones.setPadding(new Insets(30));

        var menu = new Scene(botones,600,200);

        otroStage.setScene(menu);
        otroStage.showAndWait();
    }
}
