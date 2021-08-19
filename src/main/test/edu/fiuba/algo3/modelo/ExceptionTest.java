package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

public class ExceptionTest {
    private Dados dadosAzul;
    private Dados dadosRojo;
    private Dados dadosAmarillo;

    private Jugador azul;
    private Jugador rojo;
    private Jugador amarillo;

    private Continente america;
    private Continente asia;

    private tarjetaObjetivo objetivoRojo;
    private tarjetaObjetivo objetivoAzul;
    private tarjetaObjetivo objetivoAmarillo;

    private Pais arg;
    private Pais bra;

    private Turno turno;

    @BeforeEach
    void init(){
        //Dados
        dadosAzul = new Dados();
        dadosRojo = new Dados();
        dadosAmarillo = new Dados();

        //Continentes
        america = new Continente("america",3);
        asia = new Continente("asia",7);

        //tarjetaObjeivo
        objetivoRojo = new tarjetaObjetivo(america);
        objetivoAzul = new tarjetaObjetivo(america);
        objetivoAmarillo = new tarjetaObjetivo(america);

        //paises
        arg = new Pais(2,america,"arg");

        bra = new Pais(1,america,"bra");

        //turno
        ArrayList <Pais> paises= new ArrayList<>();
        paises.add(arg);
        paises.add(bra);
        turno = new Turno(paises);

        //Jugadores
        azul = new Jugador(dadosAzul, turno, "azul");
        azul.asignarObjetivo(objetivoAzul);
        rojo = new Jugador(dadosRojo, turno, "rojo");
        rojo.asignarObjetivo(objetivoRojo);
        amarillo = new Jugador(dadosAmarillo, turno, "amarillo");
        amarillo.asignarObjetivo(objetivoAmarillo);


    }

    @Test
    public void ElPaisAtacanteNoPerteneceAlQueAtaca(){
        arg.asignarDuenio(rojo);
        bra.asignarDuenio(azul);
        bra.agregarPaisLimitrofe(arg);

        assertThrows(ElPaisAtacanteNoTePerteneceError.class, ()-> azul.atacarAPais(arg,bra,1));
    }
    @Test
    public void ElPaisDefensorPerteneceAlAtacante(){
        arg.asignarDuenio(rojo);
        bra.asignarDuenio(rojo);
        bra.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(bra);

        assertThrows(NoPuedesAtacarAUnPaisPropioError.class, ()-> rojo.atacarAPais(arg,bra,1));
    }

    @Test
    public void ElPaisAcanteDebeManenerAlmenosUnEjercitoEnElMismo(){
        arg.asignarDuenio(azul);
        bra.asignarDuenio(rojo);
        bra.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(bra);

        assertThrows(ElPaisAtacanteSiempreDebeMantenerUnEjercitoEnElPaisError.class, ()-> azul.atacarAPais(arg,bra,2));
    }
    @Test
    public void LosPaisesDebenSerLimitrofesParaPoderAtacarse(){
        arg.asignarDuenio(azul);
        bra.asignarDuenio(rojo);


        assertThrows(LosPaisesNoSonLimitrofesError.class, ()-> azul.atacarAPais(arg,bra,1));
    }
    @Test
    public void NoEsPosibleRestarEsaCantidadDeEjercitos(){
        arg.asignarDuenio(azul);
        bra.asignarDuenio(azul);
        bra.agregarPaisLimitrofe(arg);

        assertThrows(NoEsPosibleRestarEsaCantidadDeEjercitosError.class, ()-> azul.moverEjercitos(arg,bra,4));
    }
}
