package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Administrador;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Empleado;
import co.edu.uniquindio.poo.bibliotecajfx.Model.TipoTrabajo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.awt.*;

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

    @FXML
    public Empleado iniciarSesionEmpleado() {
        String cedula = tfCedula.getText();
        String contrasenia = pfContrasenia.getText();

        if (administradorController.validarCredencialesEmpleado(cedula, contrasenia)) {
            openPantallaEmpleado(administradorController.obtenerEmpleado(cedula));
        }
            return null;
    }

    public void openPantallaBienvenida() {
        app.openPantallaBienvenida();
    }

    public void openPantallaEmpleado(Empleado empleado) {
        if (empleado.getTipoTrabajo() == TipoTrabajo.ADMINISTRADOR) {
            app.openPantallaAdministrador();
        }
        else if(empleado.getTipoTrabajo() == TipoTrabajo.BIBLIOTECARIO) {
            app.openPantallaBibliotecario();
        }
    }


}
