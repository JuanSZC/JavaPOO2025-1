package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class Administrador extends Empleado{
    public Administrador(String nombreCompleto, int cedula, String contrasenia,Biblioteca biblioteca) {
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
    public boolean compararCredenciales(String nombreCompleto,String contrasenia){
        for (Empleado empleado : this.getBiblioteca().getListEmpleados() ) {
            if (empleado.getNombreCompleto().equals(nombreCompleto) && empleado.getContrasenia().equals(contrasenia)) {
                return true;
            }



        }
        this.getBiblioteca().mostrarError("Credenciales incorrectas o no encontradas.");
        return false;

    }
}


