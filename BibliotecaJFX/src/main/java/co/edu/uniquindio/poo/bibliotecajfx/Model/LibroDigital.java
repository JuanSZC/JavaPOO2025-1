package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class LibroDigital extends Libro{
    private FormatoDigital formatoDigital;
    private String enlaceDescarga;

    public LibroDigital(String titulo, String autor, String editorial, String genero, int anio, FormatoDigital formatoDigital, String enlaceDescarga,boolean disponible) {
        super(titulo, autor, editorial, genero, anio,disponible,TipoLibro.DIGITAL);
        this.formatoDigital = formatoDigital;
        this.enlaceDescarga = enlaceDescarga;
    }

    public FormatoDigital getFormatoDigital() {
        return formatoDigital;
    }

    public void setFormatoDigital(FormatoDigital formatoDigital) {
        this.formatoDigital = formatoDigital;
    }

    public String getEnlaceDescarga() {
        return enlaceDescarga;
    }

    public void setEnlaceDescarga(String enlaceDescarga) {
        this.enlaceDescarga = enlaceDescarga;
    }

    @Override
    public String toString() {
        return super.toString() + "LibroDigital{" +
                "formatoDigital=" + formatoDigital +
                ", enlaceDescarga='" + enlaceDescarga + '\'' +
                '}';
    }
}
