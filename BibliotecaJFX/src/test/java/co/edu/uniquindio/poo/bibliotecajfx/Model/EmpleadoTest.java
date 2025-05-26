package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpleadoTest {

    private Empleado empleado;
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca Central", 101, "Avenida Principal");
        empleado = new Empleado("Carlos Pérez", "987654321", "clave123", TipoTrabajo.ADMINISTRADOR, biblioteca);
    }

    @Test
    public void testGetNombreCompleto() {
        assertEquals("Carlos Pérez", empleado.getNombreCompleto());
    }

    @Test
    public void testSetNombreCompleto() {
        empleado.setNombreCompleto("Ana Gómez");
        assertEquals("Ana Gómez", empleado.getNombreCompleto());
    }

    @Test
    public void testGetCedula() {
        assertEquals("987654321", empleado.getCedula());
    }

    @Test
    public void testSetCedula() {
        empleado.setCedula("123456789");
        assertEquals("123456789", empleado.getCedula());
    }

    @Test
    public void testGetContrasenia() {
        assertEquals("clave123", empleado.getContrasenia());
    }

    @Test
    public void testSetContrasenia() {
        empleado.setContrasenia("nuevaClave");
        assertEquals("nuevaClave", empleado.getContrasenia());
    }

    @Test
    public void testGetTipoTrabajo() {
        assertEquals(TipoTrabajo.ADMINISTRADOR, empleado.getTipoTrabajo());
    }

    @Test
    public void testSetTipoTrabajo() {
        empleado.setTipoTrabajo(TipoTrabajo.BIBLIOTECARIO);
        assertEquals(TipoTrabajo.BIBLIOTECARIO, empleado.getTipoTrabajo());
    }

    @Test
    public void testGetBiblioteca() {
        assertEquals(biblioteca, empleado.getBiblioteca());
    }

    @Test
    public void testSetBiblioteca() {
        Biblioteca nuevaBiblioteca = new Biblioteca("Nueva Biblioteca", 202, "Calle Secundaria");
        empleado.setBiblioteca(nuevaBiblioteca);
        assertEquals(nuevaBiblioteca, empleado.getBiblioteca());
    }

    @Test
    public void testToStringContieneNombre() {
        assertTrue(empleado.toString().contains("Carlos Pérez"));
    }
}
