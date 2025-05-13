package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;


class FuncionVIPTest {
    private static final Logger LOG = Logger.getLogger(FuncionVIPTest.class.getName());

    @Test
    public void calcularPrecioTest(){
        LOG.info("Inicio de la prueba");
        Funcion funcion = new FuncionVIP("LosAvengers",207,"noche",150,true,false);
        assertEquals(5150,funcion.calcularPrecio());
        LOG.info("Fin de la prueba");
    }
}