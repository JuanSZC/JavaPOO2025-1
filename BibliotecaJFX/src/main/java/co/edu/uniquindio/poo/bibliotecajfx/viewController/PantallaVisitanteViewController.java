package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PantallaVisitanteViewController {
    App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    Button btCerrarSesion;

    public void openPantallaBienvenida() {
        app.openPantallaBienvenida();
    }
}
