package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * Controlador para la pantalla de credenciales de usuario.
 * Permite al usuario autenticarse y navegar a la pantalla principal de usuario.
 */
public class PantallaCredencialesUsuarioViewController {

    /**
     * Referencia a la clase principal de la aplicación para manejar navegación.
     */
    private App app;

    /**
     * Controlador que maneja la lógica administrativa y la validación de usuarios.
     */
    private AdministradorController administradorController;

    /**
     * Botón para iniciar sesión.
     */
    @FXML
    private Button btIniciarSesion;

    /**
     * Campo de texto para ingresar la cédula del usuario.
     */
    @FXML
    private TextField tfCedula;

    /**
     * Campo de texto para ingresar la contraseña del usuario.
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
     * Intenta iniciar sesión con las credenciales ingresadas.
     * Si las credenciales son válidas, guarda el usuario en sesión y abre la pantalla principal de usuario.
     *
     * @return el objeto Usuario si la autenticación es exitosa; null en caso contrario
     */
    @FXML
    public Usuario iniciarSesionUsuario() {
        String cedula = tfCedula.getText();
        String contrasenia = pfContrasenia.getText();

        if (administradorController.validadCredencialesUsuario(cedula, contrasenia)) {
            Usuario usuario = administradorController.obtenerUsuario(cedula);
            app.setUsuarioSesion(usuario);
            openPantallaUsuario(usuario);
            return usuario;
        }
        return null;
    }

    /**
     * Navega a la pantalla principal de usuario.
     *
     * @param usuario usuario autenticado
     */
    public void openPantallaUsuario(Usuario usuario) {
        app.openPantallaUsuario();
    }

    /**
     * Establece el controlador administrador.
     *
     * @param administradorController controlador administrador
     */
    public void setAdministradorController(AdministradorController administradorController) {
        this.administradorController = administradorController;
    }

    /**
     * Navega a la pantalla de bienvenida.
     */
    public void openPantallaBienvenida() {
        app.openPantallaBienvenida();
    }

}
