package edu.fiuba.algo3.modelo;

public class PrimerCanje implements NumeroDeCanje{
    public Integer cantidadEjercitosAColocar(){
        return 4;
    }
    public NumeroDeCanje hacerCanje(){
        return new SegundaCanje();
    }
}
