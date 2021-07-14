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
        if(atacante.ejercitos!=0){
            return; //error
        }
        this.restarEjercitos(1);
        atacante.sumarEjercitos(1);
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
        if (this.ejercitos == 0) {
            this.duenio.perderPais(this);
        }
    }

    public void sumarEjercitos(Integer cantidadEjercitos) {
        this.ejercitos += cantidadEjercitos;
    }

    public void agregarEjercitos(Jugador jugador, Integer cantidadEjercitos) {
        if (this.duenio != jugador) {
            return; //Error
        }
        this.sumarEjercitos(cantidadEjercitos);
    }
}
