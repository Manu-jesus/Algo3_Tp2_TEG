package edu.fiuba.algo3.modelo;

public class tarjetaObjetivo {
    Continente continente;

    public tarjetaObjetivo(Continente continente){
        this.continente = continente;
    }

    public boolean seCumplio(Jugador jugador){
        return (jugador.tieneContinente(this.continente) || jugador.cantidadPaises()==30 );
    }

    public String obtenerTitulo(){
        String linea = "Se debe conquistar: "+continente.nombre();
        return linea;
    }
}
