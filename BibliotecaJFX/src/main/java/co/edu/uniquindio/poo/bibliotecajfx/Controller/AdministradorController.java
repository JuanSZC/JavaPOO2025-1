package co.edu.uniquindio.poo.bibliotecajfx.Controller;

import co.edu.uniquindio.poo.bibliotecajfx.Model.*;

public class AdministradorController {

    private final Administrador administrador;

    public AdministradorController(Administrador administrador) {
        this.administrador = administrador;
    }

    public void agregarBibliotecario(String nombreCompleto, String cedula, String contrasenia) {
        Bibliotecario nuevoBibliotecario = new Bibliotecario(nombreCompleto, cedula, contrasenia, administrador.getBiblioteca());
        administrador.agregarBibliotecario(nuevoBibliotecario);
    }

    public void agregarAdministrador(String nombreCompleto, String cedula, String contrasenia) {
        Administrador nuevoAdministrador = new Administrador(nombreCompleto, cedula, contrasenia, administrador.getBiblioteca());
        administrador.agregarAdministrador(nuevoAdministrador);
    }

    public void removerEmpleado(Empleado empleado) {
       this.administrador.removerEmpleado(empleado);
    }

    public void modificarEmpleado(Empleado empleado, String nuevoNombre, String nuevaCedula, String nuevaContrasenia) {
        administrador.modificarEmpleado(empleado, nuevoNombre, nuevaCedula, nuevaContrasenia);
    }

    public boolean validarCredencialesEmpleado(String cedula, String contrasenia) {
        return administrador.compararCredencialesEmpleados(cedula, contrasenia);
    }

    public Empleado obtenerEmpleado(String cedula) {
        return administrador.obtenerCredencialesEmpleados(cedula);
    }

    public Usuario obtenerUsuario(String cedula) {
        return administrador.obtenerCredencialesUsuarios(cedula);
    }

    public boolean validadCredencialesUsuario(String cedula, String contrasenia) {
        return administrador.compararCredencialesUsuarios(cedula, contrasenia);
    }

    public String generarInforme() {
        return administrador.generarInformeAvanzado();
    }
}
