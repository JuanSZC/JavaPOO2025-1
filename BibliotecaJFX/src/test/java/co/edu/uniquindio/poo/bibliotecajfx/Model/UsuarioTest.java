package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    private Usuario usuario;
    private Biblioteca biblioteca;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca Central",123,"Calle Principal");
        usuario = new Usuario(
                "Juan Pérez",
                "123456789",
                "juan.perez@correo.com",
                "segura123",
                TipoUsuario.ESTUDIANTE,
                10,
                5,
                biblioteca
        );
    }

    @Test
    public void testGetNombreCompleto() {
        assertEquals("Juan Pérez", usuario.getNombreCompleto());
    }

    @Test
    public void testSetNombreCompleto() {
        usuario.setNombreCompleto("Ana Gómez");
        assertEquals("Ana Gómez", usuario.getNombreCompleto());
    }

    @Test
    public void testGetCedula() {
        assertEquals("123456789", usuario.getCedula());
    }

    @Test
    public void testSetCedula() {
        usuario.setCedula("987654321");
        assertEquals("987654321", usuario.getCedula());
    }

    @Test
    public void testGetCorreo() {
        assertEquals("juan.perez@correo.com", usuario.getCorreo());
    }

    @Test
    public void testSetCorreo() {
        usuario.setCorreo("nuevo@correo.com");
        assertEquals("nuevo@correo.com", usuario.getCorreo());
    }

    @Test
    public void testGetContrasenia() {
        assertEquals("segura123", usuario.getContrasenia());
    }

    @Test
    public void testSetContrasenia() {
        usuario.setContrasenia("nuevaClave");
        assertEquals("nuevaClave", usuario.getContrasenia());
    }

    @Test
    public void testGetTipoUsuario() {
        assertEquals(TipoUsuario.ESTUDIANTE, usuario.getTipoUsuario());
    }

    @Test
    public void testSetTipoUsuario() {
        usuario.setTipoUsuario(TipoUsuario.DOCENTE);
        assertEquals(TipoUsuario.DOCENTE, usuario.getTipoUsuario());
    }

    @Test
    public void testGetMaxDias() {
        assertEquals(10, usuario.getMaxDias());
    }

    @Test
    public void testSetMaxDias() {
        usuario.setMaxDias(15);
        assertEquals(15, usuario.getMaxDias());
    }

    @Test
    public void testGetMaxReservas() {
        assertEquals(5, usuario.getMaxReservas());
    }

    @Test
    public void testSetMaxReservas() {
        usuario.setMaxReservas(3);
        assertEquals(3, usuario.getMaxReservas());
    }

    @Test
    public void testSolicitarPrestamoLibro() {
        LibroFisico libro = new LibroFisico("Java Avanzado", "Autor X", "Editorial X", "Programación", 2020, true);
        usuario.solicitarPrestamoLibro(libro, 7);
        assertEquals(1, usuario.getListReservasUsuario().size());
        assertEquals(1, biblioteca.getListReservas().size());
    }
}
