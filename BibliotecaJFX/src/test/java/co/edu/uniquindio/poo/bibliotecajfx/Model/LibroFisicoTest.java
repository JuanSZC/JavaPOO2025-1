package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroFisicoTest {

    private LibroFisico libroFisico;

    @BeforeEach
    public void setUp() {
        libroFisico = new LibroFisico(
                "Título Físico",
                "Autor Físico",
                "Editorial F",
                "Novela",
                2022,
                true
        );
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Título Físico", libroFisico.getTitulo());
    }

    @Test
    public void testGetAutor() {
        assertEquals("Autor Físico", libroFisico.getAutor());
    }

    @Test
    public void testGetEditorial() {
        assertEquals("Editorial F", libroFisico.getEditorial());
    }

    @Test
    public void testGetGenero() {
        assertEquals("Novela", libroFisico.getGenero());
    }

    @Test
    public void testGetAnio() {
        assertEquals(2022, libroFisico.getAnio());
    }

    @Test
    public void testIsDisponible() {
        assertTrue(libroFisico.isEstaDisponible());
    }

    @Test
    public void testTipoLibroEsFisico() {
        assertEquals(TipoLibro.FISICO, libroFisico.getTipoLibro());
    }

    @Test
    public void testToStringContieneTitulo() {
        assertTrue(libroFisico.toString().contains("Título Físico"));
    }
}
