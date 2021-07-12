package edu.fiuba.algo3.modelo;

public class DadoDefensor implements TipoDado{
    @Override
    public boolean comparar(Integer defensor,Integer atacante){
        return defensor<atacante;
    }
}
