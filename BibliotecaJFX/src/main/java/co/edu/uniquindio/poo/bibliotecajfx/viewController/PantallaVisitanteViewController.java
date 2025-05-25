package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Libro;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * Controlador para la pantalla de visitante en la aplicación de la biblioteca.
 * Permite visualizar una tabla con los libros disponibles sin opciones de reserva.
 */
public class PantallaVisitanteViewController {

    private App app;

    private ObservableList<Libro> listLibros;

    @FXML
    private TableView<Libro> tbLibros;

    @FXML
    private TableColumn<Libro, String> tbcTitulo;

    @FXML
    private TableColumn<Libro, String> tbcAutor;

    @FXML
    private TableColumn<Libro, String> tbcEditorial;

    @FXML
    private TableColumn<Libro, String> tbcGenero;

    @FXML
    private TableColumn<Libro, String> tbcAnio;

    @FXML
    private TableColumn<Libro, String> tbcTipoLibro;

    /**
     * Establece la referencia a la aplicación principal para poder manejar
     * la navegación entre pantallas.
     *
     * @param app instancia de la clase principal App
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Establece la lista observable de libros que se mostrará en la tabla.
     *
     * @param listLibros lista observable con los libros a mostrar
     */
    public void setListLibros(ObservableList<Libro> listLibros) {
        this.listLibros = listLibros;
        tbLibros.setItems(listLibros);
    }

    /**
     * Abre la pantalla de bienvenida de la aplicación.
     * Se usa para cerrar sesión o volver a la pantalla principal.
     */
    public void openPantallaBienvenida() {
        app.openPantallaBienvenida();
    }

    /**
     * Método para cerrar sesión del visitante, que redirige a la pantalla de bienvenida.
     */
    public void cerrarSesion() {
        app.openPantallaBienvenida();
    }

    /**
     * Inicializa las columnas de la tabla con los datos de los libros.
     * Este método se ejecuta automáticamente al cargar la vista.
     */
    public void initialize() {
        tbcTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tbcAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        tbcEditorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
        tbcGenero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
        tbcTipoLibro.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTipoLibro())));
        tbcAnio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));
    }
}
