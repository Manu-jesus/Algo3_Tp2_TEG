package edu.fiuba.algo3.modelo;

public class DadoAtacante implements TipoDado {
    @Override
    public boolean comparar(Integer atacante,Integer defensor){
        return atacante<=defensor;
    }
}
