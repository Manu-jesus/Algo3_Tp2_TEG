package edu.fiuba.algo3.modelo;

public class TercerCanje implements NumeroDeCanje{
    public Integer cantidadEjercitosAColocar(){
        return 10;
    }
    public NumeroDeCanje hacerCanje(){
        return new CuartoCanjeOMas();
    }
}
