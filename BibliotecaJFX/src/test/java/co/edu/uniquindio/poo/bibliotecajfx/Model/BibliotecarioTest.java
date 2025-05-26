package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BibliotecarioTest {

    private Biblioteca biblioteca;
    private Bibliotecario bibliotecario;

    @BeforeEach
    public void setUp() {
        biblioteca = new Biblioteca("ABC",123,"Calle");
        bibliotecario = new Bibliotecario("Ana Pérez", "12345", "clave123", biblioteca);
    }

    @Test
    public void testRegistrarLibroFisico() {
        LibroFisico libro = new LibroFisico("1984", "George Orwell", "Secker", "Distopía", 1949, true);
        bibliotecario.registrarLibroFisico(libro);

        assertTrue(biblioteca.getListLibros().contains(libro));
    }

    @Test
    public void testRegistrarEstudiante() {
        Estudiante estudiante = new Estudiante("Carlos Gómez", "54321", "carlos@mail.com","pass123", biblioteca);
        bibliotecario.registrarEstudiante(estudiante);

        assertTrue(biblioteca.getListUsuarios().contains(estudiante));
    }

    @Test
    public void testPrestarYDevolverLibro() {
        LibroFisico libro = new LibroFisico("El Principito", "Antoine de Saint-Exupéry", "Salamandra", "Ficción", 1943, true);
        Estudiante estudiante = new Estudiante("Laura Torres", "11111", "laura@mail.com", "1234",biblioteca);

        bibliotecario.registrarLibroFisico(libro);
        bibliotecario.registrarEstudiante(estudiante);
        bibliotecario.prestarLibro(libro, estudiante, 7);

        assertFalse(libro.isEstaDisponible());
        assertEquals(1, biblioteca.getListReservas().size());

        Reserva reserva = biblioteca.getListReservas().get(0);
        bibliotecario.devolverLibro(reserva);

        assertTrue(libro.isEstaDisponible());
        assertTrue(biblioteca.getListReservas().isEmpty());
    }

    @Test
    public void testGenerarInforme() {
        String informe = bibliotecario.generarInforme();
        assertTrue(informe.contains("Cantidad de Libros"));
        assertTrue(informe.contains("Cantidad de Usuarios"));
        assertTrue(informe.contains("Cantidad de Reservas"));
    }
}
