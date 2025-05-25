package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class Docente extends Usuario{
    private static final int MAXDIAS = 15;
    private static final int MAXLIBROS = 30;

    public Docente(String nombreCompleto, String cedula, String correo, String contrasenia) {
        super(nombreCompleto, cedula, correo, contrasenia, TipoUsuario.DOCENTE,MAXDIAS);
    }
}
