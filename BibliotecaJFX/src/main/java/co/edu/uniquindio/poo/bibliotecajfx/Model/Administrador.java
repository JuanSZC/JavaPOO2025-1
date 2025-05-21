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
    public void removerBibliotecario(Bibliotecario bibliotecario){
        if (this.getBiblioteca().getListEmpleados().contains(bibliotecario)) {
        this.getBiblioteca().getListEmpleados().remove(bibliotecario);
        }
        else{
            this.getBiblioteca().mostrarError("El empleado que intenta remover no existe.");
        }
    }
    public void removerAdministrador(Administrador administrador){
        if (this.getBiblioteca().getListEmpleados().contains(administrador)) {
            this.getBiblioteca().getListEmpleados().remove(administrador);
        }
        else{
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

    public boolean compararCredencialesUsuarios(String cedula,String contrasenia){
        for (Usuario usuario : this.getBiblioteca().getListUsuarios() ) {
            if (usuario.getCedula().equals(cedula) && usuario.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        this.getBiblioteca().mostrarError("Credenciales incorrectas o no encontradas.");
        return false;
    }

    public void modificarBibliotecario(Bibliotecario bibliotecarioOriginal,String nombreCompleto,String cedula,String contrasenia){
      bibliotecarioOriginal.setNombreCompleto(nombreCompleto);
      bibliotecarioOriginal.setCedula(cedula);
      bibliotecarioOriginal.setContrasenia(contrasenia);
    }

    public void modificarAdministrador(Administrador administradorOriginal,String nombreCompleto,String cedula,String contrasenia){
        administradorOriginal.setNombreCompleto(nombreCompleto);
        administradorOriginal.setCedula(cedula);
        administradorOriginal.setContrasenia(contrasenia);
    }


    public String generarInformeAvanzado() {
        return "";
    }

}


