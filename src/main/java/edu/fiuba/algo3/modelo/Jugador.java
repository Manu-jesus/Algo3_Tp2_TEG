package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Pais> paises;
    private Dados dados;
    private ArrayList<TarjetaPais> tarjetasPais;
    private ArrayList<Continente> continentes;
    private tarjetaObjetivo objetivo;
    private Turno turno;
    private String color;
    private NumeroDeCanje numeroDeCanjes;

    public Jugador(Dados dados, Turno turno, String color){
        this.numeroDeCanjes = new PrimerCanje();
        this.paises = new ArrayList<>();
        this.dados = dados;
        this.tarjetasPais = new ArrayList<>();
        this.continentes = new ArrayList<>();
        this.turno = turno;
        turno.agregarJugador(this);
        this.color = color;
    }

    public ArrayList <Continente> continentes(){
        return continentes;
    }

    public ArrayList<TarjetaPais> tarjetaPais(){
        return this.tarjetasPais;
    }

    public void hacerCanje(){
        if(this.tarjetasPais.size() != 3){
            throw new JugadorNoPuedeHacerCanje();
        }
        for (int i=0;i<3;i++){
            this.tarjetasPais.remove(this.tarjetasPais.get(0));
        }
        this.turno.hacerCanje(numeroDeCanjes);
        numeroDeCanjes.hacerCanje();
    }

    public String obtenerNombreObjetivo(){
        return objetivo.obtenerTitulo();
    }

    public String color(){
        return this.color;
    }


    public void agregarEjercitosA(Pais pais, Integer cantidadEjercitos){
        if (!this.estaPais(pais)){
            return; }
        turno.colocarEjercitos(cantidadEjercitos);
        pais.agregarEjercitos(cantidadEjercitos);
    }

    public void agregarTarjetaPais(TarjetaPais tarjeta){
        this.tarjetasPais.add(tarjeta);
    }

    public void agregarContinente(Continente continente){
        this.continentes.add(continente);
    }

    public void activarTarjetasPais(){
        for(int i=0;i<this.tarjetasPais.size();i++){
            this.activarTarjetaPais(this.tarjetasPais.get(i));
        }
    }

    public void activarTarjetaPais(TarjetaPais tarjeta){
        if(!this.estaPais(tarjeta.pais())){
            return;
        }
        tarjeta.activar();
    }

    public void atacarAPais(Pais atacante, Pais defensor, Integer cantidadEjercitos){
        if (!this.turno.puedoAtacar()){
            throw new ElTurnoYaNoTePermiteAtacarError();
        }
        if (!this.estaPais(atacante)){
            throw new ElPaisAtacanteNoTePerteneceError();
        }
        if (this.estaPais(defensor)){
            throw new NoPuedesAtacarAUnPaisPropioError();
        }
        atacante.prepararParaLaBatalla(defensor, cantidadEjercitos);
        Jugador contrincante=defensor.conseguirContrincante();
        this.entrarEnGuerra(contrincante,atacante,defensor);
        this.turno.actualizarEjercitosAColocar();
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
        if(defensor.conquistarPais(this,atacante)){
            this.turno.conquisto();
        }
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
        if ((!this.paises.contains(paisEmisor)) || (!this.paises.contains(paisReceptor))){
            throw new ElPaisAtacanteNoTePerteneceError();
        }
        if (!paisEmisor.esPaisLimitrofe(paisReceptor)){
            throw new LosPaisesNoSonLimitrofesError();
        }
        if (paisEmisor.ejercitos()<=cantidadEjercitos){
            throw new NoEsPosibleRestarEsaCantidadDeEjercitosError();
        }

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

    public void asignarObjetivo(tarjetaObjetivo objetivo){this.objetivo = objetivo;}

}
