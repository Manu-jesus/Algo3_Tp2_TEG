package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.Pais;

public class InicializadorTeg {
    private Dados dadosAzul;
    private Dados dadosRojo;
    private Dados dadosAmarillo;

    private Jugador azul;
    private Jugador rojo;
    private Jugador amarillo;

    private Continente surAmerica;
    private Continente asia;
    private Continente africa;
    private Continente oceania;
    private Continente europa;
    private Continente norteAmerica;

    private Pais argentina;
    private Pais brasil;
    private Pais estadosUnidos;
    private Pais canada;
    private Pais espana;
    private Pais alemania;
    private Pais china;
    private Pais israel;
    private Pais sahara;
    private Pais egipto;
    private Pais australia;

    private Button botonArgentina;
    private Button botonBrasil;
    private Button botonEEUU;
    private Button botonCanada;
    private Button botonEspana;
    private Button botonAlemania;
    private Button botonChina;
    private Button botonIsrael;
    private Button botonSahara;
    private Button botonEgipto;
    private Button botonAustralia;

    private tarjetaObjetivo objetivoRojo;
    private tarjetaObjetivo objetivoAzul;
    private tarjetaObjetivo objetivoAmarillo;

    public InicializadorTeg(){
        dadosAzul = new Dados();
        dadosRojo = new Dados();
        dadosAmarillo = new Dados();

        objetivoRojo = new tarjetaObjetivo(surAmerica);
        objetivoAmarillo= new tarjetaObjetivo(asia);
        objetivoAzul = new tarjetaObjetivo(africa);


        azul = new Jugador(dadosAzul, objetivoAzul);
        rojo = new Jugador(dadosRojo,objetivoRojo);
        amarillo = new Jugador(dadosAmarillo,objetivoAmarillo);

        surAmerica = new Continente();
        asia = new Continente();
        africa = new Continente();
        oceania = new Continente();
        europa = new Continente();
        norteAmerica = new Continente();

        argentina = new Pais(4, azul, surAmerica);
        estadosUnidos = new Pais(3, azul, norteAmerica);
        brasil= new Pais(4, rojo, surAmerica);
        canada = new Pais(6, rojo, norteAmerica);
        espana = new Pais(1, azul,europa);
        alemania = new Pais(7, amarillo, europa);
        china = new Pais(2, rojo, asia);
        israel = new Pais(1, azul, asia);
        sahara = new Pais(5, rojo, africa);
        egipto = new Pais(2, amarillo, africa);
        australia = new Pais(1, azul, oceania);

        argentina.agregarPaisLimitrofe(brasil);
        argentina.agregarPaisLimitrofe(estadosUnidos);
        argentina.agregarPaisLimitrofe(canada);

        botonArgentina = new Button( Integer.toString(argentina.ejercitos()));
        botonEEUU = new Button( Integer.toString(estadosUnidos.ejercitos()));
        botonBrasil = new Button(Integer.toString(brasil.ejercitos()));
        botonCanada = new Button(Integer.toString(canada.ejercitos()));
        botonEspana = new Button( Integer.toString(espana.ejercitos()));
        botonAlemania = new Button( Integer.toString(alemania.ejercitos()));
        botonChina = new Button( Integer.toString(china.ejercitos()));
        botonIsrael = new Button( Integer.toString(israel.ejercitos()));
        botonSahara = new Button( Integer.toString(sahara .ejercitos()));
        botonEgipto = new Button( Integer.toString(egipto.ejercitos()));
        botonAustralia = new Button( Integer.toString(australia.ejercitos()));
    }

