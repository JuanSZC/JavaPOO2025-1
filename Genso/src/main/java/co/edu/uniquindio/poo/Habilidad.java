package co.edu.uniquindio.poo;

public class Habilidad {
    private String nombre;

    public Habilidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String infoHabilidad() {
        return "Habilidades para manipular y/o usar" + nombre;
    }

}
