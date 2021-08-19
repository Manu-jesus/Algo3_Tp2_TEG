package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Random;

public class Turno {
    private NumeroDeRonda ronda;
    private ArrayList<Jugador> jugadores;
    private ArrayList<TarjetaPais> tarjetasPais;
    private Integer numeroDeTurno;
    private Integer ejercitosAColocar;
    private boolean conquistoEnTurno;

    public Turno(ArrayList<Pais> paises){
        this.tarjetasPais = new ArrayList<>();
        this.crearTarjetasPais(paises);
        this.ronda = new PrimeraRonda();
        this.jugadores = new ArrayList<>();
        this.numeroDeTurno = 0;
        this.ejercitosAColocar = 5;
        this.conquistoEnTurno = false;

    }

    public Integer ejercitosAColocar(){
        return this.ejercitosAColocar;
    }

    public void hacerCanje(NumeroDeCanje numeroDeCanje){
        ejercitosAColocar += numeroDeCanje.cantidadEjercitosAColocar();
    }

    public void conquisto(){
        this.conquistoEnTurno = true;
    }

    public void crearTarjetasPais(ArrayList<Pais> paises){

        for (int i=0;i<paises.size();i++){
            TarjetaPais nueva_tarjetaPais = new TarjetaPais(paises.get(i));
            this.tarjetasPais.add(nueva_tarjetaPais);
        }
    }

    public void agregarJugador(Jugador jugador){
        this.jugadores.add(jugador);
    }

    public void pasarTurno(){
        if(this.conquistoEnTurno){
            this.jugadorActual().agregarTarjetaPais(this.tarjetasPais.get(0));
            this.tarjetasPais.remove(this.tarjetasPais.get(0));
        }
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
        if(!this.ronda.sePuedeAtacar()){
            return false;
        }
        return (this.ronda.ejercitosAColocar(this.jugadores.get(numeroDeTurno))<= this.ejercitosAColocar);
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

