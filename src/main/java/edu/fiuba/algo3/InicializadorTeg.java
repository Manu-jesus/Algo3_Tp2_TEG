package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.Pais;

import java.util.ArrayList;

public class InicializadorTeg {

    private Integer cantidadJugadores;

    private Dados dadosAzul;
    private Dados dadosRojo;
    private Dados dadosAmarillo;
    private Dados dadosVerde;

    private Jugador azul;
    private Jugador rojo;
    private Jugador amarillo;
    private Jugador verde;

    private Continente surAmerica;
    private Continente asia;
    private Continente africa;
    private Continente oceania;
    private Continente europa;
    private Continente norteAmerica;

    private ArrayList<Pais> paises;
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
    private tarjetaObjetivo objetivoVerde;

    private Turno turno;


    public InicializadorTeg(TextField texto){

        //this.cantidadJugadores = Integer.valueOf(texto.getText());

        turno = new Turno();
        dadosAzul = new Dados();
        dadosRojo = new Dados();
        dadosAmarillo = new Dados();
        dadosVerde = new Dados();

        objetivoRojo = new tarjetaObjetivo(surAmerica);
        objetivoAmarillo= new tarjetaObjetivo(asia);
        objetivoAzul = new tarjetaObjetivo(africa);
        objetivoVerde = new tarjetaObjetivo(oceania);

        azul = new Jugador(dadosAzul, objetivoAzul, turno, "#077bbb");
        rojo = new Jugador(dadosRojo,objetivoRojo, turno, "#cc3311");
        amarillo = new Jugador(dadosAmarillo,objetivoAmarillo, turno, "#ee7733");
        verde = new Jugador(dadosVerde,objetivoVerde, turno, "#009988");

        ArrayList<Jugador> jugadores = new ArrayList<>();
        jugadores.add(azul);
        jugadores.add(rojo);
        jugadores.add(amarillo);
        jugadores.add(verde);

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
        israel = new Pais(1, verde, asia);
        sahara = new Pais(5, verde, africa);
        egipto = new Pais(2, amarillo, africa);
        australia = new Pais(1, azul, oceania);

        //Pais argentina, brasil, estadosUnidos, canada, espana, alemania, china, israel, sahara, egipto, australia;
        paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(brasil);
        paises.add(estadosUnidos);
        paises.add(canada);
        paises.add(espana);
        paises.add(alemania);
        paises.add(china);
        paises.add(israel);
        paises.add(sahara);
        paises.add(egipto);
        paises.add(australia);

        //this.repartirEntre( this.cantidadJugadores , jugadores);

        argentina.agregarPaisLimitrofe(brasil);
        espana.agregarPaisLimitrofe(alemania);
        estadosUnidos.agregarPaisLimitrofe(canada);
        china.agregarPaisLimitrofe(israel);
        sahara.agregarPaisLimitrofe(egipto);

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

/*    public void repartirEntre(Integer cantJugadores, ArrayList<Jugador> jugadores){

        int i = 0;
        for (int j = 0; j < paises.size(); j++) {

            Pais paisX = paises.get(j);
            paisX = new Pais(1, jugadores.get(i), surAmerica);

            /*}
            else if (j<4) {
                paises.get(j) = new Pais(1, jugadores.get(i), norteAmerica);
            }
            else if (j<6) {
                paises.get(j) = new Pais(1, jugadores.get(i), europa);
            }
            else if (j<8) {
                paises.get(j) = new Pais(1, jugadores.get(i), asia);
            }
            else if (j<10) {
                paises.get(j) = new Pais(1, jugadores.get(i), africa);
            }
            else {
                paises.get(j) = new Pais(1, jugadores.get(i), oceania);
            }

            i++;
            if (cantJugadores == i ){i = 0;}
        }

    }
 */

    public VBox actualizarTeg(Stage stage){

        var label = new Label("TURNO DE: " + turno.jugadorActual().color());
        //var scene = new Scene(new StackPane(label), 640, 480);

        BotonPaisEventHandler botonArgentinaEvent = new BotonPaisEventHandler(this , stage, botonArgentina, argentina);
        botonArgentina.setOnAction(botonArgentinaEvent);

        BotonPaisEventHandler botonBrasilEvent = new BotonPaisEventHandler(this , stage, botonBrasil, brasil);
        botonBrasil.setOnAction(botonBrasilEvent);

        BotonPaisEventHandler botonCanadaEvent = new BotonPaisEventHandler(this , stage, botonCanada, canada);
        botonCanada.setOnAction(botonCanadaEvent);

        BotonPaisEventHandler botonEEUUEvent = new BotonPaisEventHandler(this , stage, botonEEUU, estadosUnidos);
        botonEEUU.setOnAction(botonEEUUEvent);

        BotonPaisEventHandler botonEspanaEvent = new BotonPaisEventHandler(this , stage, botonEspana, espana);
        botonEspana.setOnAction(botonEspanaEvent);

        BotonPaisEventHandler botonAlemaniaEvent = new BotonPaisEventHandler(this , stage, botonAlemania, alemania);
        botonAlemania.setOnAction(botonAlemaniaEvent);

        BotonPaisEventHandler botonIsraelEvent = new BotonPaisEventHandler(this , stage, botonIsrael, israel);
        botonIsrael.setOnAction(botonIsraelEvent);

        BotonPaisEventHandler botonChinaEvent = new BotonPaisEventHandler(this , stage, botonChina, china);
        botonChina.setOnAction(botonChinaEvent);

        BotonPaisEventHandler botonSaharaEvent = new BotonPaisEventHandler(this , stage, botonSahara, sahara);
        botonSahara.setOnAction(botonSaharaEvent);

        BotonPaisEventHandler botonEgiptoEvent = new BotonPaisEventHandler(this , stage, botonEgipto, egipto);
        botonEgipto.setOnAction(botonEgiptoEvent);

        BotonPaisEventHandler botonAustraliaEvent = new BotonPaisEventHandler(this , stage, botonAustralia, australia);
        botonAustralia.setOnAction(botonAustraliaEvent);

        this.determinarTamanio();
        this.determinarColor();

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

        Button pasarTurno = new Button("Pasar Turno");
        BotonPasarTurnoEventHandler pasarTurnoEvent = new BotonPasarTurnoEventHandler(this.turno, this, stage);
        pasarTurno.setOnAction(pasarTurnoEvent);

        HBox turnosActuales = new HBox(label, pasarTurno);
        VBox mapaMundi = new VBox(hemisferioNorte, hemisferioSur, turnosActuales);
        mapaMundi.setSpacing(20);
        mapaMundi.setPadding(new Insets(35,35,35,100));


        return mapaMundi;
    }

    public void determinarTamanio(){

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
    }

    public void determinarColor(){

        botonArgentina.setStyle("-fx-background-color:"+argentina.colorPorDuenio());
        botonEEUU.setStyle("-fx-background-color:"+estadosUnidos.colorPorDuenio());
        botonBrasil.setStyle("-fx-background-color:"+brasil.colorPorDuenio());
        botonCanada.setStyle("-fx-background-color:"+canada.colorPorDuenio());
        botonEspana.setStyle("-fx-background-color:"+espana.colorPorDuenio());
        botonAlemania.setStyle("-fx-background-color:"+alemania.colorPorDuenio());
        botonChina.setStyle("-fx-background-color:"+china.colorPorDuenio());
        botonIsrael.setStyle("-fx-background-color:"+israel.colorPorDuenio());
        botonSahara.setStyle("-fx-background-color:"+sahara.colorPorDuenio());
        botonEgipto.setStyle("-fx-background-color:"+egipto.colorPorDuenio());
        botonAustralia.setStyle("-fx-background-color:"+australia.colorPorDuenio());
    }

    public VBox copiarMapa(Stage stage, Button botonAtacante, Pais atacante){

        this.determinarTamanio();

        this.determinarColor();

        BotonCantidadEjercitosEventHandler botonDefiendeArgentinaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonArgentina,argentina, this);
        botonArgentina.setOnAction(botonDefiendeArgentinaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeBrasilEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonBrasil,brasil, this);
        botonBrasil.setOnAction(botonDefiendeBrasilEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeCanadaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonCanada,canada, this);
        botonCanada.setOnAction(botonDefiendeCanadaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeEEUUEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonEEUU,estadosUnidos, this);
        botonEEUU.setOnAction(botonDefiendeEEUUEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeEspanaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonEspana,espana, this);
        botonEspana.setOnAction(botonDefiendeEspanaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeAlemaniaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonAlemania,alemania, this);
        botonAlemania.setOnAction(botonDefiendeAlemaniaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeIsraelEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonIsrael,israel, this);
        botonIsrael.setOnAction(botonDefiendeIsraelEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeChinaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonChina,china, this);
        botonChina.setOnAction(botonDefiendeChinaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeSaharaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonSahara,sahara, this);
        botonSahara.setOnAction(botonDefiendeSaharaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeEgiptoEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonEgipto,egipto, this);
        botonEgipto.setOnAction(botonDefiendeEgiptoEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeAustraliaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonAustralia,australia, this);
        botonAustralia.setOnAction(botonDefiendeAustraliaEjercitos);

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
        turno.jugadorActual().atacarAPais(atacante, defensor, cantidadEjercitos);

        botonAtacante.setText(Integer.toString(atacante.ejercitos()));
        botonDefensor.setText(Integer.toString(defensor.ejercitos()));
    }

    public void sumar(TextField texto, Button botonASumar, Pais sumante){

        Integer cantidadEjercitos = Integer.valueOf(texto.getText());
        turno.jugadorActual().agregarEjercitosA(sumante, cantidadEjercitos);

        botonASumar.setText(Integer.toString(sumante.ejercitos()));
    }
}
