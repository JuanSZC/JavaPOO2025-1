package co.edu.uniquindio.poo.bibliotecajfx.Controller;

import co.edu.uniquindio.poo.bibliotecajfx.Model.*;

/**
 * Controlador para las operaciones que puede realizar un administrador
 * dentro del sistema de gestión de biblioteca.
 */
public class AdministradorController {

    /**
     * Instancia del administrador que realiza las acciones.
     */
    private final Administrador administrador;

    /**
     * Constructor que inicializa el controlador con un administrador.
     *
     * @param administrador el administrador que usará el controlador
     */
    public AdministradorController(Administrador administrador) {
        this.administrador = administrador;
    }

    /**
     * Agrega un nuevo bibliotecario al sistema.
     *
     * @param nombreCompleto nombre completo del bibliotecario
     * @param cedula         cédula del bibliotecario
     * @param contrasenia    contraseña del bibliotecario
     */
    public void agregarBibliotecario(String nombreCompleto, String cedula, String contrasenia) {
        Bibliotecario nuevoBibliotecario = new Bibliotecario(nombreCompleto, cedula, contrasenia, administrador.getBiblioteca());
        administrador.agregarBibliotecario(nuevoBibliotecario);
    }

    /**
     * Agrega un nuevo administrador al sistema.
     *
     * @param nombreCompleto nombre completo del administrador
     * @param cedula         cédula del administrador
     * @param contrasenia    contraseña del administrador
     */
    public void agregarAdministrador(String nombreCompleto, String cedula, String contrasenia) {
        Administrador nuevoAdministrador = new Administrador(nombreCompleto, cedula, contrasenia, administrador.getBiblioteca());
        administrador.agregarAdministrador(nuevoAdministrador);
    }

    /**
     * Remueve un empleado del sistema.
     *
     * @param empleado el empleado a remover
     */
    public void removerEmpleado(Empleado empleado) {
        this.administrador.removerEmpleado(empleado);
    }

    /**
     * Modifica los datos de un empleado existente.
     *
     * @param empleado         el empleado a modificar
     * @param nuevoNombre      nuevo nombre del empleado
     * @param nuevaCedula      nueva cédula del empleado
     * @param nuevaContrasenia nueva contraseña del empleado
     */
    public void modificarEmpleado(Empleado empleado, String nuevoNombre, String nuevaCedula, String nuevaContrasenia) {
        administrador.modificarEmpleado(empleado, nuevoNombre, nuevaCedula, nuevaContrasenia);
    }

    /**
     * Valida las credenciales de un empleado.
     *
     * @param cedula      cédula del empleado
     * @param contrasenia contraseña del empleado
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean validarCredencialesEmpleado(String cedula, String contrasenia) {
        return administrador.compararCredencialesEmpleados(cedula, contrasenia);
    }

    /**
     * Obtiene un empleado por su cédula.
     *
     * @param cedula cédula del empleado
     * @return el empleado correspondiente, o null si no existe
     */
    public Empleado obtenerEmpleado(String cedula) {
        return administrador.obtenerCredencialesEmpleados(cedula);
    }

    /**
     * Obtiene un usuario por su cédula.
     *
     * @param cedula cédula del usuario
     * @return el usuario correspondiente, o null si no existe
     */
    public Usuario obtenerUsuario(String cedula) {
        return administrador.obtenerCredencialesUsuarios(cedula);
    }

    /**
     * Valida las credenciales de un usuario.
     *
     * @param cedula      cédula del usuario
     * @param contrasenia contraseña del usuario
     * @return true si las credenciales son válidas, false en caso contrario
     */
    public boolean validadCredencialesUsuario(String cedula, String contrasenia) {
        return administrador.compararCredencialesUsuarios(cedula, contrasenia);
    }

    /**
     * Genera un informe avanzado de la biblioteca.
     *
     * @return una cadena con el contenido del informe
     */
    public String generarInforme() {
        return administrador.generarInformeAvanzado();
    }
}
