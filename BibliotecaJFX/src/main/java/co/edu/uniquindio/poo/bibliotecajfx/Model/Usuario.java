package co.edu.uniquindio.poo.bibliotecajfx.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombreCompleto;
    private String cedula;
    private String correo;
    private String contrasenia;
    private TipoUsuario tipoUsuario;
    int MaxDias;

    private List<Reserva> listReservasUsuario;

    public Usuario(String nombreCompleto, String cedula, String correo, String contrasenia, TipoUsuario tipoUsuario,int MaxDias) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
        this.listReservasUsuario = new ArrayList<>();
        this.MaxDias = MaxDias;
    }

public void solicitarPrestamoLibro(Libro libro, int dias){
        LocalDate fecha = LocalDate.now();
        Reserva reserva = new Reserva(libro,this,dias,fecha);
}


    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public int getMaxDias() {
        return MaxDias;
    }

    public void setMaxDias(int maxDias) {
        MaxDias = maxDias;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Reserva> getListReservasUsuario() {
        return listReservasUsuario;
    }

    public void setListReservasUsuario(List<Reserva> listReservasUsuario) {
        this.listReservasUsuario = listReservasUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", MaxDias=" + MaxDias +
                ", listReservasUsuario=" + listReservasUsuario +
                '}';
    }
}



