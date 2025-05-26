package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DocenteTest {

    private Docente docente;
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca", 123, "Calle ABC");
        docente = new Docente("Nombre Docente", "123456789", "correo@ejemplo.com", "password123", biblioteca);
    }

    @Test
    public void testGetNombreCompleto() {
        assertEquals("Nombre Docente", docente.getNombreCompleto());
    }

    @Test
    public void testGetCedula() {
        assertEquals("123456789", docente.getCedula());
    }

    @Test
    public void testGetCorreo() {
        assertEquals("correo@ejemplo.com", docente.getCorreo());
    }

    @Test
    public void testGetContrasenia() {
        assertEquals("password123", docente.getContrasenia());
    }

    @Test
    public void testGetTipoUsuario() {
        assertEquals(TipoUsuario.DOCENTE, docente.getTipoUsuario());
    }

    @Test
    public void testGetMaxDias() {
        assertEquals(15, docente.getMaxDias());
    }

    @Test
    public void testGetMaxLibros() {
        assertEquals(30, docente.getMaxReservas());
    }

    @Test
    public void testGetBiblioteca() {
        assertEquals(biblioteca, docente.getBiblioteca());
    }
}
