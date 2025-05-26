package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VisitanteTest {

    @Test
    public void testGetNombreTemporal() {
        Visitante visitante = new Visitante("Invitado123");
        assertEquals("Invitado123", visitante.getNombreTemporal());
    }

    @Test
    public void testSetNombreTemporal() {
        Visitante visitante = new Visitante("InvitadoInicial");
        visitante.setNombreTemporal("NuevoNombre");
        assertEquals("NuevoNombre", visitante.getNombreTemporal());
    }

    @Test
    public void testToString() {
        Visitante visitante = new Visitante("TemporalABC");
        String resultado = visitante.toString();
        assertTrue(resultado.contains("TemporalABC"));
        assertTrue(resultado.contains("Visitante{"));
    }
}
