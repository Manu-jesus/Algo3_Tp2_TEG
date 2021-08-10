package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Turno {
    private NumeroDeRonda ronda;
    private ArrayList<Jugador> jugadores;
    private Integer numeroDeTurno;
    private Integer ejercitosAColocar;

    public Turno(){
        this.ronda = new PrimeraRonda();
        this.jugadores = new ArrayList<>();
        this.numeroDeTurno = 0;
        this.ejercitosAColocar = 5;
    }

    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public void pasarTurno(){
        this.numeroDeTurno++;
        if(numeroDeTurno==this.jugadores.size()){
            this.numeroDeTurno=0;
            this.ronda = this.ronda.pasarRonda();
        }
        this.actualizarEjercitosAColocar();
    }

    public Jugador jugadorActual(){
        return this.jugadores.get(numeroDeTurno);
    }

    public boolean puedoAtacar(){
        return (this.ronda.ejercitosAColocar(this.jugadores.get(numeroDeTurno))== this.ejercitosAColocar);
    }

    public void actualizarEjercitosAColocar(){
        this.ejercitosAColocar = this.ronda.ejercitosAColocar(this.jugadores.get(numeroDeTurno));
    }

    public void colocarEjercitos(Integer cantidadEjercitos){
        if(cantidadEjercitos>this.ejercitosAColocar){
            throw new ElJugadorNoTieneSuficientesEjercitosError();
        }
        this.ejercitosAColocar -= cantidadEjercitos;
    }
}