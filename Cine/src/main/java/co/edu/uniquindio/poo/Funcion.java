package co.edu.uniquindio.poo;

public abstract class Funcion {

    private String tituloPelicula;
    private int duracionPelicula;
    private String horario;
    private int precioBase;

    public Funcion(String tituloPelicula, int duracionPelicula, String horario, int precioBase) {
        this.tituloPelicula = tituloPelicula;
        this.duracionPelicula = duracionPelicula;
        this.horario = horario;
        this.precioBase = precioBase;
    }

    public abstract int calcularPrecio();

    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public int getDuracionPelicula() {
        return duracionPelicula;
    }

    public void setDuracionPelicula(int duracionPelicula) {
        this.duracionPelicula = duracionPelicula;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }
}
