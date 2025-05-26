package co.edu.uniquindio.poo.bibliotecajfx.Controller;

import co.edu.uniquindio.poo.bibliotecajfx.Model.Libro;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Reserva;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Usuario;

import java.time.LocalDate;

/**
 * Controlador que gestiona las acciones que puede realizar un usuario
 * dentro del sistema de gestión de biblioteca.
 */
public class UsuarioController {

    /**
     * Instancia del usuario que realiza las acciones.
     */
    private final Usuario usuario;

    /**
     * Constructor que inicializa el controlador con un usuario.
     *
     * @param usuario el usuario que usará el controlador
     */
    public UsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Solicita el préstamo de un libro por parte del usuario por un número determinado de días.
     *
     * @param libro el libro que se desea prestar
     * @param dias  la cantidad de días por los que se solicita el préstamo
     */
    public void solicitarPrestamoLibro(Libro libro, int dias) {
        usuario.solicitarPrestamoLibro(libro, dias);
    }

}
