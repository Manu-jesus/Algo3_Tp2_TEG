package edu.fiuba.algo3.modelo;

public class PrimeraRonda implements NumeroDeRonda{
    @Override
    public Integer ejercitosAColocar(Jugador jugador){
        return 5;
    }

    public NumeroDeRonda pasarRonda(){
        return new SegundaRonda();
    }
    public boolean sePuedeAtacar(){
        return false;
    }
}
