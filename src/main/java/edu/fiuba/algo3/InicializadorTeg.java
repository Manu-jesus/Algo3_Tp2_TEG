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
    private Pais mexico;
    private Pais california;
    private Pais espana;
    private Pais francia;
    private Pais china;
    private Pais iran;
    private Pais sahara;
    private Pais egipto;
    private Pais australia;

    private Button botonArgentina;
    private Button botonBrasil;
    private Button botonMexico;
    private Button botonCalifornia;
    private Button botonEspana;
    private Button botonFrancia;
    private Button botonChina;
    private Button botonIran;
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
        mexico = new Pais(3, azul, norteAmerica);
        brasil= new Pais(4, rojo, surAmerica);
        california = new Pais(6, rojo, norteAmerica);
        espana = new Pais(1, azul,europa);
        francia = new Pais(7, amarillo, europa);
        china = new Pais(2, rojo, asia);
        iran = new Pais(1, verde, asia);
        sahara = new Pais(5, verde, africa);
        egipto = new Pais(2, amarillo, africa);
        australia = new Pais(1, azul, oceania);

        //Pais argentina, brasil, emexico, california, espana, francia, china, iran, sahara, egipto, australia;
        paises = new ArrayList<>();
        paises.add(argentina);
        paises.add(brasil);
        paises.add(mexico);
        paises.add(california);
        paises.add(espana);
        paises.add(francia);
        paises.add(china);
        paises.add(iran);
        paises.add(sahara);
        paises.add(egipto);
        paises.add(australia);

        //this.repartirEntre( this.cantidadJugadores , jugadores);

        argentina.agregarPaisLimitrofe(brasil);
        brasil.agregarPaisLimitrofe(sahara);
        sahara.agregarPaisLimitrofe(espana);
        espana.agregarPaisLimitrofe(francia);
        mexico.agregarPaisLimitrofe(california);
        china.agregarPaisLimitrofe(iran);
        sahara.agregarPaisLimitrofe(egipto);

        botonArgentina = new Button( Integer.toString(argentina.ejercitos()));
        botonMexico = new Button( Integer.toString(mexico.ejercitos()));
        botonBrasil = new Button(Integer.toString(brasil.ejercitos()));
        botonCalifornia = new Button(Integer.toString(california.ejercitos()));
        botonEspana = new Button( Integer.toString(espana.ejercitos()));
        botonFrancia = new Button( Integer.toString(francia.ejercitos()));
        botonChina = new Button( Integer.toString(china.ejercitos()));
        botonIran = new Button( Integer.toString(iran.ejercitos()));
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


        Button pasarTurno = new Button("Pasar Turno");
        BotonPasarTurnoEventHandler pasarTurnoEvent = new BotonPasarTurnoEventHandler(this.turno, this, stage);
        pasarTurno.setOnAction(pasarTurnoEvent);
        //var scene = new Scene(new StackPane(label), 640, 480);

        BotonPaisEventHandler botonArgentinaEvent = new BotonPaisEventHandler(this , stage, botonArgentina, argentina);
        botonArgentina.setOnAction(botonArgentinaEvent);

        BotonPaisEventHandler botonBrasilEvent = new BotonPaisEventHandler(this , stage, botonBrasil, brasil);
        botonBrasil.setOnAction(botonBrasilEvent);

        BotonPaisEventHandler botonCaliforniaEvent = new BotonPaisEventHandler(this , stage, botonCalifornia, california);
        botonCalifornia.setOnAction(botonCaliforniaEvent);

        BotonPaisEventHandler botonMexicoEvent = new BotonPaisEventHandler(this , stage, botonMexico, mexico);
        botonMexico.setOnAction(botonMexicoEvent);

        BotonPaisEventHandler botonEspanaEvent = new BotonPaisEventHandler(this , stage, botonEspana, espana);
        botonEspana.setOnAction(botonEspanaEvent);

        BotonPaisEventHandler botonFranciaEvent = new BotonPaisEventHandler(this , stage, botonFrancia, francia);
        botonFrancia.setOnAction(botonFranciaEvent);

        BotonPaisEventHandler botonIranEvent = new BotonPaisEventHandler(this , stage, botonIran, iran);
        botonIran.setOnAction(botonIranEvent);

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

        HBox hemisferioNorte = new HBox( botonCalifornia, botonMexico, botonEspana, botonFrancia, botonIran, botonChina);
        hemisferioNorte.setSpacing(20);
        hemisferioNorte.setPadding(new Insets(35));
        hemisferioNorte.setMargin(botonMexico,new Insets(340,0,0,80));
        hemisferioNorte.setMargin(botonCalifornia,new Insets(300,0,0,100));
        hemisferioNorte.setMargin(botonEspana,new Insets(380,0,0,380));
        hemisferioNorte.setMargin(botonFrancia,new Insets(330,0,0,50));
        hemisferioNorte.setMargin(botonIran,new Insets(270,0,0,270));
        hemisferioNorte.setMargin(botonChina,new Insets(270,0,0,80));

        HBox hemisferioSur = new HBox(botonArgentina,botonBrasil , botonSahara, botonEgipto, botonAustralia);
        hemisferioSur.setMargin(botonBrasil, new Insets(-30,0,0,100));
        hemisferioSur.setMargin(botonArgentina, new Insets(70,0,0,420));
        hemisferioSur.setMargin(botonSahara, new Insets(20,20,0,250));
        hemisferioSur.setMargin(botonEgipto, new Insets(0,20,0,150));
        hemisferioSur.setMargin(botonAustralia, new Insets(40,0,0,280));



        HBox turnosActuales = new HBox(label, pasarTurno);
        turnosActuales.setMargin(label,new Insets(50,20,0,150));
        turnosActuales.setMargin(pasarTurno,new Insets(50,0,0,0));;
        VBox mapaMundi = new VBox(hemisferioNorte, hemisferioSur, turnosActuales);
        mapaMundi.setSpacing(20);
        mapaMundi.setPadding(new Insets(35,35,35,100));


        return mapaMundi;
    }

    public void determinarTamanio(){

        botonArgentina.setPrefSize(30,30);
        botonBrasil.setPrefSize(30,30);
        botonMexico.setPrefSize(30,30);
        botonCalifornia.setPrefSize(30,30);
        botonEspana.setPrefSize(30,30);
        botonFrancia.setPrefSize(30,30);
        botonChina.setPrefSize(30,30);
        botonIran.setPrefSize(30,30);
        botonSahara.setPrefSize(30,30);
        botonEgipto.setPrefSize(30,30);
        botonAustralia.setPrefSize(30,30);
    }

    public void determinarColor(){

        botonArgentina.setStyle("-fx-background-color:"+argentina.colorPorDuenio());
        botonMexico.setStyle("-fx-background-color:"+mexico.colorPorDuenio());
        botonBrasil.setStyle("-fx-background-color:"+brasil.colorPorDuenio());
        botonCalifornia.setStyle("-fx-background-color:"+california.colorPorDuenio());
        botonEspana.setStyle("-fx-background-color:"+espana.colorPorDuenio());
        botonFrancia.setStyle("-fx-background-color:"+francia.colorPorDuenio());
        botonChina.setStyle("-fx-background-color:"+china.colorPorDuenio());
        botonIran.setStyle("-fx-background-color:"+iran.colorPorDuenio());
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

        BotonCantidadEjercitosEventHandler botonDefiendeCaliforniaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonCalifornia,california, this);
        botonCalifornia.setOnAction(botonDefiendeCaliforniaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeMexicoEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonMexico,mexico, this);
        botonMexico.setOnAction(botonDefiendeMexicoEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeEspanaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonEspana,espana, this);
        botonEspana.setOnAction(botonDefiendeEspanaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeFranciaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonFrancia,francia, this);
        botonFrancia.setOnAction(botonDefiendeFranciaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeIranEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonIran,iran, this);
        botonIran.setOnAction(botonDefiendeIranEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeChinaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonChina,china, this);
        botonChina.setOnAction(botonDefiendeChinaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeSaharaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonSahara,sahara, this);
        botonSahara.setOnAction(botonDefiendeSaharaEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeEgiptoEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonEgipto,egipto, this);
        botonEgipto.setOnAction(botonDefiendeEgiptoEjercitos);

        BotonCantidadEjercitosEventHandler botonDefiendeAustraliaEjercitos = new BotonCantidadEjercitosEventHandler( stage,botonAtacante, atacante, botonAustralia,australia, this);
        botonAustralia.setOnAction(botonDefiendeAustraliaEjercitos);

        HBox hemisferioNorte = new HBox( botonCalifornia, botonMexico, botonEspana, botonFrancia, botonIran, botonChina);
        hemisferioNorte.setSpacing(20);
        hemisferioNorte.setPadding(new Insets(35));
        hemisferioNorte.setMargin(botonMexico,new Insets(340,0,0,80));
        hemisferioNorte.setMargin(botonCalifornia,new Insets(300,0,0,100));
        hemisferioNorte.setMargin(botonEspana,new Insets(380,0,0,380));
        hemisferioNorte.setMargin(botonFrancia,new Insets(330,0,0,50));
        hemisferioNorte.setMargin(botonIran,new Insets(270,0,0,270));
        hemisferioNorte.setMargin(botonChina,new Insets(270,0,0,80));

        HBox hemisferioSur = new HBox(botonArgentina,botonBrasil , botonSahara, botonEgipto, botonAustralia);
        hemisferioSur.setMargin(botonBrasil, new Insets(-30,0,0,100));
        hemisferioSur.setMargin(botonArgentina, new Insets(70,0,0,420));
        hemisferioSur.setMargin(botonSahara, new Insets(20,20,0,250));
        hemisferioSur.setMargin(botonEgipto, new Insets(0,20,0,150));
        hemisferioSur.setMargin(botonAustralia, new Insets(40,0,0,280));



        HBox turnosActuales = new HBox();
        VBox mapaMundi = new VBox(hemisferioNorte, hemisferioSur, turnosActuales);
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
