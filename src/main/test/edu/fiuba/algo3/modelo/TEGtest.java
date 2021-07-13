package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class TEGtest {
    @Test
    public void atacarPaises(){
        TEG teg = new TEG();
        Jugador albiceleste = new Jugador();
        albiceleste.agregarPais(teg.buscarPais("Argentina"));
        Jugador brazuca = new Jugador();
        brazuca.agregarPais(teg.buscarPais("Brasil"));

        ArrayList<Integer> dadosAtacante = mock(ArrayList.class);
        dadosAtacante.add(2);

        ArrayList<Integer> dadosDefensor = mock(ArrayList.class);
        dadosDefensor.add(6);

        Dados spyDados = mock(Dados.class);
        //Dados dado = spy(new Dados());
        doReturn(dadosAtacante).when(spyDados).tirarVeces(1);
        doReturn(dadosDefensor).when(spyDados).tirarVeces(2);
        teg.atacarConA(albiceleste,"Argentina","Brasil",1);

        assertEquals(2,teg.buscarPais("Argentina").ejercitos());
        assertEquals(1,teg.buscarPais("Brasil").ejercitos());
    }

    @Test
    public void atacarYConquistar(){
        TEG teg = new TEG();
        Jugador albiceleste = new Jugador();
        albiceleste.agregarPais(teg.buscarPais("Argentina"));
        Jugador brazuca = new Jugador();
        brazuca.agregarPais(teg.buscarPais("Brasil"));

        ArrayList<Integer> dadosAtacante = mock(ArrayList.class);
        dadosAtacante.add(2);

        ArrayList<Integer> dadosDefensor = mock(ArrayList.class);
        dadosDefensor.add(6);

        Dados spyDados = mock(Dados.class);
        //Dados dado = spy(new Dados());
        doReturn(dadosAtacante).when(spyDados).tirarVeces(1);
        doReturn(dadosDefensor).when(spyDados).tirarVeces(2);
        teg.atacarConA(albiceleste,"Argentina","Brasil",1);
        teg.conquistar(albiceleste,"Argentina","Brasil",2);
        assertEquals(2,teg.buscarPais("Brasil").ejercitos());
        assertEquals(1,teg.buscarPais("Argentina").ejercitos());

    }

    @Test
    public void colocarEjercitos(){
        TEG teg = new TEG();
        Jugador albiceleste = new Jugador();
        albiceleste.agregarPais(teg.buscarPais("Argentina"));
        Jugador brazuca = new Jugador();
        albiceleste.agregarPais(teg.buscarPais("Brasil"));


        teg.colocarEjercitos(albiceleste,"Argentina",5);
        assertEquals(8,teg.buscarPais("Argentina").ejercitos());
    }
}
