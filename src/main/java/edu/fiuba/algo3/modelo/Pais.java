package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais{
    private Integer ejercitos;
    private final ArrayList<Pais> paisesLimitrofes;
    private Jugador duenio;
    private Continente continente;

    public Pais(Integer cantEjercitos, Continente continente){
        this.ejercitos = cantEjercitos;
        this.paisesLimitrofes = new ArrayList<>();
        this.continente = continente;
        continente.agregarPais(this);
        //this.duenio = duenio;
        this.duenio.agregarPais(this);
        //this.duenio.conquistarContinente(continente);
    }

    public void asignarDuenio(Jugador duenio){
        this.duenio = duenio;
    }

    public String colorPorDuenio(){
        return duenio.color();
    }

    public boolean lePerteneceA(Jugador jugador){
        return this.duenio==jugador;
    }


    public void agregarPaisLimitrofe(Pais p){
        if (paisesLimitrofes.contains(p)){return;}
        p.paisesLimitrofes.add(this);
        this.paisesLimitrofes.add(p);
    }

    public void prepararParaLaBatalla(Pais defensor, Integer cantidadEjercitos){

        if(this.ejercitos-1<cantidadEjercitos){
            throw new ElPaisAtacanteSiempreDebeMantenerUnEjercitoEnElPaisError();
        }
        if(!this.esPaisLimitrofe(defensor)){
            throw new LosPaisesNoSonLimitrofesError();
        }

        this.duenio.tirar(cantidadEjercitos);
    }

    public Jugador conseguirContrincante(){
        this.duenio.tirar(ejercitos);
        return this.duenio;
    }

    public void conquistarPais(Jugador jugador,Pais atacante){
        if(this.ejercitos!=0){
            return;//No es un error porque se compara muchas veces
        }
        this.sumarEjercitos(1);
        atacante.restarEjercitos(1);
        this.duenio.perderContinente(this.continente);
        this.duenio.perderPais(this);
        this.duenio=jugador;
        this.duenio.agregarPais(this);
        this.duenio.conquistarContinente(this.continente);
    }

    public boolean esPaisLimitrofe(Pais p){
        return paisesLimitrofes.contains(p);
    }


    public Integer ejercitos() {
        return this.ejercitos;
    }

    public void restarEjercitos(Integer cantidadEjercitos) {
        if (this.ejercitos() < cantidadEjercitos) {
            throw new NoEsPosibleRestarEsaCantidadDeEjercitosError();
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
