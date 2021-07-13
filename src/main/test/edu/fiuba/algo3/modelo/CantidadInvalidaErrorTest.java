package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CantidadInvalidaErrorTest {

    @Test
    public void restarEjercitosQuedandoEnNegativoLanzaCantidadInvalidaError(){
        Pais rusia = new Pais("Rsia", 7);
        assertThrows(CantidadInvalidaError.class,
                () -> {
                    rusia.restarEjercitos(10);
                });
    }

}
