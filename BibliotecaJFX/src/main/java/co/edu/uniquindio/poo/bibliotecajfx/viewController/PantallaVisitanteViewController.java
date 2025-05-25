package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Libro;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PantallaVisitanteViewController {
    App app;
    ObservableList<Libro> listLibros;



    @FXML
    TableView<Libro> tbLibros;
    @FXML
    TableColumn<Libro, String> tbcTitulo;
    @FXML
    TableColumn<Libro, String> tbcAutor;
    @FXML
    TableColumn<Libro, String> tbcEditorial;
    @FXML
    TableColumn<Libro, String> tbcGenero;
    @FXML
    TableColumn<Libro, String> tbcAnio;
    @FXML
    TableColumn<Libro, String> tbcTipoLibro;

    public void setApp(App app) {
        this.app = app;
    }
    public void setListLibros(ObservableList<Libro> listLibros) {
        this.listLibros = listLibros;
        tbLibros.setItems(listLibros);
    }

    public void openPantallaBienvenida() {
        app.openPantallaBienvenida();
    }
    public void cerrarSesion() {
        app.openPantallaBienvenida();
    }


    public void initialize() {
        tbcTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tbcAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        tbcEditorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
        tbcGenero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
        tbcTipoLibro.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTipoLibro())));
        tbcAnio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));
    }
}
