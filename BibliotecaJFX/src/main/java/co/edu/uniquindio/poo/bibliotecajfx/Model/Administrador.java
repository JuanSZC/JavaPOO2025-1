package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class Administrador extends Empleado{
    public Administrador(String nombreCompleto, String cedula, String contrasenia,Biblioteca biblioteca) {
        super(nombreCompleto, cedula, contrasenia, TipoTrabajo.ADMINISTRADOR,biblioteca);
    }
    public void agregarBibliotecario(Bibliotecario bibliotecario){
        if (!this.getBiblioteca().getListEmpleados().contains(bibliotecario) ) {
            this.getBiblioteca().getListEmpleados().add(bibliotecario);
        }
        else{
            this.getBiblioteca().mostrarError("El empleado ya existe.");
        }
    }
    public void agregarAdministrador(Administrador administrador){
        if (!this.getBiblioteca().getListEmpleados().contains(administrador)) {
            this.getBiblioteca().getListEmpleados().add(administrador);
        }
        else{
            this.getBiblioteca().mostrarError("El empleado ya existe.");
        }
    }
    public void removerEmpleado(Empleado empleado) {
        if (this.getBiblioteca().getListEmpleados().contains(empleado)) {
            this.getBiblioteca().getListEmpleados().remove(empleado);
        } else {
            this.getBiblioteca().mostrarError("El empleado que intenta remover no existe.");
        }
    }

    public boolean compararCredencialesEmpleados(String cedula,String contrasenia){
        for (Empleado empleado : this.getBiblioteca().getListEmpleados() ) {
            if (empleado.getCedula().equals(cedula) && empleado.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        this.getBiblioteca().mostrarError("Credenciales incorrectas o no encontradas.");
        return false;

    }
    public Empleado obtenerCredencialesEmpleados(String cedula) {
        for (Empleado empleado : this.getBiblioteca().getListEmpleados()) {
            if (empleado.getCedula().equals(cedula)) {
                return empleado;
            }
        }
        return null;
    }

    public Usuario obtenerCredencialesUsuarios(String cedula) {
        for (Usuario usuario : this.getBiblioteca().getListUsuarios()) {
            if (usuario.getCedula().equals(cedula)) {
                return usuario;
            }
        }
        return null;
    }


    public boolean compararCredencialesUsuarios(String cedula,String contrasenia){
        for (Usuario usuario : this.getBiblioteca().getListUsuarios() ) {
            if (usuario.getCedula().equals(cedula) && usuario.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        this.getBiblioteca().mostrarError("Credenciales incorrectas o no encontradas.");
        return false;

    }

    public void modificarEmpleado(Empleado empleado,String nombreCompleto,String cedula,String contrasenia){
      empleado.setNombreCompleto(nombreCompleto);
      empleado.setCedula(cedula);
      empleado.setContrasenia(contrasenia);
    }



    public String generarInformeAvanzado() {
        return "INFORME DE ADMINISTRADOR:\n"+
                "Cantidad de Empleados: "+this.getBiblioteca().getListEmpleados().size();
    }

}


