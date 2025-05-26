package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LibroDigitalTest {

    private LibroDigital libroDigital;

    @BeforeEach
    public void setUp() {
        libroDigital = new LibroDigital(
                "Título Digital",
                "Autor Digital",
                "Editorial Digital",
                "Tecnología",
                2023,
                FormatoDigital.PDF,
                "https://ejemplo.com/libro.pdf",
                true
        );
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Título Digital", libroDigital.getTitulo());
    }

    @Test
    public void testSetTitulo() {
        libroDigital.setTitulo("Nuevo Título");
        assertEquals("Nuevo Título", libroDigital.getTitulo());
    }

    @Test
    public void testGetAutor() {
        assertEquals("Autor Digital", libroDigital.getAutor());
    }

    @Test
    public void testSetAutor() {
        libroDigital.setAutor("Nuevo Autor");
        assertEquals("Nuevo Autor", libroDigital.getAutor());
    }

    @Test
    public void testGetFormatoDigital() {
        assertEquals(FormatoDigital.PDF, libroDigital.getFormatoDigital());
    }

    @Test
    public void testSetFormatoDigital() {
        libroDigital.setFormatoDigital(FormatoDigital.EPUB);
        assertEquals(FormatoDigital.EPUB, libroDigital.getFormatoDigital());
    }

    @Test
    public void testGetEnlaceDescarga() {
        assertEquals("https://ejemplo.com/libro.pdf", libroDigital.getEnlaceDescarga());
    }

    @Test
    public void testSetEnlaceDescarga() {
        libroDigital.setEnlaceDescarga("https://nuevoenlace.com/descarga");
        assertEquals("https://nuevoenlace.com/descarga", libroDigital.getEnlaceDescarga());
    }

    @Test
    public void testTipoLibroEsDigital() {
        assertEquals(TipoLibro.DIGITAL, libroDigital.getTipoLibro());
    }

    @Test
    public void testToStringContieneTituloYFormato() {
        String resultado = libroDigital.toString();
        assertTrue(resultado.contains("Título Digital"));
        assertTrue(resultado.contains("formatoDigital=PDF"));
    }
}
