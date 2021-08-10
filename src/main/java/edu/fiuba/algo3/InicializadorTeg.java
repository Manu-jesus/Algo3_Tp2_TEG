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
    private Pais uruguay;
    private Pais peru;
    private Pais chile;
    private Pais colombia;

    private Pais mexico;
    private Pais california;
    private Pais oregon;
    private Pais nuevaYork;
    private Pais terranova;
    private Pais labrador;
    private Pais groenlandia;
    private Pais canada;
    private Pais yukon;
    private Pais alaska;

    private Pais espana;
    private Pais francia;
    private Pais islandia;
    private Pais granBretana;
    private Pais alemania;
    private Pais italia;
    private Pais polonia;
    private Pais rusia;
    private Pais suecia;

    private Pais china;
    private Pais iran;
    private Pais malasia;
    private Pais india;
    private Pais arabia;
    private Pais israel;
    private Pais turquia;
    private Pais gobi;
    private Pais mongolia;
    private Pais siberia;
    private Pais aral;
    private Pais tartaria;
    private Pais taymir;
    private Pais kamchayka;
    private Pais japon;

    private Pais sahara;
    private Pais egipto;
    private Pais etiopia;
    private Pais zaire;
    private Pais sudafrica;
    private Pais madagascar;

    private Pais australia;
    private Pais sumatra;
    private Pais java;
    private Pais borneo;

    private Button botonArgentina;
    private Button botonBrasil;
    private Button botonUruguay;
    private Button botonPeru;
    private Button botonChile;
    private Button botonColombia;

    private Button botonMexico;
    private Button botonCalifornia;
    private Button botonOregon;
    private Button botonNuevaYork;
    private Button botonTerranova;
    private Button botonLabrador;
    private Button botonGroenlandia;
    private Button botonCanada;
    private Button botonYukon;
    private Button botonAlaska;

    private Button botonEspana;
    private Button botonFrancia;
    private Button botonIslandia;
    private Button botonGranBretana;
    private Button botonAlemania;
    private Button botonItalia;
    private Button botonPolonia;
    private Button botonRusia;
    private Button botonSuecia;

    private Button botonChina;
    private Button botonIran;
    private Button botonMalasia;
    private Button botonIndia;
    private Button botonArabia;
    private Button botonIsrael;
    private Button botonTurquia;
    private Button botonGobi;
    private Button botonMongolia;
    private Button botonSiberia;
    private Button botonAral;
    private Button botonTartaria;
    private Button botonTaymir;
    private Button botonKamchayka;
    private Button botonJapon;

    private Button botonSahara;
    private Button botonEgipto;
    private Button botonEtiopia;
    private Button botonZaire;
    private Button botonSudafrica;
    private Button botonMadagascar;

    private Button botonAustralia;
    private Button botonSumatra;
    private Button botonJava;
    private Button botonBorneo;

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

        argentina = new Pais(1, azul, surAmerica);
        brasil= new Pais(1, rojo, surAmerica);
        uruguay= new Pais(1, verde, surAmerica);
        peru= new Pais(1, amarillo, surAmerica);
        chile= new Pais(1, azul, surAmerica);
        colombia= new Pais(1, rojo, surAmerica);

        mexico = new Pais(1, verde, norteAmerica);
        california = new Pais(1, amarillo, norteAmerica);
        oregon= new Pais(1, azul, norteAmerica);
        nuevaYork= new Pais(1, rojo, norteAmerica);
        terranova= new Pais(1, verde, norteAmerica);
        labrador= new Pais(1, amarillo, norteAmerica);
        groenlandia= new Pais(1, azul, norteAmerica);
        canada= new Pais(1, rojo, norteAmerica);
        yukon= new Pais(1, verde, norteAmerica);
        alaska= new Pais(1, amarillo, norteAmerica);

        espana = new Pais(1, azul,europa);
        francia = new Pais(1, rojo, europa);
        islandia= new Pais(1, verde, europa);
        granBretana= new Pais(1, amarillo, europa);
        alemania= new Pais(1, azul, europa);
        italia= new Pais(1, rojo, europa);
        polonia= new Pais(1, verde, europa);
        rusia= new Pais(1, amarillo, europa);
        suecia= new Pais(1, azul, europa);

        china = new Pais(1, rojo, asia);
        iran = new Pais(1, verde, asia);
        malasia = new Pais(1, amarillo, asia);
        india = new Pais(1, azul, asia);
        arabia = new Pais(1, rojo, asia);
        israel = new Pais(1, verde, asia);
        turquia = new Pais(1, amarillo, asia);
        gobi = new Pais(1, azul, asia);
        mongolia = new Pais(1, rojo, asia);
        siberia = new Pais(1, verde, asia);
        aral = new Pais(1, amarillo, asia);
        tartaria = new Pais(1, azul, asia);
        taymir = new Pais(1, rojo, asia);
        kamchayka = new Pais(1, verde, asia);
        japon = new Pais(1, amarillo, asia);

        sahara = new Pais(1, azul, africa);
        egipto = new Pais(1, rojo, africa);
        etiopia = new Pais(1, verde, africa);
        zaire = new Pais(1, amarillo, africa);
        sudafrica = new Pais(1, azul, africa);
        madagascar = new Pais(1, rojo, africa);

        australia = new Pais(1, verde, oceania);
        sumatra = new Pais(1, amarillo, oceania);
        java = new Pais(1, azul, oceania);
        borneo = new Pais(1, rojo, oceania);

        argentina.agregarPaisLimitrofe(brasil);
        argentina.agregarPaisLimitrofe(uruguay);
        argentina.agregarPaisLimitrofe(chile);
        argentina.agregarPaisLimitrofe(peru);
        brasil.agregarPaisLimitrofe(sahara);
        brasil.agregarPaisLimitrofe(uruguay);
        brasil.agregarPaisLimitrofe(peru);
        brasil.agregarPaisLimitrofe(colombia);
        chile.agregarPaisLimitrofe(australia);
        chile.agregarPaisLimitrofe(peru);
        colombia.agregarPaisLimitrofe(mexico);
        colombia.agregarPaisLimitrofe(peru);

        mexico.agregarPaisLimitrofe(california);
        oregon.agregarPaisLimitrofe(california);
        oregon.agregarPaisLimitrofe(alaska);
        oregon.agregarPaisLimitrofe(yukon);
        oregon.agregarPaisLimitrofe(canada);
        oregon.agregarPaisLimitrofe(nuevaYork);
        nuevaYork.agregarPaisLimitrofe(canada);
        nuevaYork.agregarPaisLimitrofe(california);
        nuevaYork.agregarPaisLimitrofe(terranova);
        nuevaYork.agregarPaisLimitrofe(groenlandia);
        alaska.agregarPaisLimitrofe(kamchayka);
        alaska.agregarPaisLimitrofe(yukon);
        canada.agregarPaisLimitrofe(terranova);
        canada.agregarPaisLimitrofe(yukon);
        labrador.agregarPaisLimitrofe(terranova);
        labrador.agregarPaisLimitrofe(groenlandia);
        groenlandia.agregarPaisLimitrofe(islandia);

        sahara.agregarPaisLimitrofe(espana);
        sahara.agregarPaisLimitrofe(egipto);
        sahara.agregarPaisLimitrofe(etiopia);
        sahara.agregarPaisLimitrofe(zaire);
        egipto.agregarPaisLimitrofe(polonia);
        egipto.agregarPaisLimitrofe(turquia);
        egipto.agregarPaisLimitrofe(israel);
        egipto.agregarPaisLimitrofe(etiopia);
        egipto.agregarPaisLimitrofe(madagascar);
        zaire.agregarPaisLimitrofe(etiopia);
        zaire.agregarPaisLimitrofe(madagascar);
        zaire.agregarPaisLimitrofe(sudafrica);
        etiopia.agregarPaisLimitrofe(sudafrica);

        australia.agregarPaisLimitrofe(sumatra);
        australia.agregarPaisLimitrofe(java);
        australia.agregarPaisLimitrofe(borneo);
        sumatra.agregarPaisLimitrofe(india);
        borneo.agregarPaisLimitrofe(malasia);

        espana.agregarPaisLimitrofe(francia);
        espana.agregarPaisLimitrofe(granBretana);
        granBretana.agregarPaisLimitrofe(islandia);
        granBretana.agregarPaisLimitrofe(alemania);
        suecia.agregarPaisLimitrofe(islandia);
        suecia.agregarPaisLimitrofe(rusia);
        alemania.agregarPaisLimitrofe(francia);
        alemania.agregarPaisLimitrofe(italia);
        alemania.agregarPaisLimitrofe(polonia);
        polonia.agregarPaisLimitrofe(turquia);
        polonia.agregarPaisLimitrofe(rusia);
        rusia.agregarPaisLimitrofe(aral);
        rusia.agregarPaisLimitrofe(iran);
        rusia.agregarPaisLimitrofe(turquia);

        israel.agregarPaisLimitrofe(arabia);
        israel.agregarPaisLimitrofe(turquia);
        turquia.agregarPaisLimitrofe(arabia);
        turquia.agregarPaisLimitrofe(iran);
        iran.agregarPaisLimitrofe(india);
        iran.agregarPaisLimitrofe(china);
        iran.agregarPaisLimitrofe(gobi);
        iran.agregarPaisLimitrofe(mongolia);
        iran.agregarPaisLimitrofe(aral);
        malasia.agregarPaisLimitrofe(india);
        malasia.agregarPaisLimitrofe(china);
        china.agregarPaisLimitrofe(india);
        china.agregarPaisLimitrofe(gobi);
        china.agregarPaisLimitrofe(mongolia);
        china.agregarPaisLimitrofe(japon);
        china.agregarPaisLimitrofe(siberia);
        mongolia.agregarPaisLimitrofe(gobi);
        mongolia.agregarPaisLimitrofe(siberia);
        mongolia.agregarPaisLimitrofe(aral);
        tartaria.agregarPaisLimitrofe(aral);
        tartaria.agregarPaisLimitrofe(siberia);
        tartaria.agregarPaisLimitrofe(taymir);
        siberia.agregarPaisLimitrofe(aral);
        siberia.agregarPaisLimitrofe(taymir);
        siberia.agregarPaisLimitrofe(kamchayka);
        japon.agregarPaisLimitrofe(china);



        botonArgentina = new Button( Integer.toString(argentina.ejercitos()));
        botonBrasil = new Button(Integer.toString(brasil.ejercitos()));
        botonUruguay = new Button(Integer.toString(uruguay.ejercitos()));
        botonPeru = new Button(Integer.toString(peru.ejercitos()));
        botonChile = new Button(Integer.toString(chile.ejercitos()));
        botonColombia = new Button(Integer.toString(colombia.ejercitos()));

        botonMexico = new Button( Integer.toString(mexico.ejercitos()));
        botonCalifornia = new Button(Integer.toString(california.ejercitos()));
        botonOregon = new Button(Integer.toString(oregon.ejercitos()));
        botonNuevaYork = new Button(Integer.toString(nuevaYork.ejercitos()));
        botonTerranova = new Button(Integer.toString(terranova.ejercitos()));
        botonLabrador = new Button(Integer.toString(labrador.ejercitos()));
        botonGroenlandia = new Button(Integer.toString(groenlandia.ejercitos()));
        botonCanada = new Button(Integer.toString(canada.ejercitos()));
        botonYukon = new Button(Integer.toString(yukon.ejercitos()));
        botonAlaska = new Button(Integer.toString(alaska.ejercitos()));

        botonEspana = new Button( Integer.toString(espana.ejercitos()));
        botonFrancia = new Button( Integer.toString(francia.ejercitos()));
        botonIslandia = new Button(Integer.toString(islandia.ejercitos()));
        botonGranBretana = new Button(Integer.toString(granBretana.ejercitos()));
        botonAlemania = new Button(Integer.toString(alemania.ejercitos()));
        botonItalia = new Button(Integer.toString(italia.ejercitos()));
        botonPolonia = new Button(Integer.toString(polonia.ejercitos()));
        botonRusia = new Button(Integer.toString(rusia.ejercitos()));
        botonSuecia = new Button(Integer.toString(suecia.ejercitos()));

        botonChina = new Button( Integer.toString(china.ejercitos()));
        botonIran = new Button( Integer.toString(iran.ejercitos()));
        botonMalasia = new Button(Integer.toString(malasia.ejercitos()));
        botonIndia = new Button(Integer.toString(india.ejercitos()));
        botonArabia = new Button(Integer.toString(arabia.ejercitos()));
        botonIsrael = new Button(Integer.toString(israel.ejercitos()));
        botonTurquia = new Button(Integer.toString(turquia.ejercitos()));
        botonGobi = new Button(Integer.toString(gobi.ejercitos()));
        botonMongolia = new Button(Integer.toString(mongolia.ejercitos()));
        botonSiberia = new Button(Integer.toString(siberia.ejercitos()));
        botonAral = new Button(Integer.toString(aral.ejercitos()));
        botonTartaria = new Button(Integer.toString(tartaria.ejercitos()));
        botonTaymir = new Button(Integer.toString(taymir.ejercitos()));
        botonKamchayka = new Button(Integer.toString(kamchayka.ejercitos()));
        botonJapon = new Button(Integer.toString(japon.ejercitos()));

        botonSahara = new Button( Integer.toString(sahara .ejercitos()));
        botonEgipto = new Button( Integer.toString(egipto.ejercitos()));
        botonEtiopia = new Button(Integer.toString(etiopia.ejercitos()));
        botonZaire = new Button(Integer.toString(zaire.ejercitos()));
        botonSudafrica = new Button(Integer.toString(sudafrica.ejercitos()));
        botonMadagascar = new Button(Integer.toString(madagascar.ejercitos()));

        botonAustralia = new Button( Integer.toString(australia.ejercitos()));
        botonSumatra = new Button(Integer.toString(sumatra.ejercitos()));
        botonJava = new Button(Integer.toString(java.ejercitos()));
        botonBorneo = new Button(Integer.toString(borneo.ejercitos()));
    }


    public VBox actualizarTeg(Stage stage){

        Button turno = new Button();
        turno.setStyle("-fx-background-color:"+ this.turno.jugadorActual().color());
        var label = new Label("TURNO DE: ");

        Button pasarTurno = new Button("Pasar Turno");
        BotonPasarTurnoEventHandler pasarTurnoEvent = new BotonPasarTurnoEventHandler(this.turno, this, stage);
        pasarTurno.setOnAction(pasarTurnoEvent);

        BotonPaisEventHandler botonArgentinaEvent = new BotonPaisEventHandler(this , stage, botonArgentina, argentina);
        BotonPaisEventHandler botonBrasilEvent = new BotonPaisEventHandler(this , stage, botonBrasil, brasil);
        BotonPaisEventHandler botonUruguayEvent = new BotonPaisEventHandler(this , stage, botonUruguay, uruguay);
        BotonPaisEventHandler botonPeruEvent = new BotonPaisEventHandler(this , stage, botonPeru, peru);
        BotonPaisEventHandler botonChileEvent = new BotonPaisEventHandler(this , stage, botonChile, chile);
        BotonPaisEventHandler botonColombiaEvent = new BotonPaisEventHandler(this , stage, botonColombia, colombia);

        BotonPaisEventHandler botonMexicoEvent = new BotonPaisEventHandler(this , stage, botonMexico, mexico);
        BotonPaisEventHandler botonCaliforniaEvent = new BotonPaisEventHandler(this , stage, botonCalifornia, california);
        BotonPaisEventHandler botonOregonEvent = new BotonPaisEventHandler(this , stage, botonOregon, oregon);
        BotonPaisEventHandler botonNuevaYorkEvent = new BotonPaisEventHandler(this , stage, botonNuevaYork, nuevaYork);
        BotonPaisEventHandler botonTerranovaEvent = new BotonPaisEventHandler(this , stage, botonTerranova, terranova);
        BotonPaisEventHandler botonLabradorEvent = new BotonPaisEventHandler(this , stage, botonLabrador, labrador);
        BotonPaisEventHandler botonGroenlandiaEvent = new BotonPaisEventHandler(this , stage, botonGroenlandia, groenlandia);
        BotonPaisEventHandler botonCanadaEvent = new BotonPaisEventHandler(this , stage, botonCanada, canada);
        BotonPaisEventHandler botonYukonEvent = new BotonPaisEventHandler(this , stage, botonYukon, yukon);
        BotonPaisEventHandler botonAlaskaEvent = new BotonPaisEventHandler(this , stage, botonAlaska, alaska);

        BotonPaisEventHandler botonEspanaEvent = new BotonPaisEventHandler(this , stage, botonEspana, espana);
        BotonPaisEventHandler botonFranciaEvent = new BotonPaisEventHandler(this , stage, botonFrancia, francia);
        BotonPaisEventHandler botonIslandiaEvent = new BotonPaisEventHandler(this , stage, botonIslandia, islandia);
        BotonPaisEventHandler botonGranBretanaEvent = new BotonPaisEventHandler(this , stage, botonGranBretana, granBretana);
        BotonPaisEventHandler botonAlemaniaEvent = new BotonPaisEventHandler(this , stage, botonAlemania, alemania);
        BotonPaisEventHandler botonItaliaEvent = new BotonPaisEventHandler(this , stage, botonItalia, italia);
        BotonPaisEventHandler botonPoloniaEvent = new BotonPaisEventHandler(this , stage, botonPolonia, polonia);
        BotonPaisEventHandler botonRusiaEvent = new BotonPaisEventHandler(this , stage, botonRusia, rusia);
        BotonPaisEventHandler botonSueciaEvent = new BotonPaisEventHandler(this , stage, botonSuecia, suecia);

        BotonPaisEventHandler botonChinaEvent = new BotonPaisEventHandler(this , stage, botonChina, china);
        BotonPaisEventHandler botonIranEvent = new BotonPaisEventHandler(this , stage, botonIran, iran);
        BotonPaisEventHandler botonMalasiaEvent = new BotonPaisEventHandler(this , stage, botonMalasia, malasia);
        BotonPaisEventHandler botonIndiaEvent = new BotonPaisEventHandler(this , stage, botonIndia, india);
        BotonPaisEventHandler botonArabiaEvent = new BotonPaisEventHandler(this , stage, botonArabia, arabia);
        BotonPaisEventHandler botonIsraelEvent = new BotonPaisEventHandler(this , stage, botonIsrael, israel);
        BotonPaisEventHandler botonTurquiaEvent = new BotonPaisEventHandler(this , stage, botonTurquia, turquia);
        BotonPaisEventHandler botonGobiEvent = new BotonPaisEventHandler(this , stage, botonGobi, gobi);
        BotonPaisEventHandler botonMongoliaEvent = new BotonPaisEventHandler(this , stage, botonMongolia, mongolia);
        BotonPaisEventHandler botonSiberiaEvent = new BotonPaisEventHandler(this , stage, botonSiberia, siberia);
        BotonPaisEventHandler botonAralEvent = new BotonPaisEventHandler(this , stage, botonAral, aral);
        BotonPaisEventHandler botonTartariaEvent = new BotonPaisEventHandler(this , stage, botonTartaria, tartaria);
        BotonPaisEventHandler botonTaymirEvent = new BotonPaisEventHandler(this , stage, botonTaymir, taymir);
        BotonPaisEventHandler botonKamchaykaEvent = new BotonPaisEventHandler(this , stage, botonKamchayka, kamchayka);
        BotonPaisEventHandler botonJaponEvent = new BotonPaisEventHandler(this , stage, botonJapon, japon);

        BotonPaisEventHandler botonSaharaEvent = new BotonPaisEventHandler(this , stage, botonSahara, sahara);
        BotonPaisEventHandler botonEgiptoEvent = new BotonPaisEventHandler(this , stage, botonEgipto, egipto);
        BotonPaisEventHandler botonEtiopiaEvent = new BotonPaisEventHandler(this , stage, botonEtiopia, etiopia);
        BotonPaisEventHandler botonZaireEvent = new BotonPaisEventHandler(this , stage, botonZaire, zaire);
        BotonPaisEventHandler botonSudafricaEvent = new BotonPaisEventHandler(this , stage, botonSudafrica, sudafrica);
        BotonPaisEventHandler botonMadagascarEvent = new BotonPaisEventHandler(this , stage, botonMadagascar, madagascar);

        BotonPaisEventHandler botonAustraliaEvent = new BotonPaisEventHandler(this , stage, botonAustralia, australia);
        BotonPaisEventHandler botonSumatraEvent = new BotonPaisEventHandler(this , stage, botonSumatra, sumatra);
        BotonPaisEventHandler botonJavaEvent = new BotonPaisEventHandler(this , stage, botonJava, java);
        BotonPaisEventHandler botonBorneoEvent = new BotonPaisEventHandler(this , stage, botonBorneo, borneo);

        botonArgentina.setOnAction(botonArgentinaEvent);
        botonBrasil.setOnAction(botonBrasilEvent);
        botonUruguay.setOnAction(botonUruguayEvent);
        botonPeru.setOnAction(botonPeruEvent);
        botonChile.setOnAction(botonChileEvent);
        botonColombia.setOnAction(botonColombiaEvent);

        botonMexico.setOnAction(botonMexicoEvent);
        botonCalifornia.setOnAction(botonCaliforniaEvent);
        botonOregon.setOnAction(botonOregonEvent);
        botonNuevaYork.setOnAction(botonNuevaYorkEvent);
        botonTerranova.setOnAction(botonTerranovaEvent);
        botonLabrador.setOnAction(botonLabradorEvent);
        botonGroenlandia.setOnAction(botonGroenlandiaEvent);
        botonCanada.setOnAction(botonCanadaEvent);
        botonYukon.setOnAction(botonYukonEvent);
        botonAlaska.setOnAction(botonAlaskaEvent);

        botonEspana.setOnAction(botonEspanaEvent);
        botonFrancia.setOnAction(botonFranciaEvent);
        botonIslandia.setOnAction(botonIslandiaEvent);
        botonGranBretana.setOnAction(botonGranBretanaEvent);
        botonAlemania.setOnAction(botonAlemaniaEvent);
        botonItalia.setOnAction(botonItaliaEvent);
        botonPolonia.setOnAction(botonPoloniaEvent);
        botonRusia.setOnAction(botonRusiaEvent);
        botonSuecia.setOnAction(botonSueciaEvent);

        botonChina.setOnAction(botonChinaEvent);
        botonIran.setOnAction(botonIranEvent);
        botonMalasia.setOnAction(botonMalasiaEvent);
        botonIndia.setOnAction(botonIndiaEvent);
        botonArabia.setOnAction(botonArabiaEvent);
        botonIsrael.setOnAction(botonIsraelEvent);
        botonTurquia.setOnAction(botonTurquiaEvent);
        botonGobi.setOnAction(botonGobiEvent);
        botonMongolia.setOnAction(botonMongoliaEvent);
        botonSiberia.setOnAction(botonSiberiaEvent);
        botonAral.setOnAction(botonAralEvent);
        botonTartaria.setOnAction(botonTartariaEvent);
        botonTaymir.setOnAction(botonTaymirEvent);
        botonKamchayka.setOnAction(botonKamchaykaEvent);
        botonJapon.setOnAction(botonJaponEvent);

        botonSahara.setOnAction(botonSaharaEvent);
        botonEgipto.setOnAction(botonEgiptoEvent);
        botonEtiopia.setOnAction(botonEtiopiaEvent);
        botonZaire.setOnAction(botonZaireEvent);
        botonSudafrica.setOnAction(botonSudafricaEvent);
        botonMadagascar.setOnAction(botonMadagascarEvent);

        botonAustralia.setOnAction(botonAustraliaEvent);
        botonSumatra.setOnAction(botonSumatraEvent);
        botonJava.setOnAction(botonJavaEvent);
        botonBorneo.setOnAction(botonBorneoEvent);

        this.determinarTamanio();
        this.determinarColor();

        HBox hemisferioNorte = new HBox(botonAlaska,botonYukon, botonOregon, botonCanada, botonCalifornia,botonNuevaYork, botonMexico,
                botonTerranova, botonLabrador, botonGroenlandia, botonIslandia, botonEspana, botonGranBretana, botonFrancia, botonSuecia,
                botonAlemania, botonItalia, botonPolonia, botonRusia, botonAral, botonIsrael, botonTurquia, botonTartaria, botonIran,
                botonArabia, botonTaymir, botonMongolia, botonSiberia, botonGobi, botonKamchayka, botonIndia, botonChina, botonMalasia, botonJapon);
        hemisferioNorte.setMargin(botonAlaska,new Insets(250,0,0,40));
        hemisferioNorte.setMargin(botonYukon,new Insets(190,0,0,35));
        hemisferioNorte.setMargin(botonOregon,new Insets(300,0,0,-35));
        hemisferioNorte.setMargin(botonCanada,new Insets(180,0,0,55));
        hemisferioNorte.setMargin(botonCalifornia,new Insets(285,0,0,0));
        hemisferioNorte.setMargin(botonNuevaYork,new Insets(240,0,0,-10));
        hemisferioNorte.setMargin(botonMexico,new Insets(320,0,0,0));
        hemisferioNorte.setMargin(botonTerranova,new Insets(225,0,0,0));
        hemisferioNorte.setMargin(botonLabrador,new Insets(190,0,0,0));
        hemisferioNorte.setMargin(botonGroenlandia,new Insets(140,0,0,70));

        hemisferioNorte.setMargin(botonIslandia,new Insets(240,0,0,100));
        hemisferioNorte.setMargin(botonEspana,new Insets(360,0,0,70));
        hemisferioNorte.setMargin(botonGranBretana,new Insets(260,0,0,0));
        hemisferioNorte.setMargin(botonFrancia,new Insets(320,0,0,20));
        hemisferioNorte.setMargin(botonSuecia,new Insets(170,0,0,0));
        hemisferioNorte.setMargin(botonAlemania,new Insets(280,0,0,20));
        hemisferioNorte.setMargin(botonItalia,new Insets(370,0,0,-30));
        hemisferioNorte.setMargin(botonPolonia,new Insets(290,0,0,40));
        hemisferioNorte.setMargin(botonRusia,new Insets(190,0,0,-40));

        hemisferioNorte.setMargin(botonAral,new Insets(150,0,0,25));
        hemisferioNorte.setMargin(botonIsrael,new Insets(345,0,0,0));
        hemisferioNorte.setMargin(botonTurquia,new Insets(302,0,0,-20));
        hemisferioNorte.setMargin(botonTartaria,new Insets(120,0,0,-30));
        hemisferioNorte.setMargin(botonIran,new Insets(260,0,0,0));
        hemisferioNorte.setMargin(botonArabia,new Insets(365,0,0,-20));
        hemisferioNorte.setMargin(botonTaymir,new Insets(125,0,0,-30));
        hemisferioNorte.setMargin(botonMongolia,new Insets(205,0,0,-20));
        hemisferioNorte.setMargin(botonSiberia,new Insets(165,0,0,-20));
        hemisferioNorte.setMargin(botonGobi,new Insets(245,0,0,0));
        hemisferioNorte.setMargin(botonKamchayka,new Insets(125,0,0,0));
        hemisferioNorte.setMargin(botonIndia,new Insets(330,0,0,-10));
        hemisferioNorte.setMargin(botonChina,new Insets(220,0,0,-10));
        hemisferioNorte.setMargin(botonMalasia,new Insets(310,0,0,30));
        hemisferioNorte.setMargin(botonJapon,new Insets(165,0,0,-20));

        HBox hemisferioSur = new HBox(botonColombia, botonPeru, botonChile, botonArgentina, botonUruguay, botonBrasil, botonSahara,
                botonZaire, botonEtiopia, botonSudafrica, botonEgipto, botonMadagascar, botonSumatra, botonBorneo, botonAustralia, botonJava);
        hemisferioSur.setMargin(botonColombia, new Insets(-35,0,0,400));
        hemisferioSur.setMargin(botonPeru, new Insets(10,0,0,-30));
        hemisferioSur.setMargin(botonChile, new Insets(70,0,0,-45));
        hemisferioSur.setMargin(botonArgentina, new Insets(80,0,0,20));
        hemisferioSur.setMargin(botonUruguay, new Insets(50,0,0,25));
        hemisferioSur.setMargin(botonBrasil, new Insets(0,0,0,10));

        hemisferioSur.setMargin(botonSahara, new Insets(40,0,0,220));
        hemisferioSur.setMargin(botonZaire, new Insets(80,0,0,30));
        hemisferioSur.setMargin(botonEtiopia, new Insets(55,0,0,20));
        hemisferioSur.setMargin(botonSudafrica, new Insets(110,0,0,-10));
        hemisferioSur.setMargin(botonEgipto, new Insets(20,0,0,-20));
        hemisferioSur.setMargin(botonMadagascar, new Insets(85,0,0,60));

        hemisferioSur.setMargin(botonSumatra, new Insets(10,0,0,30));
        hemisferioSur.setMargin(botonBorneo, new Insets(-30,0,0,65));
        hemisferioSur.setMargin(botonAustralia, new Insets(60,0,0,0));
        hemisferioSur.setMargin(botonJava, new Insets(-32,0,0,0));





        HBox turnosActuales = new HBox(label, turno, pasarTurno);
        turnosActuales.setMargin(label,new Insets(25,0,0,180));
        turnosActuales.setMargin(turno,new Insets(25,0,0,10));
        turnosActuales.setMargin(pasarTurno,new Insets(25,0,0,10));;
        VBox mapaMundi = new VBox(hemisferioNorte, hemisferioSur, turnosActuales);

        return mapaMundi;
    }

    public void determinarTamanio(){

        botonArgentina.setPrefSize(30,30);
        botonBrasil.setPrefSize(30,30);
        botonUruguay.setPrefSize(30,30);
        botonPeru.setPrefSize(30,30);
        botonChile.setPrefSize(30,30);
        botonColombia.setPrefSize(30,30);

        botonMexico.setPrefSize(30,30);
        botonCalifornia.setPrefSize(30,30);
        botonOregon.setPrefSize(30,30);
        botonNuevaYork.setPrefSize(30,30);
        botonTerranova.setPrefSize(30,30);
        botonLabrador.setPrefSize(30,30);
        botonGroenlandia.setPrefSize(30,30);
        botonCanada.setPrefSize(30,30);
        botonYukon.setPrefSize(30,30);
        botonAlaska.setPrefSize(30,30);

        botonEspana.setPrefSize(30,30);
        botonFrancia.setPrefSize(30,30);
        botonIslandia.setPrefSize(30,30);
        botonGranBretana.setPrefSize(30,30);
        botonAlemania.setPrefSize(30,30);
        botonItalia.setPrefSize(30,30);
        botonPolonia.setPrefSize(30,30);
        botonRusia.setPrefSize(30,30);
        botonSuecia.setPrefSize(30,30);

        botonChina.setPrefSize(30,30);
        botonIran.setPrefSize(30,30);
        botonMalasia.setPrefSize(30,30);
        botonIndia.setPrefSize(30,30);
        botonArabia.setPrefSize(30,30);
        botonIsrael.setPrefSize(30,30);
        botonTurquia.setPrefSize(30,30);
        botonGobi.setPrefSize(30,30);
        botonMongolia.setPrefSize(30,30);
        botonSiberia.setPrefSize(30,30);
        botonAral.setPrefSize(30,30);
        botonTartaria.setPrefSize(30,30);
        botonTaymir.setPrefSize(30,30);
        botonKamchayka.setPrefSize(30,30);
        botonJapon.setPrefSize(30,30);

        botonSahara.setPrefSize(30,30);
        botonEgipto.setPrefSize(30,30);
        botonEtiopia.setPrefSize(30,30);
        botonZaire.setPrefSize(30,30);
        botonSudafrica.setPrefSize(30,30);
        botonMadagascar.setPrefSize(30,30);

        botonAustralia.setPrefSize(30,30);
        botonSumatra.setPrefSize(30,30);
        botonJava.setPrefSize(30,30);
        botonBorneo.setPrefSize(30,30);
    }

    public void determinarColor(){

        botonArgentina.setStyle("-fx-background-color:"+argentina.colorPorDuenio());
        botonBrasil.setStyle("-fx-background-color:"+brasil.colorPorDuenio());
        botonUruguay.setStyle("-fx-background-color:"+uruguay.colorPorDuenio());
        botonPeru.setStyle("-fx-background-color:"+peru.colorPorDuenio());
        botonChile.setStyle("-fx-background-color:"+chile.colorPorDuenio());
        botonColombia.setStyle("-fx-background-color:"+colombia.colorPorDuenio());

        botonMexico.setStyle("-fx-background-color:"+mexico.colorPorDuenio());
        botonCalifornia.setStyle("-fx-background-color:"+california.colorPorDuenio());
        botonOregon.setStyle("-fx-background-color:"+oregon.colorPorDuenio());
        botonNuevaYork.setStyle("-fx-background-color:"+nuevaYork.colorPorDuenio());
        botonTerranova.setStyle("-fx-background-color:"+terranova.colorPorDuenio());
        botonLabrador.setStyle("-fx-background-color:"+labrador.colorPorDuenio());
        botonGroenlandia.setStyle("-fx-background-color:"+groenlandia.colorPorDuenio());
        botonCanada.setStyle("-fx-background-color:"+canada.colorPorDuenio());
        botonYukon.setStyle("-fx-background-color:"+yukon.colorPorDuenio());
        botonAlaska.setStyle("-fx-background-color:"+alaska.colorPorDuenio());

        botonEspana.setStyle("-fx-background-color:"+espana.colorPorDuenio());
        botonFrancia.setStyle("-fx-background-color:"+francia.colorPorDuenio());
        botonIslandia.setStyle("-fx-background-color:"+islandia.colorPorDuenio());
        botonGranBretana.setStyle("-fx-background-color:"+granBretana.colorPorDuenio());
        botonAlemania.setStyle("-fx-background-color:"+alemania.colorPorDuenio());
        botonItalia.setStyle("-fx-background-color:"+italia.colorPorDuenio());
        botonPolonia.setStyle("-fx-background-color:"+polonia.colorPorDuenio());
        botonRusia.setStyle("-fx-background-color:"+rusia.colorPorDuenio());
        botonSuecia.setStyle("-fx-background-color:"+suecia.colorPorDuenio());

        botonChina.setStyle("-fx-background-color:"+china.colorPorDuenio());
        botonIran.setStyle("-fx-background-color:"+iran.colorPorDuenio());
        botonMalasia.setStyle("-fx-background-color:"+malasia.colorPorDuenio());
        botonIndia.setStyle("-fx-background-color:"+india.colorPorDuenio());
        botonArabia.setStyle("-fx-background-color:"+arabia.colorPorDuenio());
        botonIsrael.setStyle("-fx-background-color:"+israel.colorPorDuenio());
        botonTurquia.setStyle("-fx-background-color:"+turquia.colorPorDuenio());
        botonGobi.setStyle("-fx-background-color:"+gobi.colorPorDuenio());
        botonMongolia.setStyle("-fx-background-color:"+mongolia.colorPorDuenio());
        botonSiberia.setStyle("-fx-background-color:"+siberia.colorPorDuenio());
        botonAral.setStyle("-fx-background-color:"+aral.colorPorDuenio());
        botonTartaria.setStyle("-fx-background-color:"+tartaria.colorPorDuenio());
        botonTaymir.setStyle("-fx-background-color:"+taymir.colorPorDuenio());
        botonKamchayka.setStyle("-fx-background-color:"+kamchayka.colorPorDuenio());
        botonJapon.setStyle("-fx-background-color:"+japon.colorPorDuenio());

        botonSahara.setStyle("-fx-background-color:"+sahara .colorPorDuenio());
        botonEgipto.setStyle("-fx-background-color:"+egipto.colorPorDuenio());
        botonEtiopia.setStyle("-fx-background-color:"+etiopia.colorPorDuenio());
        botonZaire.setStyle("-fx-background-color:"+zaire.colorPorDuenio());
        botonSudafrica.setStyle("-fx-background-color:"+sudafrica.colorPorDuenio());
        botonMadagascar.setStyle("-fx-background-color:"+madagascar.colorPorDuenio());

        botonAustralia.setStyle("-fx-background-color:"+australia.colorPorDuenio());
        botonSumatra.setStyle("-fx-background-color:"+sumatra.colorPorDuenio());
        botonJava.setStyle("-fx-background-color:"+java.colorPorDuenio());
        botonBorneo.setStyle("-fx-background-color:"+borneo.colorPorDuenio());
    }

    public VBox copiarMapa(Stage stageMapa, Button botonAtacante, Pais atacante,boolean esAtaque){

        this.determinarTamanio();

        this.determinarColor();

        BotonCantidadEjercitosEventHandler botonDefiendeArgentinaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonArgentina, argentina, this);
        BotonCantidadEjercitosEventHandler botonDefiendeBrasilEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonBrasil, brasil, this);
        BotonCantidadEjercitosEventHandler botonDefiendeUruguayEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonUruguay, uruguay, this);
        BotonCantidadEjercitosEventHandler botonDefiendePeruEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonPeru, peru, this);
        BotonCantidadEjercitosEventHandler botonDefiendeChileEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonChile, chile, this);
        BotonCantidadEjercitosEventHandler botonDefiendeColombiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonColombia, colombia, this);

        BotonCantidadEjercitosEventHandler botonDefiendeMexicoEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonMexico, mexico, this);
        BotonCantidadEjercitosEventHandler botonDefiendeCaliforniaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonCalifornia, california, this);
        BotonCantidadEjercitosEventHandler botonDefiendeOregonEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonOregon, oregon, this);
        BotonCantidadEjercitosEventHandler botonDefiendeNuevaYorkEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonNuevaYork, nuevaYork, this);
        BotonCantidadEjercitosEventHandler botonDefiendeTerranovaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonTerranova, terranova, this);
        BotonCantidadEjercitosEventHandler botonDefiendeLabradorEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonLabrador, labrador, this);
        BotonCantidadEjercitosEventHandler botonDefiendeGroenlandiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonGroenlandia, groenlandia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeCanadaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonCanada, canada, this);
        BotonCantidadEjercitosEventHandler botonDefiendeYukonEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonYukon, yukon, this);
        BotonCantidadEjercitosEventHandler botonDefiendeAlaskaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonAlaska, alaska, this);

        BotonCantidadEjercitosEventHandler botonDefiendeEspanaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonEspana, espana, this);
        BotonCantidadEjercitosEventHandler botonDefiendeFranciaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonFrancia, francia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeIslandiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonIslandia, islandia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeGranBretanaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonGranBretana, granBretana, this);
        BotonCantidadEjercitosEventHandler botonDefiendeAlemaniaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonAlemania, alemania, this);
        BotonCantidadEjercitosEventHandler botonDefiendeItaliaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonItalia, italia, this);
        BotonCantidadEjercitosEventHandler botonDefiendePoloniaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonPolonia, polonia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeRusiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonRusia, rusia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeSueciaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonSuecia, suecia, this);

        BotonCantidadEjercitosEventHandler botonDefiendeChinaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonChina, china, this);
        BotonCantidadEjercitosEventHandler botonDefiendeIranEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonIran, iran, this);
        BotonCantidadEjercitosEventHandler botonDefiendeMalasiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonMalasia, malasia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeIndiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonIndia, india, this);
        BotonCantidadEjercitosEventHandler botonDefiendeArabiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonArabia, arabia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeIsraelEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonIsrael, israel, this);
        BotonCantidadEjercitosEventHandler botonDefiendeTurquiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonTurquia, turquia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeGobiEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonGobi, gobi, this);
        BotonCantidadEjercitosEventHandler botonDefiendeMongoliaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonMongolia, mongolia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeSiberiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonSiberia, siberia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeAralEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonAral, aral, this);
        BotonCantidadEjercitosEventHandler botonDefiendeTartariaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonTartaria, tartaria, this);
        BotonCantidadEjercitosEventHandler botonDefiendeTaymirEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonTaymir, taymir, this);
        BotonCantidadEjercitosEventHandler botonDefiendeKamchaykaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonKamchayka, kamchayka, this);
        BotonCantidadEjercitosEventHandler botonDefiendeJaponEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonJapon, japon, this);

        BotonCantidadEjercitosEventHandler botonDefiendeSaharaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonSahara, sahara, this);
        BotonCantidadEjercitosEventHandler botonDefiendeEgiptoEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonEgipto, egipto, this);
        BotonCantidadEjercitosEventHandler botonDefiendeEtiopiaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonEtiopia, etiopia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeZaireEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonZaire, zaire, this);
        BotonCantidadEjercitosEventHandler botonDefiendeSudafricaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonSudafrica, sudafrica, this);
        BotonCantidadEjercitosEventHandler botonDefiendeMadagascarEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonMadagascar, madagascar, this);

        BotonCantidadEjercitosEventHandler botonDefiendeAustraliaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonAustralia, australia, this);
        BotonCantidadEjercitosEventHandler botonDefiendeSumatraEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonSumatra, sumatra, this);
        BotonCantidadEjercitosEventHandler botonDefiendeJavaEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonJava, java, this);
        BotonCantidadEjercitosEventHandler botonDefiendeBorneoEjercitos = new BotonCantidadEjercitosEventHandler(esAtaque, stageMapa,botonAtacante, atacante, botonBorneo, borneo, this);

        botonArgentina.setOnAction(botonDefiendeArgentinaEjercitos);
        botonBrasil.setOnAction(botonDefiendeBrasilEjercitos);
        botonUruguay.setOnAction(botonDefiendeUruguayEjercitos);
        botonPeru.setOnAction(botonDefiendePeruEjercitos);
        botonChile.setOnAction(botonDefiendeChileEjercitos);
        botonColombia.setOnAction(botonDefiendeColombiaEjercitos);

        botonMexico.setOnAction(botonDefiendeMexicoEjercitos);
        botonCalifornia.setOnAction(botonDefiendeCaliforniaEjercitos);
        botonOregon.setOnAction(botonDefiendeOregonEjercitos);
        botonNuevaYork.setOnAction(botonDefiendeNuevaYorkEjercitos);
        botonTerranova.setOnAction(botonDefiendeTerranovaEjercitos);
        botonLabrador.setOnAction(botonDefiendeLabradorEjercitos);
        botonGroenlandia.setOnAction(botonDefiendeGroenlandiaEjercitos);
        botonCanada.setOnAction(botonDefiendeCanadaEjercitos);
        botonYukon.setOnAction(botonDefiendeYukonEjercitos);
        botonAlaska.setOnAction(botonDefiendeAlaskaEjercitos);

        botonEspana.setOnAction(botonDefiendeEspanaEjercitos);
        botonFrancia.setOnAction(botonDefiendeFranciaEjercitos);
        botonIslandia.setOnAction(botonDefiendeIslandiaEjercitos);
        botonGranBretana.setOnAction(botonDefiendeGranBretanaEjercitos);
        botonAlemania.setOnAction(botonDefiendeAlemaniaEjercitos);
        botonItalia.setOnAction(botonDefiendeItaliaEjercitos);
        botonPolonia.setOnAction(botonDefiendePoloniaEjercitos);
        botonRusia.setOnAction(botonDefiendeRusiaEjercitos);
        botonSuecia.setOnAction(botonDefiendeSueciaEjercitos);

        botonChina.setOnAction(botonDefiendeChinaEjercitos);
        botonIran.setOnAction(botonDefiendeIranEjercitos);
        botonMalasia.setOnAction(botonDefiendeMalasiaEjercitos);
        botonIndia.setOnAction(botonDefiendeIndiaEjercitos);
        botonArabia.setOnAction(botonDefiendeArabiaEjercitos);
        botonIsrael.setOnAction(botonDefiendeIsraelEjercitos);
        botonTurquia.setOnAction(botonDefiendeTurquiaEjercitos);
        botonGobi.setOnAction(botonDefiendeGobiEjercitos);
        botonMongolia.setOnAction(botonDefiendeMongoliaEjercitos);
        botonSiberia.setOnAction(botonDefiendeSiberiaEjercitos);
        botonAral.setOnAction(botonDefiendeAralEjercitos);
        botonTartaria.setOnAction(botonDefiendeTartariaEjercitos);
        botonTaymir.setOnAction(botonDefiendeTaymirEjercitos);
        botonKamchayka.setOnAction(botonDefiendeKamchaykaEjercitos);
        botonJapon.setOnAction(botonDefiendeJaponEjercitos);

        botonSahara.setOnAction(botonDefiendeSaharaEjercitos);
        botonEgipto.setOnAction(botonDefiendeEgiptoEjercitos);
        botonEtiopia.setOnAction(botonDefiendeEtiopiaEjercitos);
        botonZaire.setOnAction(botonDefiendeZaireEjercitos);
        botonSudafrica.setOnAction(botonDefiendeSudafricaEjercitos);
        botonMadagascar.setOnAction(botonDefiendeMadagascarEjercitos);

        botonAustralia.setOnAction(botonDefiendeAustraliaEjercitos);
        botonSumatra.setOnAction(botonDefiendeSumatraEjercitos);
        botonJava.setOnAction(botonDefiendeJavaEjercitos);
        botonBorneo.setOnAction(botonDefiendeBorneoEjercitos);

        HBox hemisferioNorte = new HBox(botonAlaska,botonYukon, botonOregon, botonCanada, botonCalifornia,botonNuevaYork, botonMexico,
                botonTerranova, botonLabrador, botonGroenlandia, botonIslandia, botonEspana, botonGranBretana, botonFrancia, botonSuecia,
                botonAlemania, botonItalia, botonPolonia, botonRusia, botonAral, botonIsrael, botonTurquia, botonTartaria, botonIran,
                botonArabia, botonTaymir, botonMongolia, botonSiberia, botonGobi, botonKamchayka, botonIndia, botonChina, botonMalasia, botonJapon);
        hemisferioNorte.setMargin(botonAlaska,new Insets(250,0,0,40));
        hemisferioNorte.setMargin(botonYukon,new Insets(190,0,0,35));
        hemisferioNorte.setMargin(botonOregon,new Insets(300,0,0,-35));
        hemisferioNorte.setMargin(botonCanada,new Insets(180,0,0,55));
        hemisferioNorte.setMargin(botonCalifornia,new Insets(285,0,0,0));
        hemisferioNorte.setMargin(botonNuevaYork,new Insets(240,0,0,-10));
        hemisferioNorte.setMargin(botonMexico,new Insets(320,0,0,0));
        hemisferioNorte.setMargin(botonTerranova,new Insets(225,0,0,0));
        hemisferioNorte.setMargin(botonLabrador,new Insets(190,0,0,0));
        hemisferioNorte.setMargin(botonGroenlandia,new Insets(140,0,0,70));

        hemisferioNorte.setMargin(botonIslandia,new Insets(240,0,0,100));
        hemisferioNorte.setMargin(botonEspana,new Insets(360,0,0,70));
        hemisferioNorte.setMargin(botonGranBretana,new Insets(260,0,0,0));
        hemisferioNorte.setMargin(botonFrancia,new Insets(320,0,0,20));
        hemisferioNorte.setMargin(botonSuecia,new Insets(170,0,0,0));
        hemisferioNorte.setMargin(botonAlemania,new Insets(280,0,0,20));
        hemisferioNorte.setMargin(botonItalia,new Insets(370,0,0,-30));
        hemisferioNorte.setMargin(botonPolonia,new Insets(290,0,0,40));
        hemisferioNorte.setMargin(botonRusia,new Insets(190,0,0,-40));

        hemisferioNorte.setMargin(botonAral,new Insets(150,0,0,25));
        hemisferioNorte.setMargin(botonIsrael,new Insets(345,0,0,0));
        hemisferioNorte.setMargin(botonTurquia,new Insets(302,0,0,-20));
        hemisferioNorte.setMargin(botonTartaria,new Insets(120,0,0,-30));
        hemisferioNorte.setMargin(botonIran,new Insets(260,0,0,0));
        hemisferioNorte.setMargin(botonArabia,new Insets(365,0,0,-20));
        hemisferioNorte.setMargin(botonTaymir,new Insets(125,0,0,-30));
        hemisferioNorte.setMargin(botonMongolia,new Insets(205,0,0,-20));
        hemisferioNorte.setMargin(botonSiberia,new Insets(165,0,0,-20));
        hemisferioNorte.setMargin(botonGobi,new Insets(245,0,0,0));
        hemisferioNorte.setMargin(botonKamchayka,new Insets(125,0,0,0));
        hemisferioNorte.setMargin(botonIndia,new Insets(330,0,0,-10));
        hemisferioNorte.setMargin(botonChina,new Insets(220,0,0,-10));
        hemisferioNorte.setMargin(botonMalasia,new Insets(310,0,0,30));
        hemisferioNorte.setMargin(botonJapon,new Insets(165,0,0,-20));

        HBox hemisferioSur = new HBox(botonColombia, botonPeru, botonChile, botonArgentina, botonUruguay, botonBrasil, botonSahara,
                botonZaire, botonEtiopia, botonSudafrica, botonEgipto, botonMadagascar, botonSumatra, botonBorneo, botonAustralia, botonJava);
        hemisferioSur.setMargin(botonColombia, new Insets(-35,0,0,400));
        hemisferioSur.setMargin(botonPeru, new Insets(10,0,0,-30));
        hemisferioSur.setMargin(botonChile, new Insets(70,0,0,-45));
        hemisferioSur.setMargin(botonArgentina, new Insets(80,0,0,20));
        hemisferioSur.setMargin(botonUruguay, new Insets(50,0,0,25));
        hemisferioSur.setMargin(botonBrasil, new Insets(0,0,0,10));

        hemisferioSur.setMargin(botonSahara, new Insets(40,0,0,220));
        hemisferioSur.setMargin(botonZaire, new Insets(80,0,0,30));
        hemisferioSur.setMargin(botonEtiopia, new Insets(55,0,0,20));
        hemisferioSur.setMargin(botonSudafrica, new Insets(110,0,0,-10));
        hemisferioSur.setMargin(botonEgipto, new Insets(20,0,0,-20));
        hemisferioSur.setMargin(botonMadagascar, new Insets(85,0,0,60));

        hemisferioSur.setMargin(botonSumatra, new Insets(10,0,0,30));
        hemisferioSur.setMargin(botonBorneo, new Insets(-30,0,0,65));
        hemisferioSur.setMargin(botonAustralia, new Insets(60,0,0,0));
        hemisferioSur.setMargin(botonJava, new Insets(-32,0,0,0));


        VBox mapaMundi = new VBox(hemisferioNorte, hemisferioSur);

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

    public void mover(TextField texto,Button botonAtacante,Pais donante,Button botonDefensor,Pais receptor){
        Integer cantidadEjercitos = Integer.valueOf(texto.getText());
        turno.jugadorActual().moverEjercitos(receptor, donante, cantidadEjercitos);

        botonAtacante.setText(Integer.toString(donante.ejercitos()));
        botonDefensor.setText(Integer.toString(receptor.ejercitos()));
    }
}
