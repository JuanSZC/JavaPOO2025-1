package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PantallaAdministradorViewController {

    App app;
    AdministradorController administradorController;
    ObservableList<Empleado> listEmpleado = FXCollections.observableArrayList();

    @FXML
    TableView<Empleado> tbGestionEmpleados;

    @FXML
    TableColumn<Empleado,String> tbcolNombre;

    @FXML
    TableColumn<Empleado,String> tbcolCedula;

    @FXML
    TableColumn<Empleado,String> tbcolContrasenia;























    public void setApp(App app) {
        this.app = app;
    }

}
