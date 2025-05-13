package co.edu.uniquindio.poo;

import java.util.*;

public class Humano extends Entidad {


    public Humano(String nombre) {
        super(nombre, habilidades);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<Habilidad> habilidades) {
        this.habilidades = new ArrayList<>();
    }

    @Override
    public String descripcion(){
        return "Descripcion del Humano: " + nombre + ". Set de habilidades: " + habilidades;
    }

}
