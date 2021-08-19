package edu.fiuba.algo3.modelo;

public class TerceraRondaOMas  implements NumeroDeRonda{
    @Override
    public Integer ejercitosAColocar(Jugador jugador){
        if((jugador.cantidadPaises())/2 < 3){
            return 3;
        }
        Integer ejercitosPorContinentes = 0;
        for(int i=0; i<jugador.continentes().size();i++){
            ejercitosPorContinentes+=jugador.continentes().get(i).ejercitosExtra();
        }

        return ((jugador.cantidadPaises())/2)+ejercitosPorContinentes;
    }

    public NumeroDeRonda pasarRonda(){
        return this;
    }
    public boolean sePuedeAtacar(){
        return true;
    }
}

