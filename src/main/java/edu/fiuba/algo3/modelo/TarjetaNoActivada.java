package edu.fiuba.algo3.modelo;

public class TarjetaNoActivada implements TarjetaEstaActivada{
    @Override
    public boolean estaActivada(){
        return false;
    }
}
