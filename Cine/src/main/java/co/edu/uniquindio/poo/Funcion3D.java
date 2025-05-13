package co.edu.uniquindio.poo;

public class Funcion3D extends Funcion{
    public Funcion3D(String tituloPelicula, int duracionPelicula, String horario, int precioBase) {
        super(tituloPelicula, duracionPelicula, horario, precioBase);
    }

    @Override
    public int calcularPrecio() {
        int exp3D = 2000;
        return getPrecioBase() + exp3D;
    }

}
