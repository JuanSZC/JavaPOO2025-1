package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Enumera los tipos posibles de libros en la biblioteca.
 *
 * <ul>
 *   <li>{@link #FISICO}: Libro en formato físico.</li>
 *   <li>{@link #DIGITAL}: Libro en formato digital.</li>
 *   <li>{@link #REFERENCIA}: Libro de consulta o referencia, usualmente no prestable.</li>
 * </ul>
 *
 * @author
 */
public enum TipoLibro {
    /**
     * Libro en formato físico.
     */
    FISICO,

    /**
     * Libro en formato digital.
     */
    DIGITAL,

    /**
     * Libro de consulta o referencia.
     */
    REFERENCIA;
}
