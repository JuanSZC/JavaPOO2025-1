package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Representa un libro de referencia que extiende la clase {@link Libro}.
 *
 * <p>Los libros de referencia generalmente no están disponibles para préstamo,
 * por lo que siempre están marcados como disponibles solo para consulta interna.</p>
 *
 * <p>Este tipo de libro tiene disponibilidad fija en {@code true} para indicar
 * que está disponible para consulta.</p>
 *
 * @author
 */
public class LibroReferencia extends Libro {

    /**
     * Construye un libro de referencia con los atributos básicos heredados de {@link Libro}.
     * La disponibilidad se fija en {@code true} y el tipo en {@link TipoLibro#REFERENCIA}.
     *
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param editorial Editorial que publicó el libro.
     * @param genero Género literario del libro.
     * @param anio Año de publicación del libro.
     */
    public LibroReferencia(String titulo, String autor, String editorial, String genero, int anio) {
        super(titulo, autor, editorial, genero, anio, true, TipoLibro.REFERENCIA);
    }
}
