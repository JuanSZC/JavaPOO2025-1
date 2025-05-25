package co.edu.uniquindio.poo.bibliotecajfx.Model;

/**
 * Representa un visitante temporal a la biblioteca con un nombre asignado temporalmente.
 *
 * <p>Esta clase es útil para manejar usuarios que no están registrados
 * pero que interactúan con la biblioteca.</p>
 *
 * @author
 */
public class Visitante {

    /**
     * Nombre temporal asignado al visitante.
     */
    private String nombreTemporal;

    /**
     * Construye un visitante con un nombre temporal específico.
     *
     * @param nombreTemporal Nombre temporal del visitante.
     */
    public Visitante(String nombreTemporal) {
        this.nombreTemporal = nombreTemporal;
    }

    /**
     * Obtiene el nombre temporal del visitante.
     *
     * @return Nombre temporal.
     */
    public String getNombreTemporal() {
        return nombreTemporal;
    }

    /**
     * Establece el nombre temporal del visitante.
     *
     * @param nombreTemporal Nuevo nombre temporal.
     */
    public void setNombreTemporal(String nombreTemporal) {
        this.nombreTemporal = nombreTemporal;
    }

    /**
     * Retorna una representación en cadena con el nombre temporal del visitante.
     *
     * @return Cadena con la información del visitante.
     */
    @Override
    public String toString() {
        return "Visitante{" +
                "nombreTemporal='" + nombreTemporal + '\'' +
                '}';
    }
}
