    package co.edu.uniquindio.poo.bibliotecajfx.Model;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.*;

    public class EstudianteTest {

        private Biblioteca biblioteca;
        private Estudiante estudiante;

        @BeforeEach
        public void setUp() {
            biblioteca = new Biblioteca("Biblioteca Central", 123, "Calle Principal");
            estudiante = new Estudiante("Juan Estudiante", "123456789", "juan@email.com", "clave123", biblioteca);
        }

        @Test
        public void testGetTipoUsuario() {
            assertEquals(TipoUsuario.ESTUDIANTE, estudiante.getTipoUsuario());
        }

        @Test
        public void testGetMaxDias() {
            assertEquals(5, estudiante.getMaxDias());
        }

        @Test
        public void testGetMaxLibros() {
            assertEquals(10, estudiante.getMaxReservas());
        }

        @Test
        public void testGetNombreCompleto() {
            assertEquals("Juan Estudiante", estudiante.getNombreCompleto());
        }

        @Test
        public void testGetCedula() {
            assertEquals("123456789", estudiante.getCedula());
        }

        @Test
        public void testGetCorreo() {
            assertEquals("juan@email.com", estudiante.getCorreo());
        }

        @Test
        public void testGetContrasenia() {
            assertEquals("clave123", estudiante.getContrasenia());
        }

        @Test
        public void testGetBiblioteca() {
            assertEquals(biblioteca, estudiante.getBiblioteca());
        }

        @Test
        public void testToStringContieneNombre() {
            assertTrue(estudiante.toString().contains("Juan Estudiante"));
        }
    }
