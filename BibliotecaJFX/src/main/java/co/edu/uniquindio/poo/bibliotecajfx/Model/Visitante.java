package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class Visitante {
    private String nombreTemporal;

    public Visitante(String nombreTemporal) {
        this.nombreTemporal = nombreTemporal;
    }

    public String getNombreTemporal() {
        return nombreTemporal;
    }

    public void setNombreTemporal(String nombreTemporal) {
        this.nombreTemporal = nombreTemporal;
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "nombreTemporal='" + nombreTemporal + '\'' +
                '}';
    }
}
