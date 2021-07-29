package edu.fiuba.algo3.modelo;

public class TerceraRondaOMas  implements NumeroDeRonda{
    @Override
    public Integer ejercitosAColocar(Jugador jugador){
        if((jugador.cantidadPaises())/2 < 3){
            return 3;
        }
        return ((jugador.cantidadPaises())/2);
    }

    public NumeroDeRonda pasarRonda(){
        return this;
    }
}

