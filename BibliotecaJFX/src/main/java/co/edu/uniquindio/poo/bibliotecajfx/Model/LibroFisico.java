package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Representa un libro físico que extiende la clase {@link Libro}.
 *
 * <p>Esta clase modela un libro en formato físico, con disponibilidad para préstamo.</p>
 *
 * @author
 */
public class LibroFisico extends Libro {

    /**
     * Indica si el libro físico está disponible para préstamo.
     */
    private boolean estaDisponible;

    /**
     * Construye un libro físico con sus atributos específicos y los heredados de {@link Libro}.
     *
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param editorial Editorial que publicó el libro.
     * @param genero Género literario del libro.
     * @param anio Año de publicación del libro.
     * @param estaDisponible Indica si el libro está disponible para préstamo.
     */
    public LibroFisico(String titulo, String autor, String editorial, String genero, int anio, boolean estaDisponible) {
        super(titulo, autor, editorial, genero, anio, estaDisponible, TipoLibro.FISICO);
        this.estaDisponible = estaDisponible;
    }
}
