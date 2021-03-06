package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Continente {
    private ArrayList<Pais> paises;
    private String nombre;
    private Integer ejercitosExtra;

    public Continente(String nombre,Integer ejercitosExtra){
        this.ejercitosExtra = ejercitosExtra;
        this.nombre = nombre;
        paises = new ArrayList<>();
    }

    public Integer ejercitosExtra(){
        return ejercitosExtra;
    }

    public String nombre(){
        return this.nombre;
    }

    public void agregarPais(Pais pais){
        paises.add(pais);
    }

    public void conquistar(Jugador jugador){
        int i=0;
        boolean esConquistable = true;
        while(i<paises.size() && esConquistable){
            esConquistable = paises.get(i).lePerteneceA(jugador);
            i++;
        }
        if(esConquistable){
            jugador.agregarContinente(this);
        }
    }
}
