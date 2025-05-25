package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Enumeración que representa los formatos digitales disponibles para los recursos de la biblioteca.
 *
 * <p>Los formatos posibles son:
 * <ul>
 *   <li>{@link #PDF} - Formato de documento portátil.</li>
 *   <li>{@link #EPUB} - Formato de libro electrónico estándar.</li>
 *   <li>{@link #MOBI} - Formato de libro electrónico utilizado en dispositivos Kindle.</li>
 * </ul>
 * </p>
 *
 * @author
 */
public enum FormatoDigital {
    /**
     * Formato PDF.
     */
    PDF,

    /**
     * Formato EPUB.
     */
    EPUB,

    /**
     * Formato MOBI.
     */
    MOBI;
}
