package edu.fiuba.algo3.modelo;

public class TarjetaPais {
    private Pais pais;
    private TarjetaEstaActivada estaActivada;

    public TarjetaPais(Pais pais){
        this.pais = pais;
        this.estaActivada = new TarjetaNoActivada();
    }

    public void activar(){
        if(this.estaActivada.estaActivada()){
            throw new LaTarjetaYaFueActivadaError();
        }
        this.pais.agregarEjercitos(2);
        this.estaActivada = new TarjetaActivada();
    }
}
