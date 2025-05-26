package co.edu.uniquindio.poo.bibliotecajfx.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.bibliotecajfx.Model.*;

import java.util.ArrayList;

class AdministradorTest {

    private Biblioteca biblioteca;
    private Administrador admin;
    private Bibliotecario bibliotecario;
    private Empleado otroEmpleado;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca("Biblioteca",123,"Calle ABC");
        biblioteca.setListEmpleados(new ArrayList<>());
        biblioteca.setListUsuarios(new ArrayList<>());

        admin = new Administrador("Admin Test", "000", "pass", biblioteca);

        bibliotecario = new Bibliotecario("Bib Test", "111", "pass", biblioteca);
        otroEmpleado = new Empleado("Emp Test", "222", "pass", TipoTrabajo.BIBLIOTECARIO, biblioteca);
        usuario = new Usuario("Usuario Test", "333", "pass","pass" +
                "",TipoUsuario.DOCENTE,10,10,biblioteca);

        //Inicialmente, añadir un empleado para pruebas
        biblioteca.getListEmpleados().add(otroEmpleado);
        biblioteca.getListUsuarios().add(usuario);
    }

    @Test
    void testAgregarBibliotecario_noExiste() {
        admin.agregarBibliotecario(bibliotecario);
        assertTrue(biblioteca.getListEmpleados().contains(bibliotecario));
    }

    @Test
    void testAgregarBibliotecario_yaExiste() {
        biblioteca.getListEmpleados().add(bibliotecario);
        admin.agregarBibliotecario(bibliotecario);
        // Se espera que no se agregue doble, la lista sólo tenga 1
        assertEquals(1, biblioteca.getListEmpleados().stream()
                .filter(e -> e.equals(bibliotecario)).count());
    }

    @Test
    void testAgregarAdministrador_noExiste() {
        Administrador nuevoAdmin = new Administrador("Nuevo Admin", "444", "pass", biblioteca);
        admin.agregarAdministrador(nuevoAdmin);
        assertTrue(biblioteca.getListEmpleados().contains(nuevoAdmin));
    }

    @Test
    void testAgregarAdministrador_yaExiste() {
        Administrador nuevoAdmin = new Administrador("Nuevo Admin", "444", "pass", biblioteca);
        biblioteca.getListEmpleados().add(nuevoAdmin);
        admin.agregarAdministrador(nuevoAdmin);
        assertEquals(1, biblioteca.getListEmpleados().stream()
                .filter(e -> e.equals(nuevoAdmin)).count());
    }

    @Test
    void testRemoverEmpleado_existe() {
        admin.removerEmpleado(otroEmpleado);
        assertFalse(biblioteca.getListEmpleados().contains(otroEmpleado));
    }

    @Test
    void testRemoverEmpleado_noExiste() {
        Empleado noExiste = new Empleado("No Exist", "555", "pass", TipoTrabajo.BIBLIOTECARIO, biblioteca);
        admin.removerEmpleado(noExiste);
        // Como no existe no se remueve, lista mantiene tamaño original
        assertTrue(biblioteca.getListEmpleados().contains(otroEmpleado));
    }

    @Test
    void testCompararCredencialesEmpleados_correctas() {
        assertTrue(admin.compararCredencialesEmpleados("222", "pass"));
    }

    @Test
    void testCompararCredencialesEmpleados_incorrectas() {
        assertFalse(admin.compararCredencialesEmpleados("222", "wrong"));
        assertFalse(admin.compararCredencialesEmpleados("999", "pass"));
    }

    @Test
    void testObtenerCredencialesEmpleados_existe() {
        Empleado emp = admin.obtenerCredencialesEmpleados("222");
        assertNotNull(emp);
        assertEquals("222", emp.getCedula());
    }

    @Test
    void testObtenerCredencialesEmpleados_noExiste() {
        Empleado emp = admin.obtenerCredencialesEmpleados("999");
        assertNull(emp);
    }

    @Test
    void testObtenerCredencialesUsuarios_existe() {
        Usuario usr = admin.obtenerCredencialesUsuarios("333");
        assertNotNull(usr);
        assertEquals("333", usr.getCedula());
    }

    @Test
    void testObtenerCredencialesUsuarios_noExiste() {
        Usuario usr = admin.obtenerCredencialesUsuarios("999");
        assertNull(usr);
    }

    @Test
    void testCompararCredencialesUsuarios_correctas() {
        assertTrue(admin.compararCredencialesUsuarios("333", "pass"));
    }

    @Test
    void testCompararCredencialesUsuarios_incorrectas() {
        assertFalse(admin.compararCredencialesUsuarios("333", "wrong"));
        assertFalse(admin.compararCredencialesUsuarios("999", "pass"));
    }

    @Test
    void testModificarEmpleado() {
        admin.modificarEmpleado(otroEmpleado, "Nuevo Nombre", "999", "newpass");
        assertEquals("Nuevo Nombre", otroEmpleado.getNombreCompleto());
        assertEquals("999", otroEmpleado.getCedula());
        assertEquals("newpass", otroEmpleado.getContrasenia());
    }

    @Test
    void testGenerarInformeAvanzado() {
        String informe = admin.generarInformeAvanzado();
        assertTrue(informe.contains("Cantidad de Empleados"));
        assertTrue(informe.contains(String.valueOf(biblioteca.getListEmpleados().size())));
    }
}
