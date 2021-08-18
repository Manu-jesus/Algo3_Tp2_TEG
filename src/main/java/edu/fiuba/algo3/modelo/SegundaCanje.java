package edu.fiuba.algo3.modelo;

public class SegundaCanje implements NumeroDeCanje{
    public Integer cantidadEjercitosAColocar(){
        return 7;
    }
    public NumeroDeCanje hacerCanje(){
        return new TercerCanje();
    }
}
