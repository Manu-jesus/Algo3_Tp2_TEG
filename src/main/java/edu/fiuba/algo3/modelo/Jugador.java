package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Pais> paises;

    public Jugador() {
        paises = new ArrayList<>();
    }

    public void atacarDeA(Pais atacante, Pais defensor, Integer cantidadEjercitos){
        if (this.estaPais(defensor)){ return; }
        if (!this.estaPais(atacante)){ return; }
        atacante.atacarA(defensor, cantidadEjercitos);
    }

    private boolean estaPais(Pais p){
        return this.paises.contains(p);
    }


    public void conquistarPais(Pais paisAtacante, Pais paisDefensor, Integer cantidadEjercitos) {
        if (this.estaPais(paisDefensor)){ return; }
        if (!this.estaPais(paisAtacante)){ return; }
        this.moverEjercitos(paisAtacante, paisDefensor, cantidadEjercitos);
        this.agregarPais(paisDefensor);
    }

    public void moverEjercitos(Pais paisEmisor, Pais paisReceptor, Integer cantidadEjercitos) {
        paisEmisor.restarEjercitos(cantidadEjercitos);
        paisReceptor.sumarEjercitos(cantidadEjercitos);
    }

    public void agregarPais(Pais pais) {
        pais.asignarDuenio(this);
        this.paises.add(pais);
    }

    public void perderPais(Pais pais) {
        this.paises.remove(pais);
    }

}
