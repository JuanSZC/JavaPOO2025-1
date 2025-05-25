package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Representa un empleado en la biblioteca, con información personal
 * y su tipo de trabajo asociado.
 */
public class Empleado {

    /**
     * Nombre completo del empleado.
     */
    private String nombreCompleto;

    /**
     * Número de cédula del empleado.
     */
    private String cedula;

    /**
     * Contraseña del empleado.
     */
    private String Contrasenia;

    /**
     * Tipo de trabajo que realiza el empleado.
     */
    private TipoTrabajo tipoTrabajo;

    /**
     * Biblioteca a la que pertenece el empleado.
     */
    private Biblioteca biblioteca;

    /**
     * Constructor que inicializa un empleado con todos sus datos.
     *
     * @param nombreCompleto Nombre completo del empleado.
     * @param cedula Número de cédula del empleado.
     * @param contrasenia Contraseña del empleado.
     * @param tipoTrabajo Tipo de trabajo asignado al empleado.
     * @param biblioteca Biblioteca a la que está asociado el empleado.
     */
    public Empleado(String nombreCompleto, String cedula, String contrasenia, TipoTrabajo tipoTrabajo, Biblioteca biblioteca) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.Contrasenia = contrasenia;
        this.tipoTrabajo = tipoTrabajo;
        this.biblioteca = biblioteca;
    }

    /**
     * Obtiene el nombre completo del empleado.
     *
     * @return Nombre completo.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del empleado.
     *
     * @param nombreCompleto Nuevo nombre completo.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene la cédula del empleado.
     *
     * @return Número de cédula.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del empleado.
     *
     * @param cedula Nuevo número de cédula.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene la contraseña del empleado.
     *
     * @return Contraseña.
     */
    public String getContrasenia() {
        return Contrasenia;
    }

    /**
     * Establece la contraseña del empleado.
     *
     * @param contrasenia Nueva contraseña.
     */
    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }

    /**
     * Obtiene el tipo de trabajo del empleado.
     *
     * @return Tipo de trabajo.
     */
    public TipoTrabajo getTipoTrabajo() {
        return tipoTrabajo;
    }

    /**
     * Establece el tipo de trabajo del empleado.
     *
     * @param tipoTrabajo Nuevo tipo de trabajo.
     */
    public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
        this.tipoTrabajo = tipoTrabajo;
    }

    /**
     * Obtiene la biblioteca a la que pertenece el empleado.
     *
     * @return Biblioteca asociada.
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    /**
     * Establece la biblioteca a la que pertenece el empleado.
     *
     * @param biblioteca Nueva biblioteca asociada.
     */
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * Representación en texto del empleado.
     *
     * @return Cadena con información del empleado.
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", cedula=" + cedula +
                ", Contrasenia='" + Contrasenia + '\'' +
                ", tipoTrabajo=" + tipoTrabajo +
                ", biblioteca=" + biblioteca.getNombre() +
                '}';
    }
}
