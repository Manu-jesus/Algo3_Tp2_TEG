package edu.fiuba.algo3.modelo;

import java.util.ArrayList;


public class Dados {
    private ArrayList<Integer> tirada;

    public Dados(){
        this.tirada = new ArrayList<>();
    }

    public void tirar(Integer cantidadEjercitos){
        this.tirada=hacerTirada(cantidadEjercitos);
    }

    public ArrayList<Integer> hacerTirada(Integer cantidadEjercitos){
        ArrayList<Integer> tirada = new ArrayList<>();
        for (int i = 0; i < cantidadEjercitos && i < 3; i++) {
            Integer ejercitos = (int) Math.floor(Math.random() * 5 + 1);
            tirada.add(ejercitos);
        }
        return tirada;
    }

    public boolean atacar(Dados dadosDefensor,Integer numeroDeTiro){
        return (this.tirada.get(numeroDeTiro) > dadosDefensor.tirada.get(numeroDeTiro));
    }

    public Integer cantidadDeDados(){
        return tirada.size();
    }
}
