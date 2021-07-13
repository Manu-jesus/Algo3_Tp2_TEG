package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.lang.String;

public class Pais{
    private final String nombre;
    private Integer ejercitos;
    private final ArrayList<Pais> paisesLimitrofes;
    private Jugador duenio;

    public Pais(String nombre, Integer cantEjercitos){
        this.nombre = nombre;
        this.ejercitos = cantEjercitos;
        this.paisesLimitrofes = new ArrayList<>();
    }

    public void asignarDuenio(Jugador duenio) {
        this.duenio = duenio;
    }

    public boolean compararNombre(String nombre){
        return (this.nombre.equals(nombre));
    }

    public void agregarPaisLimitrofes(Pais p){
        this.paisesLimitrofes.add(p);
    }

    public void atacarA(Pais defensor, Integer cantidadEjercitos){

        if (this.ejercitos < cantidadEjercitos) {
            return; //Error
        }

        if (!this.esPaisLimitrofe(defensor)){
            return; //Error
        }

        Dados dadosAtacante = new Dados(cantidadEjercitos);
        dadosAtacante.sonAtacantes();

        Dados dadosDefensor = defensor.defenderseDe(dadosAtacante);
        Integer ejercitosPerdidos = dadosAtacante.comparar(dadosDefensor);
        this.restarEjercitos(ejercitosPerdidos);
    }

    private boolean esPaisLimitrofe(Pais p){
        return paisesLimitrofes.contains(p);
    }

    public Dados defenderseDe(Dados dadosAtacante){
        Dados dadosDefensor = new Dados(this.ejercitos);

        Integer ejercitosPerdidos = dadosDefensor.comparar(dadosAtacante);
        this.restarEjercitos(ejercitosPerdidos);
        return dadosDefensor;
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
