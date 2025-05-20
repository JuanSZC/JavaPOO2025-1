package co.edu.uniquindio.poo.bibliotecajfx.Controller;

import co.edu.uniquindio.poo.bibliotecajfx.Model.*;

import java.util.List;

public class BibliotecarioController {

    private final Bibliotecario bibliotecario;

    public BibliotecarioController(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public void registrarLibroFisico(String titulo, String autor, String editorial, String genero, int anio, boolean estaDisponible) {
        LibroFisico nuevoLibro = new LibroFisico(titulo, autor,editorial,genero,anio,estaDisponible);
        bibliotecario.registrarLibroFisico(nuevoLibro);
    }
    public void registrarLibroDigital(String titulo, String autor, String editorial, String genero, int anio,boolean estaDisponible, FormatoDigital formatoDigital, String enlaceDescarga){
        LibroDigital nuevoLibro = new LibroDigital(titulo, autor, editorial, genero, anio, estaDisponible, formatoDigital, enlaceDescarga);
        bibliotecario.registrarLibroDigital(nuevoLibro);
    }
    public void registrarLibroReferencia(String titulo, String autor, String editorial, String genero, int anio){
        LibroReferencia libroNuevo = new LibroReferencia(titulo, autor,editorial,genero,anio);
        bibliotecario.registrarLibroReferencia(libroNuevo);
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
