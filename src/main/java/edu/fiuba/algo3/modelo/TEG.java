package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.lang.String;

public class TEG {
    private final ArrayList<Pais> paises;

    public TEG() {
        paises = new ArrayList<>();
        Pais Arg = new Pais("Argentina", 3);
        Pais Bra = new Pais("Brasil", 1);
        Bra.agregarPaisLimitrofes(Arg);
        Arg.agregarPaisLimitrofes(Bra);
        paises.add(Arg);
        paises.add(Bra);
    }

    public void atacarConA(Jugador atacante, String ataque, String defensa, int cantEjercitos){
        if (cantEjercitos > 3 || cantEjercitos < 1) {
            return; //Error
        }
        Pais paisAtacante = this.buscarPais(ataque);
        Pais paisDefensor = this.buscarPais(defensa);
        Integer cantidadEjercitos = cantEjercitos;
        atacante.atacarDeA(paisAtacante, paisDefensor, cantidadEjercitos);
    }


    public Pais buscarPais(String nombrePais){
        for (int i = 0; i < this.paises.size(); i++) {
            if (this.paises.get(i).compararNombre(nombrePais)){
                return this.paises.get(i);
            }
        }
        return this.paises.get(0);
    }

    public void conquistar(Jugador jugador, String atacante, String defensor, Integer cantidadEjercitos) {
        Pais paisAtacante = this.buscarPais(atacante);
        Pais paisDefensor = this.buscarPais(defensor);

        if (paisDefensor.ejercitos() != 0) {
            return; //error no es conquistable
        }

        if (paisAtacante.ejercitos() - 1 < cantidadEjercitos) {
            return; // error
        }

        paisDefensor.asignarDuenio(jugador);
        jugador.conquistarPais(paisAtacante, paisDefensor, cantidadEjercitos);
    }

    public void colocarEjercitos(Jugador jugador, String pais, Integer cantidadEjercitos) {
        Pais paisConEjercitos = this.buscarPais(pais);
        paisConEjercitos.agregarEjercitos(jugador, cantidadEjercitos);

    }

}
