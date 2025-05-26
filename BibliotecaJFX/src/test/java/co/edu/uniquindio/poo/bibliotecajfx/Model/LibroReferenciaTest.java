package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroReferenciaTest {

    private LibroReferencia libroReferencia;

    @BeforeEach
    public void setUp() {
        libroReferencia = new LibroReferencia(
                "Enciclopedia de Ciencias",
                "Dr. Sabio",
                "Editorial Académica",
                "Ciencia",
                2015
        );
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Enciclopedia de Ciencias", libroReferencia.getTitulo());
    }

    @Test
    public void testGetAutor() {
        assertEquals("Dr. Sabio", libroReferencia.getAutor());
    }

    @Test
    public void testGetEditorial() {
        assertEquals("Editorial Académica", libroReferencia.getEditorial());
    }

    @Test
    public void testGetGenero() {
        assertEquals("Ciencia", libroReferencia.getGenero());
    }

    @Test
    public void testGetAnio() {
        assertEquals(2015, libroReferencia.getAnio());
    }

    @Test
    public void testIsDisponibleSiempreTrue() {
        assertTrue(libroReferencia.isEstaDisponible());
    }

    @Test
    public void testGetTipoLibroReferencia() {
        assertEquals(TipoLibro.REFERENCIA, libroReferencia.getTipoLibro());
    }

    @Test
    public void testToStringContieneTituloYTipo() {
        String resultado = libroReferencia.toString();
        assertTrue(resultado.contains("Enciclopedia de Ciencias"));
        assertTrue(resultado.contains("REFERENCIA"));
    }
}
