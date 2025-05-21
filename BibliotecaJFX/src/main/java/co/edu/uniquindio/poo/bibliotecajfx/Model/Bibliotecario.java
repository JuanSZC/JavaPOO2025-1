package co.edu.uniquindio.poo.bibliotecajfx.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Bibliotecario extends Empleado {

    public Bibliotecario(String nombreCompleto, String cedula, String contrasenia, Biblioteca biblioteca) {
        super(nombreCompleto, cedula, contrasenia, TipoTrabajo.BIBLIOTECARIO, biblioteca);
    }

    public void registrarLibroFisico(LibroFisico libroFisico) {
        this.getBiblioteca().getListLibros().add(libroFisico);
    }

    public void registrarLibroDigital(LibroDigital libroDigital) {
        this.getBiblioteca().getListLibros().add(libroDigital);
    }

    public void registrarLibroReferencia(LibroReferencia libroReferencia) {
        this.getBiblioteca().getListLibros().add(libroReferencia);
    }

    public void registrarEstudiante(Estudiante estudiante) {
        if (!this.getBiblioteca().getListUsuarios().contains(estudiante)) {
            this.getBiblioteca().getListUsuarios().add(estudiante);
        } else {
            this.getBiblioteca().mostrarError("Usuario ya registrado");
        }
    }

    public void registrarDocente(Docente docente) {
        if (!this.getBiblioteca().getListUsuarios().contains(docente)) {
            this.getBiblioteca().getListUsuarios().add(docente);
        } else {
            this.getBiblioteca().mostrarError("Usuario ya registrado");
        }
    }

    public void prestarLibro(Libro libro, Usuario usuario, int tiempoDias) {
        if (libro.isEstaDisponible()) {
            Reserva reserva = new Reserva(libro, usuario, tiempoDias, LocalDate.now());
            this.getBiblioteca().getListReservas().add(reserva);
            usuario.getListReservasUsuario().add(reserva);
            libro.setEstaDisponible(false);
        } else {
            this.getBiblioteca().mostrarError("El libro no está disponible");
        }
    }

    public void devolverLibro(Reserva reserva) {
        if (this.getBiblioteca().getListReservas().contains(reserva)) {
            reserva.getUsuario().getListReservasUsuario().remove(reserva);
            this.getBiblioteca().getListReservas().remove(reserva);
            reserva.getLibro().setEstaDisponible(true);
        } else {
            this.getBiblioteca().mostrarError("La reserva no existe");
        }
    }

    public List<Libro> obtenerLibrosPrestados() {
        List<Libro> librosPrestados = new ArrayList<>();
        for (Reserva reserva : this.getBiblioteca().getListReservas()) {
            librosPrestados.add(reserva.getLibro());
        }
        return librosPrestados;
    }

    public String generarInforme() {
        return "";
    }

}
