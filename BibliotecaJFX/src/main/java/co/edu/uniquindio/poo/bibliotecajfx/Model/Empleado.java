package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class Empleado {

    private String nombreCompleto;
    private int cedula;
    private String Contrasenia;
    private TipoTrabajo tipoTrabajo;
    private Biblioteca biblioteca;

    public Empleado(String nombreCompleto, int cedula, String contrasenia, TipoTrabajo tipoTrabajo, Biblioteca biblioteca) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.Contrasenia = contrasenia;
        this.tipoTrabajo = tipoTrabajo;
        this.biblioteca = biblioteca;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", cedula=" + cedula +
                ", Contrasenia='" + Contrasenia + '\'' +
                ", tipoTrabajo=" + tipoTrabajo +
                ", biblioteca=" + biblioteca +
                '}';
    }
}
