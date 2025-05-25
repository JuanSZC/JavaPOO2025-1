package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class LibroFisico extends Libro {

    private boolean estaDisponible;
    public LibroFisico(String titulo, String autor, String editorial, String genero, int anio,boolean estaDisponible) {
        super(titulo, autor, editorial, genero, anio,estaDisponible,TipoLibro.FISICO);



    }




}
