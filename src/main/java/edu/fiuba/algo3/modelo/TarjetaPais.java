package edu.fiuba.algo3.modelo;

public class TarjetaPais {
    private Pais pais;
    private TarjetaEstaActivada estaActivada;

    public TarjetaPais(Pais pais){
        this.pais = pais;
        this.estaActivada = new TarjetaNoActivada();
    }

    public Pais pais(){
        return this.pais;
    }

    public void activar(){
        if(this.estaActivada.estaActivada()){
            return;
        }
        this.pais.agregarEjercitos(2);
        this.estaActivada = new TarjetaActivada();
    }
}
