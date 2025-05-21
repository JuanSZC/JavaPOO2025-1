package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class PantallaBienvenidaViewController {
    App app;

    @FXML
    void openPantallaCredencialesEmpleado(){
        app.openPantallaCredencialesEmpleado();
    }

    @FXML
    void openPantallaCredencialesUsuario(){
        app.openPantallaCredencialesUsuario();
    }
    @FXML
    void openPantallaVisitante() {
        app.openPantallaVisitante();
    }


    public void setApp(App app) {
        this.app = app;
    }
}
