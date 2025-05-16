package co.edu.uniquindio.poo.bibliotecajfx.Model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String nombre;
    private int nit;
    private String direccion;
    private List<Empleado> listEmpleados;
    private List<Usuario> listUsuarios;
    private List<Libro> listLibros;
    private List<Visitante> listVisitantes;
    private List<Reserva> listReservas;

    public Biblioteca(String nombre, int nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.listEmpleados = new ArrayList<Empleado>();
        this.listUsuarios = new ArrayList<Usuario>();
        this.listLibros =  new ArrayList<>();
        this.listVisitantes = new ArrayList<>();
        this.listReservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Reserva> getListReservas() {
        return listReservas;
    }

    public void setListReservas(List<Reserva> listReservas) {
        this.listReservas = listReservas;
    }

    public List<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(List<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }

    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    public List<Libro> getListLibros() {
        return listLibros;
    }

    public void setListLibros(List<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    public List<Visitante> getListVisitantes() {
        return listVisitantes;
    }

    public void setListVisitantes(List<Visitante> listVisitantes) {
        this.listVisitantes = listVisitantes;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "nombre='" + nombre + '\'' +
                ", nit=" + nit +
                ", direccion='" + direccion + '\'' +
                ", listEmpleados=" + listEmpleados +
                ", listUsuarios=" + listUsuarios +
                ", listLibros=" + listLibros +
                ", listVisitantes=" + listVisitantes +
                ", listReservas=" + listReservas +
                '}';
    }
}
