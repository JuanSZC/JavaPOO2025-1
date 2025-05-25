package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Clase que representa a un Administrador en la biblioteca.
 * Hereda de la clase Empleado y permite gestionar empleados y usuarios.
 */
public class Administrador extends Empleado {

    /**
     * Constructor del Administrador.
     *
     * @param nombreCompleto Nombre completo del administrador.
     * @param cedula Cédula del administrador.
     * @param contrasenia Contraseña del administrador.
     * @param biblioteca Biblioteca asociada al administrador.
     */
    public Administrador(String nombreCompleto, String cedula, String contrasenia, Biblioteca biblioteca) {
        super(nombreCompleto, cedula, contrasenia, TipoTrabajo.ADMINISTRADOR, biblioteca);
    }

    /**
     * Agrega un bibliotecario a la lista de empleados de la biblioteca si no existe.
     *
     * @param bibliotecario Bibliotecario a agregar.
     */
    public void agregarBibliotecario(Bibliotecario bibliotecario) {
        if (!this.getBiblioteca().getListEmpleados().contains(bibliotecario)) {
            this.getBiblioteca().getListEmpleados().add(bibliotecario);
        } else {
            this.getBiblioteca().mostrarError("El empleado ya existe.");
        }
    }

    /**
     * Agrega un administrador a la lista de empleados de la biblioteca si no existe.
     *
     * @param administrador Administrador a agregar.
     */
    public void agregarAdministrador(Administrador administrador) {
        if (!this.getBiblioteca().getListEmpleados().contains(administrador)) {
            this.getBiblioteca().getListEmpleados().add(administrador);
        } else {
            this.getBiblioteca().mostrarError("El empleado ya existe.");
        }
    }

    /**
     * Remueve un empleado de la lista de empleados si existe.
     *
     * @param empleado Empleado a remover.
     */
    public void removerEmpleado(Empleado empleado) {
        if (this.getBiblioteca().getListEmpleados().contains(empleado)) {
            this.getBiblioteca().getListEmpleados().remove(empleado);
        } else {
            this.getBiblioteca().mostrarError("El empleado que intenta remover no existe.");
        }
    }

    /**
     * Compara las credenciales (cédula y contraseña) de un empleado.
     *
     * @param cedula Cédula del empleado.
     * @param contrasenia Contraseña del empleado.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public boolean compararCredencialesEmpleados(String cedula, String contrasenia) {
        for (Empleado empleado : this.getBiblioteca().getListEmpleados()) {
            if (empleado.getCedula().equals(cedula) && empleado.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        this.getBiblioteca().mostrarError("Credenciales incorrectas o no encontradas.");
        return false;
    }

    /**
     * Obtiene un empleado por su cédula.
     *
     * @param cedula Cédula del empleado.
     * @return El empleado encontrado o null si no existe.
     */
    public Empleado obtenerCredencialesEmpleados(String cedula) {
        for (Empleado empleado : this.getBiblioteca().getListEmpleados()) {
            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null;
    }

    /**
     * Obtiene un usuario por su cédula.
     *
     * @param cedula Cédula del usuario.
     * @return El usuario encontrado o null si no existe.
     */
    public Usuario obtenerCredencialesUsuarios(String cedula) {
        for (Usuario usuario : this.getBiblioteca().getListUsuarios()) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Compara las credenciales (cédula y contraseña) de un usuario.
     *
     * @param cedula Cédula del usuario.
     * @param contrasenia Contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public boolean compararCredencialesUsuarios(String cedula, String contrasenia) {
        for (Usuario usuario : this.getBiblioteca().getListUsuarios()) {
            if (usuario.getCedula().equals(cedula) && usuario.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        this.getBiblioteca().mostrarError("Credenciales incorrectas o no encontradas.");
        return false;
    }

    /**
     * Modifica los datos de un empleado.
     *
     * @param empleado Empleado a modificar.
     * @param nombreCompleto Nuevo nombre completo.
     * @param cedula Nueva cédula.
     * @param contrasenia Nueva contraseña.
     */
    public void modificarEmpleado(Empleado empleado, String nombreCompleto, String cedula, String contrasenia) {
        empleado.setNombreCompleto(nombreCompleto);
        empleado.setCedula(cedula);
        empleado.setContrasenia(contrasenia);
    }

    /**
     * Genera un informe avanzado de los empleados en la biblioteca.
     *
     * @return Cadena con el informe del administrador.
     */
    public String generarInformeAvanzado() {
        return "INFORME DE ADMINISTRADOR:\n" +
                "Cantidad de Empleados: " + this.getBiblioteca().getListEmpleados().size();
    }
}
