package co.edu.uniquindio.poo.bibliotecajfx.Controller;

import co.edu.uniquindio.poo.bibliotecajfx.Model.*;

import java.util.List;

/**
 * Controlador que gestiona las acciones que puede realizar un bibliotecario
 * dentro del sistema de gestión de biblioteca.
 */
public class BibliotecarioController {

    /**
     * Instancia del bibliotecario que realiza las acciones.
     */
    private final Bibliotecario bibliotecario;

    /**
     * Constructor que inicializa el controlador con un bibliotecario.
     *
     * @param bibliotecario el bibliotecario que usará el controlador
     */
    public BibliotecarioController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    /**
     * Registra un nuevo libro físico en la biblioteca.
     *
     * @param libro el libro físico a registrar
     */
    public void registrarLibroFisico(LibroFisico libro) {
        bibliotecario.registrarLibroFisico(libro);
    }

    /**
     * Registra un nuevo libro digital en la biblioteca.
     *
     * @param libro el libro digital a registrar
     */
    public void registrarLibroDigital(LibroDigital libro) {
        bibliotecario.registrarLibroDigital(libro);
    }

    /**
     * Registra un nuevo libro de referencia en la biblioteca.
     *
     * @param libro el libro de referencia a registrar
     */
    public void registrarLibroReferencia(LibroReferencia libro) {
        bibliotecario.registrarLibroReferencia(libro);
    }

    /**
     * Registra un nuevo estudiante como usuario de la biblioteca.
     *
     * @param estudiante el estudiante a registrar
     */
    public void registrarEstudiante(Estudiante estudiante) {
        bibliotecario.registrarEstudiante(estudiante);
    }

    /**
     * Registra un nuevo docente como usuario de la biblioteca.
     *
     * @param docente el docente a registrar
     */
    public void registrarDocente(Docente docente) {
        bibliotecario.registrarDocente(docente);
    }

    /**
     * Realiza el préstamo de un libro a un usuario por una cantidad de días.
     *
     * @param libro       el libro a prestar
     * @param usuario     el usuario que recibe el libro
     * @param tiempoDias  el tiempo en días del préstamo
     */
    public void prestarLibro(Libro libro, Usuario usuario, int tiempoDias) {
        bibliotecario.prestarLibro(libro, usuario, tiempoDias);
    }

    /**
     * Elimina un usuario del sistema.
     *
     * @param usuario el usuario a eliminar
     */
    public void eliminarUsuario(Usuario usuario) {
        this.bibliotecario.removerUsuario(usuario);
    }

    /**
     * Elimina un libro del sistema.
     *
     * @param libro el libro a eliminar
     */
    public void eliminarLibro(Libro libro) {
        this.bibliotecario.elmininarLibro(libro);
    }

    /**
     * Modifica los datos de un usuario existente.
     *
     * @param usuario     el usuario a modificar
     * @param nombre      nuevo nombre del usuario
     * @param cedula      nueva cédula del usuario
     * @param correo      nuevo correo del usuario
     * @param contrasena  nueva contraseña del usuario
     */
    public void modificarUsuario(Usuario usuario, String nombre, String cedula, String correo, String contrasena) {
        this.bibliotecario.modificarUsuario(usuario, nombre, cedula, correo, contrasena);
    }

    /**
     * Modifica los datos de un libro existente.
     *
     * @param libro         el libro a modificar
     * @param titulo        nuevo título
     * @param autor         nuevo autor
     * @param editorial     nueva editorial
     * @param genero        nuevo género
     * @param anio          nuevo año de publicación
     * @param estaDisponible disponibilidad del libro
     */
    public void modificarLibro(Libro libro, String titulo, String autor, String editorial, String genero, int anio, boolean estaDisponible) {
        this.bibliotecario.modificarLibro(libro, titulo, autor, editorial, genero, anio, estaDisponible);
    }

    /**
     * Registra la devolución de un libro prestado.
     *
     * @param reserva la reserva del libro devuelto
     */
    public void devolverLibro(Reserva reserva) {
        bibliotecario.devolverLibro(reserva);
    }

    /**
     * Obtiene una lista de los libros actualmente prestados.
     *
     * @return lista de libros prestados
     */
    public List<Libro> obtenerLibrosPrestados() {
        return bibliotecario.obtenerLibrosPrestados();
    }

    /**
     * Genera un informe de la actividad del bibliotecario.
     *
     * @return una cadena con el contenido del informe
     */
    public String generarInforme() {
        return bibliotecario.generarInforme();
    }
}
