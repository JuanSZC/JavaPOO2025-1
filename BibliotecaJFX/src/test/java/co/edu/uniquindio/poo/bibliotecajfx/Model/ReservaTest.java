package co.edu.uniquindio.poo.bibliotecajfx.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaTest {

    private Libro libro;
    private Usuario usuario;
    private Reserva reserva;

    @BeforeEach
    public void setUp() {
        Biblioteca Biblioteca = new Biblioteca("Biblioteca", 123, "Calle ABC");
        libro = new Libro(
                "Programación en Java",
                "Autor Ejemplo",
                "Editorial XYZ",
                "Tecnología",
                2022,
                true,
                TipoLibro.FISICO
        );

        // Usuario simulado mediante clase anónima
        usuario = new Usuario("Carlos Pérez", "987654321", "carlos@mail.com", "clave456", TipoUsuario.ESTUDIANTE,5,5,Biblioteca) {
            @Override
            public TipoUsuario getTipoUsuario() {
                return TipoUsuario.ESTUDIANTE;
            }

            @Override
            public int getMaxDias() {
                return 5;
            }

            @Override
            public int getMaxReservas() {
                return 3;
            }
        };

        reserva = new Reserva(libro, usuario, 7, LocalDate.of(2024, 5, 20));
    }

    @Test
    public void testGetLibro() {
        assertEquals(libro, reserva.getLibro());
    }

    @Test
    public void testSetLibro() {
        Libro nuevoLibro = new Libro("Nuevo Título", "Nuevo Autor", "Nueva Editorial", "Ciencia", 2021, true, TipoLibro.FISICO);
        reserva.setLibro(nuevoLibro);
        assertEquals(nuevoLibro, reserva.getLibro());
    }

    @Test
    public void testGetUsuario() {
        assertEquals(usuario, reserva.getUsuario());
    }

    @Test
    public void testSetUsuario() {
        Usuario nuevoUsuario = new Usuario("Ana Gómez", "123987456", "ana@mail.com", "clave789", TipoUsuario.ESTUDIANTE,10,5,null) {
            @Override
            public TipoUsuario getTipoUsuario() {
                return TipoUsuario.DOCENTE;
            }

            @Override
            public int getMaxDias() {
                return 10;
            }

            @Override
            public int getMaxReservas() {
                return 5;
            }
        };
        reserva.setUsuario(nuevoUsuario);
        assertEquals(nuevoUsuario, reserva.getUsuario());
    }

    @Test
    public void testGetTiempoDias() {
        assertEquals(7, reserva.getTiempoDias());
    }

    @Test
    public void testSetTiempoDias() {
        reserva.setTiempoDias(10);
        assertEquals(10, reserva.getTiempoDias());
    }

    @Test
    public void testGetFecha() {
        assertEquals(LocalDate.of(2024, 5, 20), reserva.getFecha());
    }

    @Test
    public void testSetFecha() {
        LocalDate nuevaFecha = LocalDate.of(2024, 6, 1);
        reserva.setFecha(nuevaFecha);
        assertEquals(nuevaFecha, reserva.getFecha());
    }

    @Test
    public void testToStringContieneDatos() {
        String resultado = reserva.toString();
        assertTrue(resultado.contains("Programación en Java"));
        assertTrue(resultado.contains("Carlos Pérez"));
        assertTrue(resultado.contains("7"));
        assertTrue(resultado.contains("2024-05-20"));
    }
}
