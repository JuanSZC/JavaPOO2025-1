package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Empleado;
import co.edu.uniquindio.poo.bibliotecajfx.Model.TipoTrabajo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controlador para la pantalla de credenciales del empleado.
 * Gestiona la autenticación del empleado y la navegación según el tipo de trabajo.
 */
public class PantallaCredencialesEmpleadoViewController {

    /**
     * Referencia a la clase principal de la aplicación para navegación entre pantallas.
     */
    private App app;

    /**
     * Controlador que maneja la lógica del administrador.
     */
    private AdministradorController administradorController;

    /**
     * Botón para iniciar sesión.
     */
    @FXML
    private Button btIniciarSesion;

    /**
     * Campo de texto para ingresar la cédula del empleado.
     */
    @FXML
    private TextField tfCedula;

    /**
     * Campo para ingresar la contraseña del empleado.
     */
    @FXML
    private PasswordField pfContrasenia;

    /**
     * Establece la referencia a la instancia principal de la aplicación.
     * @param app instancia principal de la aplicación
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Establece la referencia al controlador administrador.
     * @param administradorController controlador administrador
     */
    public void setAdministradorController(AdministradorController administradorController) {
        this.administradorController = administradorController;
    }

    /**
     * Intenta iniciar sesión con las credenciales ingresadas.
     * Si las credenciales son válidas, navega a la pantalla correspondiente
     * según el tipo de trabajo del empleado.
     *
     * @return el objeto Empleado si la autenticación es exitosa; null en caso contrario
     */
    @FXML
    public Empleado iniciarSesionEmpleado() {
        String cedula = tfCedula.getText();
        String contrasenia = pfContrasenia.getText();

        if (administradorController.validarCredencialesEmpleado(cedula, contrasenia)) {
            openPantallaEmpleado(administradorController.obtenerEmpleado(cedula));
            return administradorController.obtenerEmpleado(cedula);
        }
        return null;
    }

    /**
     * Navega a la pantalla de bienvenida.
     */
    public void openPantallaBienvenida() {
        app.openPantallaBienvenida();
    }

    /**
     * Navega a la pantalla correspondiente según el tipo de trabajo del empleado.
     *
     * @param empleado empleado autenticado
     */
    public void openPantallaEmpleado(Empleado empleado) {
        if (empleado.getTipoTrabajo() == TipoTrabajo.ADMINISTRADOR) {
            app.openPantallaAdministrador();
        } else if (empleado.getTipoTrabajo() == TipoTrabajo.BIBLIOTECARIO) {
            app.openPantallaBibliotecario();
        }
    }
}
