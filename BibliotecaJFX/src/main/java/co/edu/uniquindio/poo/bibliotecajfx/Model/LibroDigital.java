package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Representa un libro digital que extiende la clase {@link Libro}.
 * Contiene información adicional sobre el formato digital y el enlace de descarga.
 *
 * <p>Hereda los atributos generales de un libro, y agrega:
 * <ul>
 *   <li>Formato digital del libro.</li>
 *   <li>Enlace para descargar el libro.</li>
 * </ul>
 * </p>
 *
 * @author
 */
public class LibroDigital extends Libro {

    /**
     * Formato digital en el que está disponible el libro.
     */
    private FormatoDigital formatoDigital;

    /**
     * Enlace URL para la descarga del libro digital.
     */
    private String enlaceDescarga;

    /**
     * Construye un libro digital con sus atributos específicos y los heredados de {@link Libro}.
     *
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param editorial Editorial que publicó el libro.
     * @param genero Género literario del libro.
     * @param anio Año de publicación del libro.
     * @param formatoDigital Formato digital del libro.
     * @param enlaceDescarga Enlace para descargar el libro digital.
     * @param disponible Indica si el libro está disponible para préstamo.
     */
    public LibroDigital(String titulo, String autor, String editorial, String genero, int anio, FormatoDigital formatoDigital, String enlaceDescarga, boolean disponible) {
        super(titulo, autor, editorial, genero, anio, disponible, TipoLibro.DIGITAL);
        this.formatoDigital = formatoDigital;
        this.enlaceDescarga = enlaceDescarga;
    }

    /**
     * Obtiene el formato digital del libro.
     *
     * @return El formato digital.
     */
    public FormatoDigital getFormatoDigital() {
        return formatoDigital;
    }

    /**
     * Establece el formato digital del libro.
     *
     * @param formatoDigital Nuevo formato digital.
     */
    public void setFormatoDigital(FormatoDigital formatoDigital) {
        this.formatoDigital = formatoDigital;
    }

    /**
     * Obtiene el enlace de descarga del libro digital.
     *
     * @return El enlace de descarga.
     */
    public String getEnlaceDescarga() {
        return enlaceDescarga;
    }

    /**
     * Establece el enlace de descarga del libro digital.
     *
     * @param enlaceDescarga Nuevo enlace de descarga.
     */
    public void setEnlaceDescarga(String enlaceDescarga) {
        this.enlaceDescarga = enlaceDescarga;
    }

    /**
     * Devuelve una representación en cadena del libro digital, incluyendo la información heredada y sus atributos específicos.
     *
     * @return Cadena con la información del libro digital.
     */
    @Override
    public String toString() {
        return super.toString() + " LibroDigital{" +
                "formatoDigital=" + formatoDigital +
                ", enlaceDescarga='" + enlaceDescarga + '\'' +
                '}';
    }
}
