package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import javafx.fxml.FXML;

/**
 * Controlador de la pantalla de bienvenida.
 * Gestiona la navegación hacia las diferentes pantallas según el tipo de usuario.
 */
public class PantallaBienvenidaViewController {

    /**
     * Referencia a la aplicación principal para acceder a métodos de navegación.
     */
    App app;

    /**
     * Método que se activa al seleccionar la opción para ingresar como empleado.
     * Navega a la pantalla de credenciales de empleado.
     */
    @FXML
    void openPantallaCredencialesEmpleado(){
        app.openPantallaCredencialesEmpleado();
    }

    /**
     * Método que se activa al seleccionar la opción para ingresar como usuario registrado.
     * Navega a la pantalla de credenciales de usuario.
     */
    @FXML
    void openPantallaCredencialesUsuario(){
        app.openPantallaCredencialesUsuario();
    }

    /**
     * Método que se activa al seleccionar la opción para ingresar como visitante.
     * Navega a la pantalla destinada a visitantes.
     */
    @FXML
    void openPantallaVisitante() {
        app.openPantallaVisitante();
    }

    /**
     * Establece la referencia a la instancia principal de la aplicación.
     * @param app instancia principal de la aplicación
     */
    public void setApp(App app) {
        this.app = app;
    }
}
