package co.edu.uniquindio.poo.bibliotecajfx.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un usuario del sistema de biblioteca, ya sea estudiante o docente.
 * Un usuario puede solicitar préstamos de libros y tiene restricciones según su tipo.
 */
public class Usuario {

    private String nombreCompleto;
    private String cedula;
    private String correo;
    private String contrasenia;
    private TipoUsuario tipoUsuario;
    private int MaxDias;
    private int MaxReservas;
    private Biblioteca biblioteca;
    private List<Reserva> listReservasUsuario;

    /**
     * Constructor para crear un usuario.
     *
     * @param nombreCompleto Nombre completo del usuario.
     * @param cedula         Cédula de identidad del usuario.
     * @param correo         Correo electrónico del usuario.
     * @param contrasenia    Contraseña del usuario.
     * @param tipoUsuario    Tipo de usuario (ESTUDIANTE o DOCENTE).
     * @param MaxDias        Máximo número de días para préstamo.
     * @param MaxReservas    Máximo número de libros que puede reservar.
     * @param biblioteca     Biblioteca asociada al usuario.
     */
    public Usuario(String nombreCompleto, String cedula, String correo, String contrasenia,
                   TipoUsuario tipoUsuario, int MaxDias, int MaxReservas, Biblioteca biblioteca) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.correo = correo;
        this.contrasenia = contrasenia;
        this.tipoUsuario = tipoUsuario;
        this.listReservasUsuario = new ArrayList<>();
        this.MaxDias = MaxDias;
        this.MaxReservas = MaxReservas;
        this.biblioteca = biblioteca;
    }

    /**
     * Solicita un préstamo de un libro específico por cierta cantidad de días.
     *
     * @param libro Libro que se desea prestar.
     * @param dias  Cantidad de días del préstamo.
     */
    public void solicitarPrestamoLibro(Libro libro, int dias) {
        LocalDate fecha = LocalDate.now();
        Reserva reserva = new Reserva(libro, this, dias, fecha);
        this.listReservasUsuario.add(reserva);
        this.biblioteca.getListReservas().add(reserva);
    }

    // === Getters y Setters ===

    /**
     * @return Nombre completo del usuario.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del usuario.
     * @param nombreCompleto Nuevo nombre completo.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return Cédula del usuario.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del usuario.
     * @param cedula Nueva cédula.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * @return Correo electrónico del usuario.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param correo Nuevo correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return Contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasenia Nueva contraseña.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * @return Tipo de usuario (ESTUDIANTE o DOCENTE).
     */
    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     * @param tipoUsuario Tipo de usuario a asignar.
     */
    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * @return Máximo número de días permitidos para préstamo.
     */
    public int getMaxDias() {
        return MaxDias;
    }

    /**
     * Establece el máximo de días permitidos para préstamo.
     * @param maxDias Número de días.
     */
    public void setMaxDias(int maxDias) {
        MaxDias = maxDias;
    }

    /**
     * @return Máximo número de reservas que puede hacer el usuario.
     */
    public int getMaxReservas() {
        return MaxReservas;
    }

    /**
     * Establece el máximo de reservas.
     * @param maxReservas Número máximo de reservas.
     */
    public void setMaxReservas(int maxReservas) {
        MaxReservas = maxReservas;
    }

    /**
     * @return Biblioteca asociada al usuario.
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * Establece la biblioteca asociada al usuario.
     * @param biblioteca Biblioteca a asignar.
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * @return Lista de reservas activas realizadas por el usuario.
     */
    public List<Reserva> getListReservasUsuario() {
        return listReservasUsuario;
    }

    /**
     * Establece la lista de reservas del usuario.
     * @param listReservasUsuario Lista nueva de reservas.
     */
    public void setListReservasUsuario(List<Reserva> listReservasUsuario) {
        this.listReservasUsuario = listReservasUsuario;
    }

    /**
     * Devuelve una representación en texto del usuario.
     *
     * @return Cadena que describe el estado del usuario.
     */
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
