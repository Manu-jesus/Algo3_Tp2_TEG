package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Pais> paises;
    private Dados dados;
    private ArrayList<TarjetaPais> tarjetasPais;
    private ArrayList<Continente> continentes;
    private tarjetaObjetivo objetivo;

    public Jugador(Dados dados, tarjetaObjetivo objetivo){
        this.paises = new ArrayList<>();
        this.dados = dados;
        this.tarjetasPais = new ArrayList<>();
        this.continentes = new ArrayList<>();
        this.objetivo = objetivo;
    }

    public void agregarEjercitosA(Pais pais, Integer cantidadEjercitos){
        if (!this.estaPais(pais)){ return; }
        pais.agregarEjercitos(cantidadEjercitos);
    }

    public void agregarTarjetaPais(TarjetaPais tarjeta){
        this.tarjetasPais.add(tarjeta);
    }

    public void agregarContinente(Continente continente){
        this.continentes.add(continente);
    }

    public void activarTarjetaPais(TarjetaPais tarjeta){
        if(!this.tarjetasPais.contains(tarjeta)){
            throw new LaTarjetaPaisNoSeEncontroError();
        }
        tarjeta.activar();
    }

    public void atacarAPais(Pais atacante, Pais defensor, Integer cantidadEjercitos){
        if (!this.estaPais(atacante)){
            throw new ElPaisAtacanteNoTePerteneceError();
        }
        if (this.estaPais(defensor)){
            throw new NoPuedesAtacarAUnPaisPropioError();
        }
        atacante.prepararParaLaBatalla(defensor, cantidadEjercitos);
        Jugador contrincante=defensor.conseguirContrincante();
        this.entrarEnGuerra(contrincante,atacante,defensor);
    }

    public void tirar(Integer cantidadEjercitos){
        this.dados.tirar(cantidadEjercitos);
    }

    private void entrarEnGuerra(Jugador contrincante, Pais atacante, Pais defensor){
        Integer numeroDeBatalla=0;
        while(this.dados.cantidadDeDados()>numeroDeBatalla && contrincante.dados.cantidadDeDados()>numeroDeBatalla){
            this.batallar(contrincante,atacante,defensor,numeroDeBatalla);
            numeroDeBatalla++;
        }
        defensor.conquistarPais(this,atacante);
    }

    private void batallar(Jugador contrincante, Pais atacante, Pais defensor, Integer numeroDeBatalla){
        if(this.dados.comparar(contrincante.dados,numeroDeBatalla)){
            defensor.restarEjercitos(1);
        }
        else{
            atacante.restarEjercitos(1);
        }
    }

    private boolean estaPais(Pais pais){
        return this.paises.contains(pais);
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

    public void perderContinente(Continente continente){
        continentes.remove(continente);
    }

    public void conquistarContinente(Continente continente){
        continente.conquistar(this);
    }

    public boolean tieneContinente(Continente continente){
        return this.continentes.contains(continente);
    }

    public Integer cantidadPaises(){
        return this.paises.size();
    }

    public boolean seCumplioObjetivo(){
        return this.objetivo.seCumplio(this);
    }
}
