package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.Pais;

public class InicializadorTeg {
    private Dados dadosAzul;
    private Dados dadosRojo;
    private Dados dadosAmarillo;

    private Jugador azul;
    private Jugador rojo;
    private Jugador amarillo;

    private Continente america;
    private Continente asia;

    private Pais argentina;
    private Pais brasil;
    private Pais estadosUnidos;
    private Pais canada;

    private Button botonArgentina;
    private Button botonBrasil;
    private Button botonEEUU;
    private Button botonCanada;

    private tarjetaObjetivo objetivoRojo;
    private tarjetaObjetivo objetivoAzul;
    private tarjetaObjetivo objetivoAmarillo;

    public InicializadorTeg(){
        dadosAzul = new Dados();
        dadosRojo = new Dados();
        dadosAmarillo = new Dados();

        objetivoRojo = new tarjetaObjetivo(america);
        objetivoAmarillo= new tarjetaObjetivo(america);
        objetivoAzul = new tarjetaObjetivo(america);


        azul = new Jugador(dadosAzul, objetivoAzul);
        rojo = new Jugador(dadosRojo,objetivoRojo);
        amarillo = new Jugador(dadosAmarillo,objetivoAmarillo);

        america = new Continente();
        asia = new Continente();

        argentina = new Pais(4, azul, america);
        estadosUnidos = new Pais(3, azul, america);
        brasil= new Pais(4, rojo, america);
        canada = new Pais(6, rojo, america);
        argentina.agregarPaisLimitrofe(brasil);
        argentina.agregarPaisLimitrofe(estadosUnidos);
        argentina.agregarPaisLimitrofe(canada);

        botonArgentina = new Button( Integer.toString(argentina.ejercitos()));
        botonEEUU = new Button( Integer.toString(estadosUnidos.ejercitos()));
        botonBrasil = new Button(Integer.toString(brasil.ejercitos()));
        botonCanada = new Button(Integer.toString(canada.ejercitos()));
    }

    public VBox actualizarTeg(Stage stage){

        BotonPaisEventHandler botonArgentinaEvent = new BotonPaisEventHandler(this , stage, botonArgentina, argentina);
        botonArgentina.setOnAction(botonArgentinaEvent);
        botonArgentina.setPrefSize(100,100);


        botonEEUU.setPrefSize(100,100);

        botonBrasil.setPrefSize(100,100);

        botonCanada.setPrefSize(100,100);

        HBox filaPais = new HBox( botonEEUU, botonCanada);
        filaPais.setSpacing(20);
        filaPais.setPadding(new Insets(35));

        VBox columnaPais = new VBox(filaPais, botonArgentina, botonBrasil );
        columnaPais.setSpacing(20);
        columnaPais.setPadding(new Insets(35));

        return columnaPais;
    }
    public VBox copiarMapa(Stage stage, Button botonAtacante, Pais atacante){

        botonArgentina.setPrefSize(100,100);

        botonEEUU.setPrefSize(100,100);

        BotonCantidadEjercitosEventHandler botonDefiendeEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonBrasil,brasil, this);
        botonBrasil.setOnAction(botonDefiendeEjercitos);
        botonBrasil.setPrefSize(100,100);

        botonCanada.setPrefSize(100,100);

        HBox filaPais = new HBox( botonEEUU, botonCanada);
        filaPais.setSpacing(20);
        filaPais.setPadding(new Insets(35));

        VBox columnaPais = new VBox(filaPais, botonArgentina, botonBrasil );
        columnaPais.setSpacing(20);
        columnaPais.setPadding(new Insets(35));

        return columnaPais;
    }

    public void atacar(TextField texto,Button botonAtacante,Pais atacante,Button botonDefensor,Pais defensor){
        Integer cantidadEjercitos = Integer.valueOf(texto.getText());
        atacante.duenio().atacarAPais(atacante, defensor, cantidadEjercitos);

        botonAtacante.setText(Integer.toString(atacante.ejercitos()));
        botonDefensor.setText(Integer.toString(defensor.ejercitos()));
    }

}
