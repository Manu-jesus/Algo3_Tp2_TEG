package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TEGtest {


    private Dados dadosAzul;
    private Dados dadosRojo;
    private Jugador azul;
    private Jugador rojo;
    private Dados dadosAmarillo;
    private Jugador amarillo;
    private Continente america;
    private Continente asia;
    private tarjetaObjetivo objetivoRojo;
    private tarjetaObjetivo objetivoAzul;
    private tarjetaObjetivo objetivoAmarillo;
    private Turno turno;

    @BeforeEach
    void init(){
        ArrayList <Pais> paises = new ArrayList<>();
        turno = new Turno(paises);
        dadosAzul = new Dados();
        dadosRojo = new Dados();
        dadosAmarillo = new Dados();
        america = new Continente("america");
        asia = new Continente("asia");
        objetivoRojo = new tarjetaObjetivo(america);
        objetivoAmarillo= new tarjetaObjetivo(america);
        objetivoAzul = new tarjetaObjetivo(america);
        azul = new Jugador(dadosAzul, turno, "azul");
        azul.asignarObjetivo(objetivoAzul);
        rojo = new Jugador(dadosRojo, turno, "rojo");
        rojo.asignarObjetivo(objetivoRojo);
        amarillo = new Jugador(dadosAmarillo, turno, "amarillo");
        amarillo.asignarObjetivo(objetivoAmarillo);
    }

    @Test
    public void atacarPaises(){
        Dados spyAtacante = Mockito.spy(dadosAzul);
        Dados spyDefensor = Mockito.spy(dadosRojo);

        azul = new Jugador(spyAtacante,turno, "azul");
        azul.asignarObjetivo(objetivoAzul);
        rojo = new Jugador(spyDefensor,turno, "rojo");
        rojo.asignarObjetivo(objetivoRojo);
        Pais arg = new Pais(2,america,"arg");
        arg.asignarDuenio(azul);
        Pais bra = new Pais(1,america,"bra");
        bra.asignarDuenio(rojo);
        bra.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(bra);

        ArrayList<Integer> dadosCargadosAtacante = new ArrayList<>();
        dadosCargadosAtacante.add(2);
        ArrayList<Integer> dadosCargadosDefensor = new ArrayList<>();
        dadosCargadosDefensor.add(6);


        doReturn(dadosCargadosAtacante).when(spyAtacante).hacerTirada(1);
        doReturn(dadosCargadosDefensor).when(spyDefensor).hacerTirada(1);
        azul.atacarAPais(arg,bra,1);

        assertEquals(1,arg.ejercitos());
        assertEquals(1,bra.ejercitos());
    }
    @Test
    public void atacarYConquistar(){
        Dados dadosAtacante = Mockito.spy(dadosAzul);
        Dados dadosDefensor = Mockito.spy(dadosRojo);

        azul = new Jugador(dadosAtacante,turno, "azul");
        azul.asignarObjetivo(objetivoAzul);
        rojo = new Jugador(dadosDefensor,turno, "rojo");
        rojo.asignarObjetivo(objetivoRojo);
        Pais arg = new Pais(3,america,"arg");
        arg.asignarDuenio(azul);
        Pais bra = new Pais(2,america,"bra");
        bra.asignarDuenio(rojo);
        bra.agregarPaisLimitrofe(arg);

        ArrayList<Integer> dadosCargadosAtacante = new ArrayList<>();
        dadosCargadosAtacante.add(3);
        dadosCargadosAtacante.add(5);

        ArrayList<Integer> dadosCargadosDefensor = new ArrayList<>();
        dadosCargadosDefensor.add(1);
        dadosCargadosDefensor.add(2);


        doReturn(dadosCargadosAtacante).when(dadosAtacante).hacerTirada(2);
        doReturn(dadosCargadosDefensor).when(dadosDefensor).hacerTirada(2);
        azul.atacarAPais(arg,bra,2);
        assertEquals(2,arg.ejercitos());
        assertEquals(1,bra.ejercitos());

    }
    @Test
    public void colocarEjercitos(){
        Pais arg = new Pais(3,america,"arg");
        arg.asignarDuenio(azul);

        azul.agregarEjercitosA(arg,3);
        assertEquals(6,arg.ejercitos());
    }

    @Test
    public void activarTarjetaPais(){
        Pais arg = new Pais(3,america,"arg");
        arg.asignarDuenio(azul);
        TarjetaPais tarjetaArg = new TarjetaPais(arg);
        azul.agregarTarjetaPais(tarjetaArg);
        azul.activarTarjetaPais(tarjetaArg);

        assertEquals(5,arg.ejercitos());
    }

    @Test
    public void dosJugadoresColocanEjercitos(){
        Pais arg = new Pais(3,america,"arg");
        arg.asignarDuenio(azul);
        Pais bra = new Pais(2,america,"bra");
        bra.asignarDuenio(rojo);

        azul.agregarEjercitosA(arg,3);
        turno.pasarTurno();
        rojo.agregarEjercitosA(bra,3);

        assertEquals(6,arg.ejercitos());
        assertEquals(5,bra.ejercitos());
    }

    @Test
    public void colocarEjercitosTeniendoUnContinente(){
        Pais iran = new Pais(2,asia,"iran");
        iran.asignarDuenio(rojo);
        Pais gobi = new Pais(2,asia,"gobi");
        gobi.asignarDuenio(rojo);
        Pais arg = new Pais(3,america,"arg");
        arg.asignarDuenio(azul);
        Pais bra = new Pais(2,america,"bra");
        bra.asignarDuenio(amarillo);
        rojo.conquistarContinente(asia);

        azul.agregarEjercitosA(arg,3); //turno azul
        turno.pasarTurno();
        rojo.agregarEjercitosA(iran,1); //turno rojo
        rojo.agregarEjercitosA(gobi,2);
        turno.pasarTurno();
        amarillo.agregarEjercitosA(bra,3); //turno amarillo

        assertEquals(6,arg.ejercitos());
        assertEquals(3,iran.ejercitos());
        assertEquals(4,gobi.ejercitos());
        assertEquals(5,bra.ejercitos());

    }

    @Test
    public void conquistar2Paises(){
        Dados spyAtacante = Mockito.spy(dadosAzul);
        Dados spyDefensor = Mockito.spy(dadosRojo);

        azul = new Jugador(spyAtacante,turno, "azul");
        azul.asignarObjetivo(objetivoAzul);
        rojo = new Jugador(spyDefensor,turno, "rojo");
        rojo.asignarObjetivo(objetivoRojo);
        Pais arg = new Pais(6,america,"arg");
        arg.asignarDuenio(azul);
        Pais bra = new Pais(2,america,"bra");
        bra.asignarDuenio(rojo);
        Pais chile = new Pais(2,america,"chile");
        chile.asignarDuenio(rojo);
        bra.agregarPaisLimitrofe(arg);
        chile.agregarPaisLimitrofe(arg);

        ArrayList<Integer> dadosCargadosAtacante = new ArrayList<>();
        dadosCargadosAtacante.add(3);
        dadosCargadosAtacante.add(4);
        dadosCargadosAtacante.add(5);

        ArrayList<Integer> dadosCargadosDefensor = new ArrayList<>();
        dadosCargadosDefensor.add(1);
        dadosCargadosDefensor.add(2);
        dadosCargadosDefensor.add(3);

        ArrayList<Integer> dadosCargadosAtacante2 = new ArrayList<>();
        dadosCargadosAtacante2.add(2);
        dadosCargadosAtacante2.add(3);

        ArrayList<Integer> dadosCargadosDefensor2 = new ArrayList<>();
        dadosCargadosDefensor2.add(1);
        dadosCargadosDefensor2.add(2);




        doReturn(dadosCargadosAtacante).when(spyAtacante).hacerTirada(3);
        doReturn(dadosCargadosDefensor).when(spyDefensor).hacerTirada(3);
        doReturn(dadosCargadosDefensor2).when(spyDefensor).hacerTirada(2);
        doReturn(dadosCargadosAtacante2).when(spyAtacante).hacerTirada(2);
        azul.atacarAPais(arg,bra,3);

        assertEquals(5,arg.ejercitos());
        assertEquals(1,bra.ejercitos());

        azul.atacarAPais(arg,chile,2);

        assertEquals(4,arg.ejercitos());
        assertEquals(1,chile.ejercitos());

    }
}
