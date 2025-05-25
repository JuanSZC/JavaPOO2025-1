package co.edu.uniquindio.poo.bibliotecajfx.Controller;

import co.edu.uniquindio.poo.bibliotecajfx.Model.*;

import java.util.List;

public class BibliotecarioController {

    private final Bibliotecario bibliotecario;

    public BibliotecarioController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void registrarLibroFisico(LibroFisico libro) {
        bibliotecario.registrarLibroFisico(libro);
    }
    public void registrarLibroDigital(LibroDigital libro) {
        bibliotecario.registrarLibroDigital(libro);
    }
    public void registrarLibroReferencia(LibroReferencia libro) {
        bibliotecario.registrarLibroReferencia(libro);
    }

    public void registrarEstudiante(Estudiante estudiante) {
        bibliotecario.registrarEstudiante(estudiante);
    }
    public void registrarDocente(Docente docente) {
        bibliotecario.registrarDocente(docente);
     }

    public void prestarLibro(Libro libro, Usuario usuario, int tiempoDias) {
        bibliotecario.prestarLibro(libro, usuario, tiempoDias);

    }
    public void eliminarUsuario(Usuario usuario) {
        this.bibliotecario.removerUsuario(usuario);
    }

    public void eliminarLibro(Libro libro) {
        this.bibliotecario.elmininarLibro(libro);
    }

    public void modificarUsuario(Usuario usuario,String nombre,String cedula, String correo, String contrasena) {
        this.bibliotecario.modificarUsuario(usuario,nombre,cedula,correo,contrasena);
    }

    public void modificarLibro(Libro libro,String titulo, String autor, String editorial, String genero, int anio, boolean estaDisponible) {
        this.bibliotecario.modificarLibro(libro,titulo, autor,editorial,genero,anio,estaDisponible);
    }

    public void devolverLibro(Reserva reserva) {
        bibliotecario.devolverLibro(reserva);
    }

    public List<Libro> obtenerLibrosPrestados() {
        return bibliotecario.obtenerLibrosPrestados();
    }

    public String generarInforme() {
        return bibliotecario.generarInforme();
    }
}
