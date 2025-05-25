package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Clase que representa un usuario tipo Docente en el sistema de la biblioteca.
 * Un docente tiene límites específicos para el préstamo de libros en cuanto a días y cantidad máxima.
 * Hereda de la clase {@link Usuario}.
 *
 * @author
 */
public class Docente extends Usuario {

    /**
     * Número máximo de días que un docente puede prestar un libro.
     */
    private static final int MAXDIAS = 15;

    /**
     * Número máximo de libros que un docente puede tener prestados al mismo tiempo.
     */
    private static final int MAXLIBROS = 30;

    /**
     * Crea un nuevo docente con los datos especificados y lo asocia a una biblioteca.
     *
     * @param nombreCompleto Nombre completo del docente.
     * @param cedula Número de identificación del docente.
     * @param correo Correo electrónico del docente.
     * @param contrasenia Contraseña para acceso del docente.
     * @param biblioteca Biblioteca a la que pertenece el docente.
     */
    public Docente(String nombreCompleto, String cedula, String correo, String contrasenia, Biblioteca biblioteca) {
        super(nombreCompleto, cedula, correo, contrasenia, TipoUsuario.DOCENTE, MAXDIAS, MAXLIBROS, biblioteca);
    }
}
