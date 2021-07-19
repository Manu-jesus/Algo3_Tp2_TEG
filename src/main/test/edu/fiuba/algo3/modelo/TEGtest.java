package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @BeforeEach
    void init(){
        dadosAzul = new Dados();
        dadosRojo = new Dados();
        azul = new Jugador(dadosAzul);
        rojo = new Jugador(dadosRojo);
        dadosAmarillo = new Dados();
        amarillo = new Jugador(dadosAmarillo);
        america = new Continente();
        asia = new Continente();
    }

    @Test
    public void atacarPaises(){
        Dados spyAtacante = Mockito.spy(dadosAzul);
        Dados spyDefensor = Mockito.spy(dadosRojo);

        azul = new Jugador(spyAtacante);
        rojo = new Jugador(spyDefensor);
        Pais arg = new Pais(2,azul,america);
        Pais bra = new Pais(1,rojo,america);
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

        azul = new Jugador(dadosAtacante);
        rojo = new Jugador(dadosDefensor);
        Pais argentina = new Pais(3,azul,america);
        Pais brasil = new Pais(2,rojo,america);
        brasil.agregarPaisLimitrofe(argentina);
        argentina.agregarPaisLimitrofe(brasil);

        ArrayList<Integer> dadosCargadosAtacante = new ArrayList<>();
        dadosCargadosAtacante.add(3);
        dadosCargadosAtacante.add(5);

        ArrayList<Integer> dadosCargadosDefensor = new ArrayList<>();
        dadosCargadosDefensor.add(1);
        dadosCargadosDefensor.add(2);


        doReturn(dadosCargadosAtacante).when(dadosAtacante).hacerTirada(2);
        doReturn(dadosCargadosDefensor).when(dadosDefensor).hacerTirada(2);
        azul.atacarAPais(argentina,brasil,2);
        assertEquals(2,argentina.ejercitos());
        assertEquals(1,brasil.ejercitos());

    }
    @Test
    public void colocarEjercitos(){
        Pais arg = new Pais(3,azul,america);

        azul.agregarEjercitosA(arg,4);
        assertEquals(7,arg.ejercitos());
    }

    @Test
    public void activarTarjetaPais(){
        Pais arg = new Pais(3,azul,america);
        TarjetaPais tarjetaArg = new TarjetaPais(arg);
        azul.agregarTarjetaPais(tarjetaArg);
        azul.activarTarjetaPais(tarjetaArg);

        assertEquals(5,arg.ejercitos());
    }

    @Test
    public void dosJugadoresColocanEjercitos(){
        Pais arg = new Pais(3,azul,america);
        Pais bra = new Pais(2,rojo,america);

        azul.agregarEjercitosA(arg,5);
        rojo.agregarEjercitosA(bra,5);

        assertEquals(8,arg.ejercitos());
        assertEquals(7,bra.ejercitos());
    }

    @Test
    public void colocarEjercitosTeniendoUnContinente(){
        Pais iran = new Pais(2,rojo,asia);
        Pais gobi = new Pais(2,rojo,asia);
        Pais arg = new Pais(3,azul,america);
        Pais bra = new Pais(2,amarillo,america);
        rojo.conquistarContinente(asia);

        azul.agregarEjercitosA(arg,3); //turno azul

        rojo.agregarEjercitosA(iran,5); //turno rojo
        rojo.agregarEjercitosA(gobi,5);

        amarillo.agregarEjercitosA(bra,3); //turno amarillo

        assertEquals(6,arg.ejercitos());
        assertEquals(7,iran.ejercitos());
        assertEquals(7,gobi.ejercitos());
        assertEquals(5,bra.ejercitos());

    }

    @Test
    public void conquistar2Paises(){
        Dados spyAtacante = Mockito.spy(dadosAzul);
        Dados spyDefensor = Mockito.spy(dadosRojo);

        azul = new Jugador(spyAtacante);
        rojo = new Jugador(spyDefensor);
        Pais arg = new Pais(6,azul,america);
        Pais bra = new Pais(3,rojo,america);
        Pais chile = new Pais(2,rojo,america);
        bra.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(bra);
        chile.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(chile);

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
