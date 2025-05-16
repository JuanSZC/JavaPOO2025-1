package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class Administrador extends Empleado{
    public Administrador(String nombreCompleto, int cedula, String contrasenia,Biblioteca biblioteca) {
        super(nombreCompleto, cedula, contrasenia, TipoTrabajo.ADMINISTRADOR,biblioteca);
    }
    public void agregarBibliotecario(Bibliotecario bibliotecario){
            this.getBiblioteca().getListEmpleados().add(bibliotecario);
    }
    public void agregarAdministrador(Administrador administrador){
        this.getBiblioteca().getListEmpleados().add(administrador);
    }
    public void removerBibliotecario(Bibliotecario bibliotecario){
        this.getBiblioteca().getListEmpleados().remove(bibliotecario);
    }
    public void removerAdministrador(Administrador administrador){
        this.getBiblioteca().getListEmpleados().remove(administrador);
    }
    public boolean compararCredenciales(String nombreCompleto,String contrasenia){
        for (Empleado empleado : this.getBiblioteca().getListEmpleados() ) {
            if (empleado.getNombreCompleto().equals(nombreCompleto) && empleado.getContrasenia().equals(contrasenia)) {
                return true;
            }
        }
        return false;
    }
}


