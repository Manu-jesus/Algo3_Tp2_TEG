package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.ElPaisAtacanteSiempreDebeMantenerUnEjercitoEnElPaisError;
import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BotonSumarEventHandler implements EventHandler<ActionEvent> {

    private TextField texto;
    private Stage stage;
    private Button botonAtacante;
    private Pais atacante;

    private InicializadorTeg juego;

    public BotonSumarEventHandler (Stage stage, TextField texto,Button botonAtacante, Pais atacante, InicializadorTeg juego){
        this.stage = stage;
        this.texto = texto;
        this.botonAtacante = botonAtacante;
        this.atacante = atacante;
        this.juego = juego;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        if (!this.esNumero(this.texto.getText())){
            Stage casoError = new Stage();
            var label = new Label("El contenido ingresado debe ser un número");
            Scene scene = new Scene(label, 400,100);
            casoError.setScene(scene);
            casoError.showAndWait();
            return;
        }
        try {
            juego.sumar(texto, botonAtacante, atacante);

        }catch (ElPaisAtacanteSiempreDebeMantenerUnEjercitoEnElPaisError exception){
            Stage casoError = new Stage();
            var label = new Label("No se puede atacar con  esa cantidad de ejercitos");
            Scene scene = new Scene(label, 400,100);
            casoError.setScene(scene);
            casoError.showAndWait();
        }

        VBox actualizado = juego.actualizarTeg(stage);
        BackgroundImage backgroundMapa= new BackgroundImage(new Image("https://pbs.twimg.com/media/EbYRjuBXkAUfado.png:large",1550,800,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        actualizado.setBackground(new Background(backgroundMapa));
        var mapa = new Scene(actualizado, 1550,800);

        stage.setScene(mapa);
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
