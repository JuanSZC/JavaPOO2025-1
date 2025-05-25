package co.edu.uniquindio.poo.bibliotecajfx.Model;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una biblioteca que contiene empleados, usuarios, libros, visitantes y reservas.
 */
public class Biblioteca {

    private String nombre;
    private int nit;
    private String direccion;
    private List<Empleado> listEmpleados;
    private List<Usuario> listUsuarios;
    private List<Libro> listLibros;
    private List<Visitante> listVisitantes;
    private List<Reserva> listReservas;

    /**
     * Crea una nueva instancia de Biblioteca.
     *
     * @param nombre    Nombre de la biblioteca.
     * @param nit       Número de identificación tributaria (NIT) de la biblioteca.
     * @param direccion Dirección física de la biblioteca.
     */
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

    /**
     * Muestra un mensaje de error mediante una ventana emergente.
     *
     * @param error Mensaje de error a mostrar.
     */
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Obtiene el nombre de la biblioteca.
     *
     * @return Nombre de la biblioteca.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la biblioteca.
     *
     * @param nombre Nombre de la biblioteca.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el NIT de la biblioteca.
     *
     * @return NIT de la biblioteca.
     */
    public int getNit() {
        return nit;
    }

    /**
     * Establece el NIT de la biblioteca.
     *
     * @param nit NIT de la biblioteca.
     */
    public void setNit(int nit) {
        this.nit = nit;
    }

    /**
     * Obtiene la dirección de la biblioteca.
     *
     * @return Dirección de la biblioteca.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección de la biblioteca.
     *
     * @param direccion Dirección de la biblioteca.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene la lista de reservas registradas en la biblioteca.
     *
     * @return Lista de reservas.
     */
    public List<Reserva> getListReservas() {
        return listReservas;
    }

    /**
     * Establece la lista de reservas de la biblioteca.
     *
     * @param listReservas Lista de reservas.
     */
    public void setListReservas(List<Reserva> listReservas) {
        this.listReservas = listReservas;
    }

    /**
     * Obtiene la lista de empleados registrados en la biblioteca.
     *
     * @return Lista de empleados.
     */
    public List<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    /**
     * Establece la lista de empleados de la biblioteca.
     *
     * @param listEmpleados Lista de empleados.
     */
    public void setListEmpleados(List<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }

    /**
     * Obtiene la lista de usuarios registrados en la biblioteca.
     *
     * @return Lista de usuarios.
     */
    public List<Usuario> getListUsuarios() {
        return listUsuarios;
    }

    /**
     * Establece la lista de usuarios de la biblioteca.
     *
     * @param listUsuarios Lista de usuarios.
     */
    public void setListUsuarios(List<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
    }

    /**
     * Obtiene la lista de libros disponibles en la biblioteca.
     *
     * @return Lista de libros.
     */
    public List<Libro> getListLibros() {
        return listLibros;
    }

    /**
     * Establece la lista de libros de la biblioteca.
     *
     * @param listLibros Lista de libros.
     */
    public void setListLibros(List<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    /**
     * Obtiene la lista de visitantes que han ingresado a la biblioteca.
     *
     * @return Lista de visitantes.
     */
    public List<Visitante> getListVisitantes() {
        return listVisitantes;
    }

    /**
     * Establece la lista de visitantes de la biblioteca.
     *
     * @param listVisitantes Lista de visitantes.
     */
    public void setListVisitantes(List<Visitante> listVisitantes) {
        this.listVisitantes = listVisitantes;
    }

    /**
     * Devuelve una representación en cadena del objeto Biblioteca.
     *
     * @return Representación en forma de texto del objeto.
     */
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
