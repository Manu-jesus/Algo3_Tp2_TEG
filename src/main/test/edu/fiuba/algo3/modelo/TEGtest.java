package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TEGtest {
    @Test
    public void atacarPaises(){
        Dados dadosAtacante = new Dados();
        Dados dadosDefensor = new Dados();
        Dados spyAtacante = Mockito.spy(dadosAtacante);
        Dados spyDefensor = Mockito.spy(dadosDefensor);

        Jugador albiceleste = new Jugador(spyAtacante);
        Jugador brazuca = new Jugador(spyDefensor);
        Pais arg = new Pais(2,albiceleste);
        Pais bra = new Pais(1,brazuca);
        bra.agregarPaisLimitrofes(arg);
        arg.agregarPaisLimitrofes(bra);

        ArrayList<Integer> dadosCargadosAtacante = new ArrayList<>();
        dadosCargadosAtacante.add(2);
        dadosCargadosAtacante.add(5);
        ArrayList<Integer> dadosCargadosDefensor = new ArrayList<>();
        dadosCargadosDefensor.add(6);


        doReturn(dadosCargadosAtacante).when(spyAtacante).hacerTirada(1);
        doReturn(dadosCargadosDefensor).when(spyDefensor).hacerTirada(1);
        albiceleste.atacarAPais(arg,bra,1);

        assertEquals(1,arg.ejercitos());
        assertEquals(1,bra.ejercitos());
    }
    @Test
    public void atacarYConquistar(){
        Dados dadosAtacante = new Dados();
        Dados dadosDefensor = new Dados();
        Dados spyAtacante = Mockito.spy(dadosAtacante);
        Dados spyDefensor = Mockito.spy(dadosDefensor);

        Jugador albiceleste = new Jugador(spyAtacante);
        Jugador brazuca = new Jugador(spyDefensor);
        Pais arg = new Pais(3,albiceleste);
        Pais bra = new Pais(2,brazuca);
        bra.agregarPaisLimitrofes(arg);
        arg.agregarPaisLimitrofes(bra);

        ArrayList<Integer> dadosCargadosAtacante = new ArrayList<>();
        dadosCargadosAtacante.add(3);
        dadosCargadosAtacante.add(5);

        ArrayList<Integer> dadosCargadosDefensor = new ArrayList<>();
        dadosCargadosDefensor.add(1);
        dadosCargadosDefensor.add(2);


        doReturn(dadosCargadosAtacante).when(spyAtacante).hacerTirada(2);
        doReturn(dadosCargadosDefensor).when(spyDefensor).hacerTirada(2);
        albiceleste.atacarAPais(arg,bra,2);
        assertEquals(2,arg.ejercitos());
        assertEquals(1,bra.ejercitos());


    }
    @Test
    public void colocarEjercitos(){
        Dados dadosAtacante = new Dados();
        Jugador albiceleste = new Jugador(dadosAtacante);
        Pais arg = new Pais(3,albiceleste);

        arg.agregarEjercitos(albiceleste,4);
        assertEquals(7,arg.ejercitos());
    }
}
