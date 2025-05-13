package co.edu.uniquindio.poo;

import java.util.*;

public class Universo {
    private String nombre;
    private List<Lugar> lugares;
    private List<Entidad> entidades;

    public Universo(String nombre) {
        this.nombre = nombre;
        this.lugares = new ArrayList<>();
        this.entidades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    public List<Entidad> getEntidades() {
        return entidades;
    }

    public void setEntidades(List<Entidad> entidades) {
        this.entidades = entidades;
    }
}
