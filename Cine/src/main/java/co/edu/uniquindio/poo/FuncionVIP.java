package co.edu.uniquindio.poo;

public class FuncionVIP extends Funcion{
    private boolean tieneAsiento;
    private boolean tieneServicioComida;

    public FuncionVIP(String tituloPelicula, int duracionPelicula, String horario, int precioBase, boolean tieneAsiento, boolean tieneServicioComida) {
        super(tituloPelicula, duracionPelicula, horario, precioBase);
        this.tieneAsiento = tieneAsiento;
        this.tieneServicioComida = tieneServicioComida;
    }

    @Override
    public int calcularPrecio() {
        int precioFinal = getPrecioBase();

        if (tieneServicioComida) {
            precioFinal += 5000;
        }
        if (tieneAsiento) {
            precioFinal += 5000;
        }
        return precioFinal;
    }


    public boolean isTieneAsiento() {
        return tieneAsiento;
    }

    public void setTieneAsiento(boolean tieneAsiento) {
        this.tieneAsiento = tieneAsiento;
    }

    public boolean isTieneServicioComida() {
        return tieneServicioComida;
    }

    public void setTieneServicioComida(boolean tieneServicioComida) {
        this.tieneServicioComida = tieneServicioComida;
    }



}
