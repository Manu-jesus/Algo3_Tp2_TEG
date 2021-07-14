package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais{
    private Integer ejercitos;
    private final ArrayList<Pais> paisesLimitrofes;
    private Jugador duenio;

    public Pais(Integer cantEjercitos,Jugador duenio){
        this.ejercitos = cantEjercitos;
        this.paisesLimitrofes = new ArrayList<>();
        this.duenio=duenio;
        duenio.agregarPais(this);
    }



    public void agregarPaisLimitrofes(Pais p){
        this.paisesLimitrofes.add(p);
    }

    public void prepararParaLaBatalla(Pais defensor, Integer cantidadEjercitos){

        if(this.ejercitos-1<cantidadEjercitos){
            return; //error
        }
        if(!this.esPaisLimitrofe(defensor)){
            return; //error
        }

        this.duenio.tirar(cantidadEjercitos);
    }

    public Jugador conseguirContrincante(){
        this.duenio.tirar(ejercitos);
        return this.duenio;
    }

    public void conquistar(Jugador jugador,Pais atacante){
        if(this.ejercitos!=0){
            return; //error
        }
        this.sumarEjercitos(1);
        atacante.restarEjercitos(1);
        this.duenio.perderPais(this);
        this.duenio=jugador;
    }

    private boolean esPaisLimitrofe(Pais p){
        return paisesLimitrofes.contains(p);
    }


    public Integer ejercitos() {
        return this.ejercitos;
    }

    public void restarEjercitos(Integer cantidadEjercitos) {
        if (this.ejercitos() < cantidadEjercitos) {
            return; //error
        }
        this.ejercitos -= cantidadEjercitos;
    }

    public void sumarEjercitos(Integer cantidadEjercitos) {
        this.ejercitos += cantidadEjercitos;
    }

    public void agregarEjercitos( Integer cantidadEjercitos) {
        this.sumarEjercitos(cantidadEjercitos);
    }
}