    public VBox actualizarTeg(Stage stage){

        BotonPaisEventHandler botonArgentinaEvent = new BotonPaisEventHandler(this , stage, botonArgentina, argentina);
        botonArgentina.setOnAction(botonArgentinaEvent);

        botonArgentina.setPrefSize(100,100);
        botonEEUU.setPrefSize(100,100);
        botonBrasil.setPrefSize(100,100);
        botonCanada.setPrefSize(100,100);
        botonEspana.setPrefSize(100,100);
        botonAlemania.setPrefSize(100,100);
        botonChina.setPrefSize(100,100);
        botonIsrael.setPrefSize(100,100);
        botonSahara.setPrefSize(100,100);
        botonEgipto.setPrefSize(100,100);
        botonAustralia.setPrefSize(100,100);

        botonArgentina.setStyle("-fx-background-color:#077bbb");
        botonEEUU.setStyle("-fx-background-color:#cc3311");
        botonBrasil.setStyle("-fx-background-color:#cc3311");
        botonCanada.setStyle("-fx-background-color:#cc3311");
        botonEspana.setStyle("-fx-background-color:#077bbb");
        botonAlemania.setStyle("-fx-background-color:#ee7733");
        botonChina.setStyle("-fx-background-color:#cc3311");
        botonIsrael.setStyle("-fx-background-color:#077bbb");
        botonSahara.setStyle("-fx-background-color:#cc3311");
        botonEgipto.setStyle("-fx-background-color:#ee7733");
        botonAustralia.setStyle("-fx-background-color:#077bbb");

        HBox hemisferioNorte = new HBox( botonCanada, botonEEUU, botonEspana, botonAlemania, botonIsrael, botonChina);
        hemisferioNorte.setSpacing(20);
        hemisferioNorte.setPadding(new Insets(35));
        hemisferioNorte.setMargin(botonEEUU,new Insets(100,0,0,0));
        hemisferioNorte.setMargin(botonEspana,new Insets(50,0,0,200));
        hemisferioNorte.setMargin(botonIsrael,new Insets(50,0,0,0));

        HBox hemisferioSur = new HBox(botonBrasil, botonArgentina, botonSahara, botonEgipto, botonAustralia);
        hemisferioSur.setMargin(botonBrasil, new Insets(0,0,0,200));
        hemisferioSur.setMargin(botonArgentina, new Insets(120,0,0,0));
        hemisferioSur.setMargin(botonSahara, new Insets(0,20,0,200));
        hemisferioSur.setMargin(botonAustralia, new Insets(50,0,0,100));

        VBox mapaMundi = new VBox(hemisferioNorte, hemisferioSur);
        mapaMundi.setSpacing(20);
        mapaMundi.setPadding(new Insets(35,35,35,100));


        return mapaMundi;
    }
    public VBox copiarMapa(Stage stage, Button botonAtacante, Pais atacante){

        botonArgentina.setPrefSize(100,100);
        botonEEUU.setPrefSize(100,100);
        botonBrasil.setPrefSize(100,100);
        botonCanada.setPrefSize(100,100);
        botonEspana.setPrefSize(100,100);
        botonAlemania.setPrefSize(100,100);
        botonChina.setPrefSize(100,100);
        botonIsrael.setPrefSize(100,100);
        botonSahara.setPrefSize(100,100);
        botonEgipto.setPrefSize(100,100);
        botonAustralia.setPrefSize(100,100);

        botonArgentina.setStyle("-fx-background-color:#077bbb");
        botonEEUU.setStyle("-fx-background-color:#cc3311");
        botonBrasil.setStyle("-fx-background-color:#cc3311");
        botonCanada.setStyle("-fx-background-color:#cc3311");
        botonEspana.setStyle("-fx-background-color:#077bbb");
        botonAlemania.setStyle("-fx-background-color:#ee7733");
        botonChina.setStyle("-fx-background-color:#cc3311");
        botonIsrael.setStyle("-fx-background-color:#077bbb");
        botonSahara.setStyle("-fx-background-color:#cc3311");
        botonEgipto.setStyle("-fx-background-color:#ee7733");
        botonAustralia.setStyle("-fx-background-color:#077bbb");

        BotonCantidadEjercitosEventHandler botonDefiendeEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonBrasil,brasil, this);
        botonBrasil.setOnAction(botonDefiendeEjercitos);

        HBox hemisferioNorte = new HBox( botonCanada, botonEEUU, botonEspana, botonAlemania, botonIsrael, botonChina);
        hemisferioNorte.setSpacing(20);
        hemisferioNorte.setPadding(new Insets(35));
        hemisferioNorte.setMargin(botonEEUU,new Insets(100,0,0,0));
        hemisferioNorte.setMargin(botonEspana,new Insets(50,0,0,200));
        hemisferioNorte.setMargin(botonIsrael,new Insets(50,0,0,0));

        HBox hemisferioSur = new HBox(botonBrasil, botonArgentina, botonSahara, botonEgipto, botonAustralia);
        hemisferioSur.setMargin(botonBrasil, new Insets(0,0,0,200));
        hemisferioSur.setMargin(botonArgentina, new Insets(120,0,0,0));
        hemisferioSur.setMargin(botonSahara, new Insets(0,20,0,200));
        hemisferioSur.setMargin(botonAustralia, new Insets(50,0,0,100));

        VBox mapaMundi = new VBox(hemisferioNorte, hemisferioSur);
        mapaMundi.setSpacing(20);
        mapaMundi.setPadding(new Insets(35,35,35,100));

        return mapaMundi;
    }

    public void atacar(TextField texto,Button botonAtacante,Pais atacante,Button botonDefensor,Pais defensor){
        Integer cantidadEjercitos = Integer.valueOf(texto.getText());
        atacante.duenio().atacarAPais(atacante, defensor, cantidadEjercitos);

        botonAtacante.setText(Integer.toString(atacante.ejercitos()));
        botonDefensor.setText(Integer.toString(defensor.ejercitos()));
    }

}
