package co.edu.uniquindio.poo.bibliotecajfx.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un bibliotecario, el cual es un tipo de empleado
 * con funciones específicas para gestionar libros y usuarios en la biblioteca.
 */
public class Bibliotecario extends Empleado {

    /**
     * Constructor de la clase Bibliotecario.
     *
     * @param nombreCompleto Nombre completo del bibliotecario.
     * @param cedula         Cédula del bibliotecario.
     * @param contrasenia    Contraseña del bibliotecario.
     * @param biblioteca     Biblioteca a la que está asociado.
     */
    public Bibliotecario(String nombreCompleto, String cedula, String contrasenia, Biblioteca biblioteca) {
        super(nombreCompleto, cedula, contrasenia, TipoTrabajo.BIBLIOTECARIO, biblioteca);
    }

    /**
     * Registra un libro físico en la biblioteca.
     *
     * @param libroFisico Libro físico a registrar.
     */
    public void registrarLibroFisico(LibroFisico libroFisico) {
        this.getBiblioteca().getListLibros().add(libroFisico);
    }

    /**
     * Registra un libro digital en la biblioteca.
     *
     * @param libroDigital Libro digital a registrar.
     */
    public void registrarLibroDigital(LibroDigital libroDigital) {
        this.getBiblioteca().getListLibros().add(libroDigital);
    }

    /**
     * Registra un libro de referencia en la biblioteca.
     *
     * @param libroReferencia Libro de referencia a registrar.
     */
    public void registrarLibroReferencia(LibroReferencia libroReferencia) {
        this.getBiblioteca().getListLibros().add(libroReferencia);
    }

    /**
     * Registra un estudiante como usuario en la biblioteca.
     *
     * @param estudiante Estudiante a registrar.
     */
    public void registrarEstudiante(Estudiante estudiante) {
        if (!this.getBiblioteca().getListUsuarios().contains(estudiante)) {
            this.getBiblioteca().getListUsuarios().add(estudiante);
        } else {
            this.getBiblioteca().mostrarError("Usuario ya registrado");
        }
    }

    /**
     * Registra un docente como usuario en la biblioteca.
     *
     * @param docente Docente a registrar.
     */
    public void registrarDocente(Docente docente) {
        if (!this.getBiblioteca().getListUsuarios().contains(docente)) {
            this.getBiblioteca().getListUsuarios().add(docente);
        } else {
            this.getBiblioteca().mostrarError("Usuario ya registrado");
        }
    }

    /**
     * Realiza el préstamo de un libro a un usuario.
     *
     * @param libro      Libro a prestar.
     * @param usuario    Usuario que realiza el préstamo.
     * @param tiempoDias Número de días de préstamo.
     */
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

    /**
     * Realiza la devolución de un libro previamente prestado.
     *
     * @param reserva Reserva que se desea devolver.
     */
    public void devolverLibro(Reserva reserva) {
        if (this.getBiblioteca().getListReservas().contains(reserva)) {
            reserva.getUsuario().getListReservasUsuario().remove(reserva);
            this.getBiblioteca().getListReservas().remove(reserva);
            reserva.getLibro().setEstaDisponible(true);
        } else {
            this.getBiblioteca().mostrarError("La reserva no existe");
        }
    }

    /**
     * Elimina un usuario de la biblioteca.
     *
     * @param usuario Usuario a eliminar.
     */
    public void removerUsuario(Usuario usuario) {
        this.getBiblioteca().getListUsuarios().remove(usuario);
    }

    /**
     * Modifica los datos de un usuario registrado.
     *
     * @param usuario      Usuario a modificar.
     * @param nombre       Nuevo nombre completo.
     * @param cedula       Nueva cédula.
     * @param correo       Nuevo correo electrónico.
     * @param contrasenia  Nueva contraseña.
     */
    public void modificarUsuario(Usuario usuario, String nombre, String cedula, String correo, String contrasenia) {
        usuario.setNombreCompleto(nombre);
        usuario.setCedula(cedula);
        usuario.setCorreo(correo);
        usuario.setContrasenia(contrasenia);
    }

    /**
     * Modifica los datos de un libro registrado.
     *
     * @param libro           Libro a modificar.
     * @param titulo          Nuevo título.
     * @param autor           Nuevo autor.
     * @param editorial       Nueva editorial.
     * @param genero          Nuevo género.
     * @param anio            Nuevo año de publicación.
     * @param estaDisponible  Disponibilidad del libro.
     */
    public void modificarLibro(Libro libro, String titulo, String autor, String editorial, String genero, int anio, boolean estaDisponible) {
        libro.setTitulo(titulo);
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        libro.setGenero(genero);
        libro.setAnio(anio);
        libro.setEstaDisponible(estaDisponible);
    }

    /**
     * Elimina un libro del sistema de la biblioteca.
     *
     * @param libro Libro a eliminar.
     */
    public void elmininarLibro(Libro libro) {
        this.getBiblioteca().getListLibros().remove(libro);
    }

    /**
     * Obtiene una lista de libros actualmente prestados.
     *
     * @return Lista de libros prestados.
     */
    public List<Libro> obtenerLibrosPrestados() {
        List<Libro> librosPrestados = new ArrayList<>();
        for (Reserva reserva : this.getBiblioteca().getListReservas()) {
            librosPrestados.add(reserva.getLibro());
        }
        return librosPrestados;
    }

    /**
     * Genera un informe con datos generales de la biblioteca.
     *
     * @return Cadena de texto con el informe.
     */
    public String generarInforme() {
        return "INFORME DE DATOS DE LA BIBLIOTECA: \n" +
                "Cantidad de Libros: " + this.getBiblioteca().getListLibros().size() + "\n" +
                "Cantidad de Usuarios: " + this.getBiblioteca().getListUsuarios().size() + "\n" +
                "Cantidad de Reservas: " + this.getBiblioteca().getListReservas().size() + "\n";
    }
}
