package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.ElPaisAtacanteNoTePerteneceError;
import edu.fiuba.algo3.modelo.ElPaisAtacanteSiempreDebeMantenerUnEjercitoEnElPaisError;
import edu.fiuba.algo3.modelo.ElTurnoYaNoTePermiteAtacarError;
import edu.fiuba.algo3.modelo.LosPaisesNoSonLimitrofesError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BotonInit implements EventHandler<ActionEvent> {

    private Stage stage;
    private InicializadorTeg juego;
    private TextField jugadores;

    public BotonInit (Stage stage, TextField texto){
        this.stage = stage;
        this.jugadores = texto;
    }


    @Override
    public void handle(ActionEvent actionEvent){

        if (!this.esNumero(this.jugadores.getText())){
            this.tratarError("El contenido ingresado debe ser un número");
            return;
        }
        Integer cantidad = Integer.valueOf(this.jugadores.getText());
        if (cantidad < 2 || cantidad > 6){
            this.tratarError("Solo pueden jugar de 2 a 6 personas!");
            return;
        }

        this.juego = new InicializadorTeg(cantidad);

        VBox columnaPais = juego.actualizarTeg(stage);

        BackgroundImage backgroundMapa= new BackgroundImage(new Image("https://pbs.twimg.com/media/EbYRjuBXkAUfado.png:large",1300,650,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        columnaPais.setBackground(new Background(backgroundMapa));
        var mapa = new Scene(columnaPais, 1300,650);
        this.stage.setScene(mapa);
        this.stage.show();
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
