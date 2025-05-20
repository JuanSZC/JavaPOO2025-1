package co.edu.uniquindio.poo.bibliotecajfx.Controller;

import co.edu.uniquindio.poo.bibliotecajfx.Model.Libro;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Reserva;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Usuario;

import java.time.LocalDate;

public class UsuarioController {
    private final Usuario usuario;

    public UsuarioController(Usuario usuario) {
        this.usuario = usuario;
    }

    public void solicitarPrestamoLibro(Libro libro, int dias){
        usuario.solicitarPrestamoLibro(libro,dias);
    }

}
