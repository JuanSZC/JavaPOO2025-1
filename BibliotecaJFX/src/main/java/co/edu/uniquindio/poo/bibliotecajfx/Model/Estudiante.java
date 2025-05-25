package co.edu.uniquindio.poo.bibliotecajfx.Model;

public class Estudiante extends Usuario{
    private static final int MAXDIAS = 5;
    private static final int MAXLIBROS = 10;

    public Estudiante(String nombreCompleto, String cedula, String correo, String contrasenia) {
        super(nombreCompleto, cedula, correo, contrasenia, TipoUsuario.ESTUDIANTE,MAXDIAS);
    }

}
