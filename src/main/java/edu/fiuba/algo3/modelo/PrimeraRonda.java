package edu.fiuba.algo3.modelo;

public class PrimeraRonda implements NumeroDeRonda{
    @Override
    public Integer ejercitosAColocar(Jugador jugador){
        return 3;
    }

    public NumeroDeRonda pasarRonda(){
        return new SegundaRonda();
    }
}
