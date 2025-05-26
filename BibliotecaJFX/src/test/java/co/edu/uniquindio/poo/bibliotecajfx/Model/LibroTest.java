package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroTest {

    private Libro libro;

    @BeforeEach
    public void setUp() {
        libro = new Libro("Título de Ejemplo", "Autor Ejemplo", "Editorial Ejemplo", "Ficción", 2020, true, TipoLibro.FISICO);
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Título de Ejemplo", libro.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        libro.setTitulo("Nuevo Título");
        assertEquals("Nuevo Título", libro.getTitulo());
    }

    @Test
    public void testGetAutor() {
        assertEquals("Autor Ejemplo", libro.getAutor());
    }

    @Test
    public void testSetAutor() {
        libro.setAutor("Nuevo Autor");
        assertEquals("Nuevo Autor", libro.getAutor());
    }

    @Test
    public void testGetEditorial() {
        assertEquals("Editorial Ejemplo", libro.getEditorial());
    }

    @Test
    public void testSetEditorial() {
        libro.setEditorial("Nueva Editorial");
        assertEquals("Nueva Editorial", libro.getEditorial());
    }

    @Test
    public void testGetGenero() {
        assertEquals("Ficción", libro.getGenero());
    }

    @Test
    public void testSetGenero() {
        libro.setGenero("Drama");
        assertEquals("Drama", libro.getGenero());
    }

    @Test
    public void testGetAnio() {
        assertEquals(2020, libro.getAnio());
    }

    @Test
    public void testSetAnio() {
        libro.setAnio(2021);
        assertEquals(2021, libro.getAnio());
    }

    @Test
    public void testIsEstaDisponible() {
        assertTrue(libro.isEstaDisponible());
    }

    @Test
    public void testSetEstaDisponible() {
        libro.setEstaDisponible(false);
        assertFalse(libro.isEstaDisponible());
    }

    @Test
    public void testGetTipoLibro() {
        assertEquals(TipoLibro.FISICO, libro.getTipoLibro());
    }

    @Test
    public void testSetTipoLibro() {
        libro.setTipoLibro(TipoLibro.DIGITAL);
        assertEquals(TipoLibro.DIGITAL, libro.getTipoLibro());
    }

    @Test
    public void testToStringContieneTitulo() {
        assertTrue(libro.toString().contains("Título de Ejemplo"));
    }
}
