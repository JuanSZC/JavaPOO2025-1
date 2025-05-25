package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Libro;
import co.edu.uniquindio.poo.bibliotecajfx.Model.TipoLibro;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;




public class PantallaUsuarioViewController {
    App app;
    public Usuario usuarioSesion;
    public ObservableList<Libro> listLibros;

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
    TableColumn<Libro,String> tbcTipoLibro;
    @FXML
    TableColumn<Libro,String> tbcDisponible;
    @FXML
    TableColumn<Libro,String> tbcAnio;


    public void setListLibros(ObservableList<Libro> listLibros) {
        this.listLibros = listLibros;
        tbLibros.setItems(listLibros);
    }

    public void setApp(App app) {
        this.app = app;
    }



    public void initialize(){
        if (app != null) {
            usuarioSesion = app.getUsuarioSesion();
        }
        System.out.println(usuarioSesion);

        tbcTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tbcAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        tbcEditorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
        tbcGenero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
        tbcTipoLibro.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTipoLibro())));
        tbcAnio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));
        tbcDisponible.setCellValueFactory(cellData -> {
            boolean disponible = cellData.getValue().isEstaDisponible();
            String texto = disponible ? "Sí" : "No";
            return new SimpleStringProperty(texto);
        });



    }



}
