package edu.fiuba.algo3.modelo;

public class TarjetaPais {
    private Pais pais;
    private boolean estaActivada;

    public TarjetaPais(Pais pais){
        this.pais = pais;
        this.estaActivada = false;
    }

    public void activar(){
        if(this.estaActivada){
            throw new LaTarjetaYaFueActivadaError();
        }
        this.pais.agregarEjercitos(2);
        this.estaActivada = true;
    }
}
