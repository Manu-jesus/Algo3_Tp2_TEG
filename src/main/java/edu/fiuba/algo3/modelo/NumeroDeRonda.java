package edu.fiuba.algo3.modelo;

public interface NumeroDeRonda {

    Integer ejercitosAColocar(Jugador jugador);
    NumeroDeRonda pasarRonda();
    boolean sePuedeAtacar();
}
