package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Administrador;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PantallaCredencialesEmpleadoViewController {
    private App app;
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

    public void setAdministradorController(AdministradorController administradorController) {
        this.administradorController = administradorController;
    }

    public void openPantallaBienvenida() {
        app.openPantallaBienvenida();
    }

    @FXML
    public boolean iniciarSesionEmpleado() {
        String cedula = tfCedula.getText();
        String contrasenia = pfContrasenia.getText();
        return administradorController.validarCredencialesEmpleado(cedula, contrasenia);
    }
}
