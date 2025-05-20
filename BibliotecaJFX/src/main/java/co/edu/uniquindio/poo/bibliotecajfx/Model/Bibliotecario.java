package co.edu.uniquindio.poo.bibliotecajfx.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado {


    public Bibliotecario(String nombreCompleto, int cedula, String contrasenia, Biblioteca biblioteca) {
        super(nombreCompleto, cedula, contrasenia, TipoTrabajo.BIBLIOTECARIO, biblioteca);

    }

    public void registrarLibro(Libro libro) {
        this.getBiblioteca().getListLibros().add(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        if (!this.getBiblioteca().getListUsuarios().contains(usuario)) {
            this.getBiblioteca().getListUsuarios().add(usuario);
        }
        else {
            this.getBiblioteca().mostrarError("Usuario ya registrado");
        }
    }

    public void prestarLibro(Libro libro, Usuario usuario,int tiempoDias) {
        Reserva reserva = new Reserva(libro,usuario,tiempoDias,LocalDate.now());
        this.getBiblioteca().getListReservas().add(reserva);
        usuario.getListReservasUsuario().add(reserva);
        libro.setEstaDisponible(false);
    }

    public void devolverLibro(Reserva reserva) {
        if (this.getBiblioteca().getListReservas().contains(reserva)) {
            reserva.getUsuario().getListReservasUsuario().remove(reserva);
            this.getBiblioteca().getListReservas().remove(reserva);
            reserva.getLibro().setEstaDisponible(true);
        }
        else {
            this.getBiblioteca().mostrarError("La reserva no existe");
        }
    }

    public List<Libro> obtenerLibrosPrestados(){
        List<Libro> librosPrestados = new ArrayList<>();
        for(Reserva reserva : this.getBiblioteca().getListReservas()){
            librosPrestados.add(reserva.getLibro());
        }
        return librosPrestados;
    }


}
