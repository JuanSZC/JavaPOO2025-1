package co.edu.uniquindio.poo.bibliotecajfx.Model;

import java.time.LocalDate;


public class Reserva {
    private Libro libro;
    private Usuario usuario;
    private int tiempoDias;
    private LocalDate fecha;

    public Reserva(Libro libro, Usuario usuario, int tiempoDias, LocalDate fecha) {
        this.libro = libro;
        this.usuario = usuario;
        this.tiempoDias = tiempoDias;
        this.fecha = fecha;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTiempoDias() {
        return tiempoDias;
    }

    public void setTiempoDias(int tiempoDias) {
        this.tiempoDias = tiempoDias;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "libro=" + libro.getTitulo() +
                ", usuario=" + usuario.getNombreCompleto()+
                ", TiempoDias=" + tiempoDias +
                ", fecha=" + fecha +
                '}';
    }
}
