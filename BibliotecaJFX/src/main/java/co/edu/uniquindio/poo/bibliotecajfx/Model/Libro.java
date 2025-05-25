package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Representa un libro en la biblioteca con sus atributos principales.
 * Incluye información sobre título, autor, editorial, género, año, disponibilidad y tipo de libro.
 *
 * <p>Esta clase proporciona métodos para obtener y modificar sus propiedades.</p>
 *
 * @author
 */
public class Libro {

    /**
     * Título del libro.
     */
    private String titulo;

    /**
     * Autor del libro.
     */
    private String autor;

    /**
     * Editorial que publicó el libro.
     */
    private String editorial;

    /**
     * Género literario del libro.
     */
    private String genero;

    /**
     * Año de publicación del libro.
     */
    private int anio;

    /**
     * Indica si el libro está disponible para préstamo.
     */
    private boolean estaDisponible;

    /**
     * Tipo del libro (puede ser físico, digital, etc.).
     */
    private TipoLibro tipoLibro;

    /**
     * Constructor para crear un libro con todos sus atributos.
     *
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param editorial Editorial que publicó el libro.
     * @param genero Género literario del libro.
     * @param anio Año de publicación del libro.
     * @param estaDisponible Indica si el libro está disponible para préstamo.
     * @param tipoLibro Tipo del libro.
     */
    public Libro(String titulo, String autor, String editorial, String genero, int anio, boolean estaDisponible, TipoLibro tipoLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.anio = anio;
        this.estaDisponible = estaDisponible;
        this.tipoLibro = tipoLibro;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo Nuevo título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor Nuevo autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Obtiene la editorial del libro.
     *
     * @return La editorial que publicó el libro.
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Establece la editorial del libro.
     *
     * @param editorial Nueva editorial del libro.
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * Obtiene el género literario del libro.
     *
     * @return El género literario del libro.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género literario del libro.
     *
     * @param genero Nuevo género literario del libro.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el año de publicación del libro.
     *
     * @return El año en que se publicó el libro.
     */
    public int getAnio() {
        return anio;
    }

    /**
     * Establece el año de publicación del libro.
     *
     * @param anio Nuevo año de publicación.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }

    /**
     * Indica si el libro está disponible para préstamo.
     *
     * @return true si está disponible, false en caso contrario.
     */
    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    /**
     * Establece si el libro está disponible para préstamo.
     *
     * @param estaDisponible Nuevo estado de disponibilidad.
     */
    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    /**
     * Obtiene el tipo del libro.
     *
     * @return El tipo del libro.
     */
    public TipoLibro getTipoLibro() {
        return tipoLibro;
    }

    /**
     * Establece el tipo del libro.
     *
     * @param tipoLibro Nuevo tipo del libro.
     */
    public void setTipoLibro(TipoLibro tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    /**
     * Devuelve una representación en cadena del libro con sus atributos principales.
     *
     * @return Cadena con la información del libro.
     */
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", genero='" + genero + '\'' +
                ", anio=" + anio +
                ", estaDisponible=" + estaDisponible +
                ", tipoLibro=" + tipoLibro +
                '}';
    }
}
