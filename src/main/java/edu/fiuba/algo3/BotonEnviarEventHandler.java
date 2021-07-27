package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pais;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonEnviarEventHandler implements EventHandler<ActionEvent> {
    private TextField texto;
    private Pais pais;
    private Stage stage;
    private Button botonPais;

    public BotonEnviarEventHandler (Stage stage, TextField texto,Button botonPais, Pais pais){
        this.stage = stage;
        this.texto = texto;
        this.pais = pais;
        this.botonPais = botonPais;
    }

    @Override
    public void handle(ActionEvent actionEvent){

        Integer cantidadEjercitos = Integer.valueOf(this.texto.getText());
        this.pais.sumarEjercitos(cantidadEjercitos);
        this.botonPais.setText(Integer.toString(this.pais.ejercitos()));
        this.stage.close();
    }
}
