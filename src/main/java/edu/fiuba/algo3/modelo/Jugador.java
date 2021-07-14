package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Pais> paises;
    private Dados dados;

    public Jugador(Dados dados){
        paises = new ArrayList<>();
        this.dados = dados;
    }

    public void atacarAPais(Pais atacante, Pais defensor, Integer cantidadEjercitos){
        if (this.estaPais(defensor)){ return; }
        if (!this.estaPais(atacante)){ return; }
        atacante.prepararParaLaBatalla(defensor, cantidadEjercitos);
        Jugador contrincante=defensor.conseguirContrincante();
        this.entrarEnGuerraCon(contrincante,atacante,defensor);
    }

    public void tirar(Integer cantidadEjercitos){
        this.dados.tirar(cantidadEjercitos);
    }

    private void entrarEnGuerraCon(Jugador contrincante, Pais atacante, Pais defensor){
        Integer numeroDeBatalla=0;
        while(this.dados.cantidadDeDados()>numeroDeBatalla && contrincante.dados.cantidadDeDados()>numeroDeBatalla){
            this.batallar(contrincante,atacante,defensor,numeroDeBatalla);
            numeroDeBatalla++;
        }
        defensor.conquistar(this,atacante);
    }

    private void batallar(Jugador contrincante, Pais atacante, Pais defensor, Integer numeroDeBatalla){
        if(this.dados.atacar(contrincante.dados,numeroDeBatalla)){
            defensor.restarEjercitos(1);
        }
        else{
            atacante.restarEjercitos(1);
        }
    }

    private boolean estaPais(Pais p){
        return this.paises.contains(p);
    }

    public void moverEjercitos(Pais paisEmisor, Pais paisReceptor, Integer cantidadEjercitos) {
        paisEmisor.restarEjercitos(cantidadEjercitos);
        paisReceptor.sumarEjercitos(cantidadEjercitos);
    }

    public void agregarPais(Pais pais) {
        this.paises.add(pais);
    }

    public void perderPais(Pais pais) {
        this.paises.remove(pais);
    }

}
