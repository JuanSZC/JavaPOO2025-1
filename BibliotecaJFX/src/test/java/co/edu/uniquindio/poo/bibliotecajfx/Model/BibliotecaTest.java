package co.edu.uniquindio.poo.bibliotecajfx.Model;

import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    private Biblioteca biblioteca;
    private Empleado empleado;
    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("Biblioteca", 123, "Calle ABC");
        biblioteca.setListEmpleados(new ArrayList<>());
        biblioteca.setListUsuarios(new ArrayList<>());
        biblioteca.setListLibros(new ArrayList<>());
        biblioteca.setListVisitantes(new ArrayList<>());
        biblioteca.setListReservas(new ArrayList<>());

        empleado = new Empleado("Empleado Test", "123", "pass", TipoTrabajo.BIBLIOTECARIO, biblioteca);
        usuario = new Usuario("Usuario Test", "456", "pass", "clave", TipoUsuario.ESTUDIANTE, 5, 5, biblioteca);
    }

    @Test
    public void testGetNombre() {
        assertEquals("Biblioteca", biblioteca.getNombre());
    }

    @Test
    public void testGetNit() {
        assertEquals(123, biblioteca.getNit());
    }

    @Test
    public void testGetDireccion() {
        assertEquals("Calle ABC", biblioteca.getDireccion());
    }

    @Test
    public void testSetNombre() {
        biblioteca.setNombre("Nueva Biblioteca");
        assertEquals("Nueva Biblioteca", biblioteca.getNombre());
    }

    @Test
    public void testSetNit() {
        biblioteca.setNit(999);
        assertEquals(999, biblioteca.getNit());
    }

    @Test
    public void testSetDireccion() {
        biblioteca.setDireccion("Nueva Calle");
        assertEquals("Nueva Calle", biblioteca.getDireccion());
    }

    @Test
    public void testListEmpleadosInicialmenteVacia() {
        assertTrue(biblioteca.getListEmpleados().isEmpty());
    }

    @Test
    public void testAgregarEmpleado() {
        biblioteca.getListEmpleados().add(empleado);
        assertTrue(biblioteca.getListEmpleados().contains(empleado));
    }

    @Test
    public void testListUsuariosInicialmenteVacia() {
        assertTrue(biblioteca.getListUsuarios().isEmpty());
    }

    @Test
    public void testAgregarUsuario() {
        biblioteca.getListUsuarios().add(usuario);
        assertTrue(biblioteca.getListUsuarios().contains(usuario));
    }

    @Test
    public void testListLibrosVacia() {
        assertTrue(biblioteca.getListLibros().isEmpty());
    }

    @Test
    public void testListVisitantesVacia() {
        assertTrue(biblioteca.getListVisitantes().isEmpty());
    }

    @Test
    public void testListReservasVacia() {
        assertTrue(biblioteca.getListReservas().isEmpty());
    }

    @Test
    public void testToStringContieneNombre() {
        assertTrue(biblioteca.toString().contains("Biblioteca"));
    }
}
