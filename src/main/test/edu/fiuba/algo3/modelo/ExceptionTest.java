package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;

public class ExceptionTest {
/*    private Dados dadosAzul;
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

    private Turno turno;

    @BeforeEach
    void init(){
        //Dados
        dadosAzul = new Dados();
        dadosRojo = new Dados();
        dadosAmarillo = new Dados();

        //Continentes
        america = new Continente("america");
        asia = new Continente("asia");

        //tarjetaObjeivo
        objetivoRojo = new tarjetaObjetivo(america);
        objetivoAzul = new tarjetaObjetivo(america);
        objetivoAmarillo = new tarjetaObjetivo(america);

        turno = new Turno();

        //Jugadores
        azul = new Jugador(dadosAzul,objetivoAzul, turno, "azul");
        rojo = new Jugador(dadosRojo,objetivoRojo, turno, "rojo");
        amarillo = new Jugador(dadosAmarillo,objetivoAmarillo, turno, "amarillo");


    }
    @Test
    public void NoSePuedeActivarUnaTarjetaPaisSinElPais(){
        Pais arg = new Pais(3,rojo,america);
        TarjetaPais tarjetaArg = new TarjetaPais(arg);
        rojo.agregarTarjetaPais(tarjetaArg);

        assertThrows(LaTarjetaPaisNoSeEncontroError.class, ()-> azul.activarTarjetaPais(tarjetaArg));
    }

    @Test
    public void ElPaisAtacanteNoPerteneceAlQueAtaca(){
        Pais arg = new Pais(2,rojo,america);
        Pais bra = new Pais(1,azul,america);
        bra.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(bra);

        assertThrows(ElPaisAtacanteNoTePerteneceError.class, ()-> azul.atacarAPais(arg,bra,1));
    }
    @Test
    public void ElPaisDefensorPerteneceAlAtacante(){
        Pais arg = new Pais(2,rojo,america);
        Pais bra = new Pais(1,rojo,america);
        bra.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(bra);

        assertThrows(NoPuedesAtacarAUnPaisPropioError.class, ()-> rojo.atacarAPais(arg,bra,1));
    }

    @Test
    public void ElPaisAcanteDebeManenerAlmenosUnEjercitoEnElMismo(){
        Pais arg = new Pais(2,azul,america);
        Pais bra = new Pais(2,rojo,america);
        bra.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(bra);

        assertThrows(ElPaisAtacanteSiempreDebeMantenerUnEjercitoEnElPaisError.class, ()-> azul.atacarAPais(arg,bra,2));
    }
    @Test
    public void LosPaisesDebenSerLimitrofesParaPoderAtacarse(){
        Pais arg = new Pais(2,azul,america);
        Pais bra = new Pais(2,rojo,america);
        //bra.agregarPaisLimitrofes(arg);
        //arg.agregarPaisLimitrofes(bra);

        assertThrows(LosPaisesNoSonLimitrofesError.class, ()-> azul.atacarAPais(arg,bra,1));
    }
    @Test
    public void NoEsPosibleRestarEsaCantidadDeEjercitos(){
        Pais arg = new Pais(3,azul,america);
        Pais bra = new Pais(2,azul,america);
        bra.agregarPaisLimitrofe(arg);
        arg.agregarPaisLimitrofe(bra);

        assertThrows(NoEsPosibleRestarEsaCantidadDeEjercitosError.class, ()-> azul.moverEjercitos(arg,bra,4));
    }
    @Test
    public void LaTarjetaYaFueActivada(){
        Pais arg = new Pais(3,azul,america);
        TarjetaPais tarjetaArg = new TarjetaPais(arg);
        azul.agregarTarjetaPais(tarjetaArg);
        azul.activarTarjetaPais(tarjetaArg);

        assertThrows(LaTarjetaYaFueActivadaError.class, ()-> azul.activarTarjetaPais(tarjetaArg));
    }*/
}
