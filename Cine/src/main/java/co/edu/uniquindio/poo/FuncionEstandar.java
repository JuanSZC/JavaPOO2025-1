package co.edu.uniquindio.poo;

public class FuncionEstandar extends Funcion {

    public FuncionEstandar(String tituloPelicula, int duracionPelicula, String horario, int precioBase) {
        super(tituloPelicula, duracionPelicula, horario, precioBase);
    }

    @Override
    public int calcularPrecio() {
        return  getPrecioBase();
    }

}
