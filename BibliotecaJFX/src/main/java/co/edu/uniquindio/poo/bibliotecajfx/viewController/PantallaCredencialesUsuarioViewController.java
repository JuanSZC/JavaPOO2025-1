package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Empleado;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PantallaCredencialesUsuarioViewController {
    App app;
    private AdministradorController administradorController;

    @FXML
    private Button btIniciarSesion;
    @FXML
    private TextField tfCedula;
    @FXML
    private PasswordField pfContrasenia;


    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    public Usuario iniciarSesionUsuario() {
        String cedula = tfCedula.getText();
        String contrasenia = pfContrasenia.getText();

        if (administradorController.validadCredencialesUsuario(cedula, contrasenia)) {
            openPantallaUsuario(administradorController.obtenerUsuario(cedula));
        }
        return null;
    }

    public void openPantallaUsuario(Usuario usuario) {
        app.openPantallaUsuario();

    }


    public void setAdministradorController(AdministradorController administradorController) {
        this.administradorController = administradorController;
    }

    public void openPantallaBienvenida() {
        app.openPantallaBienvenida();
    }


}
