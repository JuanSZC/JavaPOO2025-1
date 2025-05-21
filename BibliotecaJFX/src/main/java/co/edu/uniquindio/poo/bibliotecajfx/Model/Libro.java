package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class Libro {
    private String titulo;
    private String autor;
    private String editorial;
    private String genero;
    private int anio;
    private boolean estaDisponible;
    private TipoLibro tipoLibro;

    public Libro(String titulo, String autor, String editorial, String genero, int anio, boolean estaDisponible, TipoLibro tipoLibro) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.genero = genero;
        this.anio = anio;
        this.estaDisponible = estaDisponible;
        this.tipoLibro = tipoLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstaDisponible() {
        return estaDisponible;
    }

    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    public TipoLibro getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(TipoLibro tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", editorial='" + editorial + '\'' +
                ", genero='" + genero + '\'' +
                ", anio=" + anio +
                ", estaDisponible=" + estaDisponible +
                ", tipoLibro=" + tipoLibro +
                '}';
    }
}