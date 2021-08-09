package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BotonFinalizarMovidaEventHandler implements EventHandler<ActionEvent> {
    private TextField texto;
    private Stage stage;
    private Stage stageMapa;
    private Button botonAtacante;
    private Pais atacante;
    private Button botonDefensor;
    private Pais defensor;

    private InicializadorTeg juego;
    public BotonFinalizarMovidaEventHandler(Stage stageMapa, Stage stage, TextField texto, Button botonAtacante, Pais atacante, Button paisDefensor, Pais defensor, InicializadorTeg juego){
        this.stage = stage;
        this.stageMapa = stageMapa;
        this.texto = texto;
        this.botonAtacante = botonAtacante;
        this.atacante = atacante;
        this.botonDefensor = paisDefensor;
        this.defensor = defensor;
        this.juego = juego;
}

    @Override
    public void handle(ActionEvent actionEvent){

        if (!this.esNumero(this.texto.getText())){
            this.tratarError("El contenido ingresado debe ser un número");
            return;
        }
        try {
            juego.mover(texto, botonAtacante, atacante, botonDefensor, defensor);
        }catch (ElPaisAtacanteSiempreDebeMantenerUnEjercitoEnElPaisError exception){
            this.tratarError("No se puede atacar con  esa cantidad de ejercitos");
        }catch (ElPaisAtacanteNoTePerteneceError exception){
            this.tratarError("No te pertenece el pais atacante");
        }catch (ElTurnoYaNoTePermiteAtacarError exception){
            this.tratarError("No se puede atacar despues de agregar ejercitos");
        }catch (LosPaisesNoSonLimitrofesError exception){
            this.tratarError("Solo se puede atacar a un país limitrofe o conectado");
        }


        VBox actualizado = juego.actualizarTeg(stageMapa);
        BackgroundImage backgroundMapa= new BackgroundImage(new Image("https://pbs.twimg.com/media/EbYRjuBXkAUfado.png:large",1300,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        actualizado.setBackground(new Background(backgroundMapa));
        var mapa = new Scene(actualizado, 1300,650);
        stage.close();
        stageMapa.setScene(mapa);
    }

    public void tratarError(String mensaje){
        Stage casoError = new Stage();
        var label = new Label(mensaje);
        Scene scene = new Scene(label, 400,100);
        casoError.setScene(scene);
        casoError.showAndWait();
    }

    public boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
}
