package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Representa un usuario tipo Estudiante en la biblioteca.
 * Hereda de la clase Usuario y define límites específicos para días máximos y cantidad de libros.
 */
public class Estudiante extends Usuario {

    /**
     * Número máximo de días para préstamo permitido a un estudiante.
     */
    private static final int MAXDIAS = 5;

    /**
     * Número máximo de libros que un estudiante puede tener prestados.
     */
    private static final int MAXLIBROS = 10;

    /**
     * Crea un nuevo estudiante con los datos personales y la biblioteca a la que está asociado.
     * Inicializa los límites de préstamo específicos para estudiantes.
     *
     * @param nombreCompleto Nombre completo del estudiante
     * @param cedula Cédula de identidad del estudiante
     * @param correo Correo electrónico del estudiante
     * @param contrasenia Contraseña para acceso del estudiante
     * @param biblioteca Biblioteca en la que el estudiante está registrado
     */
    public Estudiante(String nombreCompleto, String cedula, String correo, String contrasenia, Biblioteca biblioteca) {
        super(nombreCompleto, cedula, correo, contrasenia, TipoUsuario.ESTUDIANTE, MAXDIAS, MAXLIBROS, biblioteca);
    }
}
