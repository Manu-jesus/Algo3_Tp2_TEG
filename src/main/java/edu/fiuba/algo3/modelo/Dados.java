package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.out;

public class Dados {
    //private boolean esAtacante;
    private ArrayList<Integer> tirada;
    private TipoDado tipoDado;

    public Dados(Integer cantidadEjercitos){
        this.tipoDado = new DadoDefensor();
        this.tirada = new ArrayList<>();
        this.tirada = this.tirarVeces(cantidadEjercitos);

    }

    public ArrayList<Integer> tirarVeces(Integer cantidadEjercitos){
        ArrayList<Integer> dados = new ArrayList<>();
        for (int i = 0; i < cantidadEjercitos && i < 3; i++) {
            Integer ejercitos = (int) Math.floor(Math.random() * 5 + 1);
            dados.add(ejercitos);
        }
        return dados;
    }

    public int comparar(Dados dados2){
        ArrayList<Integer> second = dados2.obtenerTiros();
        Collections.sort(this.tirada, Collections.reverseOrder());
        Collections.sort(second, Collections.reverseOrder());

        int ejercitosPerdidos = 0;
        int i = 0;
        while( (this.tirada.size() > i) && (second.size() > i) ){
            if(this.tipoDado.comparar(this.tirada.get(i), second.get(i))){
                ejercitosPerdidos += 1;
            }
            i++;
        }
        return ejercitosPerdidos;
    }

    private ArrayList<Integer> obtenerTiros(){
        return this.tirada;
    }

    public void sonAtacantes() {
        this.tipoDado = new DadoAtacante();
    }

}
