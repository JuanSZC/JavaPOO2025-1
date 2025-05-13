package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.List;

public abstract class Entidad {
    private String nombre;
    private List<Habilidad> habilidades;

    public Entidad(String nombre) {
        this.nombre = nombre;
        this.habilidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    public void agregarHabilidad(Habilidad habilidad) {
        this.habilidades.add(habilidad);
    }

    public abstract String descripcion();

}