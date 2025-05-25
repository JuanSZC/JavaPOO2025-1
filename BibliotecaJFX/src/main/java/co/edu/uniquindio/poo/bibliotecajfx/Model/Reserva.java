package co.edu.uniquindio.poo.bibliotecajfx.Model;

import java.time.LocalDate;

/**
 * Representa una reserva de un libro realizada por un usuario durante un tiempo determinado.
 *
 * <p>Contiene información sobre el libro reservado, el usuario que realiza la reserva,
 * el tiempo en días que durará la reserva y la fecha en que se hizo la reserva.</p>
 *
 * @author
 */
public class Reserva {

    /**
     * Libro reservado.
     */
    private Libro libro;

    /**
     * Usuario que realiza la reserva.
     */
    private Usuario usuario;

    /**
     * Tiempo en días que dura la reserva.
     */
    private int tiempoDias;

    /**
     * Fecha en que se hizo la reserva.
     */
    private LocalDate fecha;

    /**
     * Construye una reserva con la información del libro, usuario, tiempo y fecha.
     *
     * @param libro Libro reservado.
     * @param usuario Usuario que hace la reserva.
     * @param tiempoDias Duración de la reserva en días.
     * @param fecha Fecha en que se realiza la reserva.
     */
    public Reserva(Libro libro, Usuario usuario, int tiempoDias, LocalDate fecha) {
        this.libro = libro;
        this.usuario = usuario;
        this.tiempoDias = tiempoDias;
        this.fecha = fecha;
    }

    /**
     * Obtiene el libro reservado.
     *
     * @return Libro reservado.
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Establece el libro reservado.
     *
     * @param libro Libro reservado.
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * Obtiene el usuario que hizo la reserva.
     *
     * @return Usuario de la reserva.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que hizo la reserva.
     *
     * @param usuario Usuario de la reserva.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el tiempo en días de la reserva.
     *
     * @return Tiempo en días.
     */
    public int getTiempoDias() {
        return tiempoDias;
    }

    /**
     * Establece el tiempo en días de la reserva.
     *
     * @param tiempoDias Tiempo en días.
     */
    public void setTiempoDias(int tiempoDias) {
        this.tiempoDias = tiempoDias;
    }

    /**
     * Obtiene la fecha en que se realizó la reserva.
     *
     * @return Fecha de la reserva.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó la reserva.
     *
     * @param fecha Fecha de la reserva.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna una representación en cadena con la información principal de la reserva.
     *
     * @return Cadena con detalles de la reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" +
                "libro=" + libro.getTitulo() +
                ", usuario=" + usuario.getNombreCompleto() +
                ", tiempoDias=" + tiempoDias +
                ", fecha=" + fecha +
                '}';
    }
}
