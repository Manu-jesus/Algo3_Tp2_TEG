package edu.fiuba.algo3.modelo;

public class CuartoCanjeOMas implements NumeroDeCanje{
    private Integer numeroDeCanje;

    public CuartoCanjeOMas(){
        this.numeroDeCanje= 4;
    }

    public Integer cantidadEjercitosAColocar(){
        return (this.numeroDeCanje-1)*5;
    }
    public NumeroDeCanje hacerCanje(){
        this.numeroDeCanje++;
        return this;
    }
}
