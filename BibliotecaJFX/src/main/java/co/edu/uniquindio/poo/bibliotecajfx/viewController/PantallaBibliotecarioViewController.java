package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.BibliotecarioController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PantallaBibliotecarioViewController {
    App app;
    BibliotecarioController bibliotecarioController;
    ObservableList<Usuario> listUsuarios;

    ObservableList<Libro> listLibrosFisicos;
    ObservableList<Libro> listLibrosDigitales;
    ObservableList<Libro> listLibrosReferencia;
    ObservableList<Reserva> listReservas;


    public void setListUsuarios(ObservableList<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
        if(tbUsuarios != null) {
            tbUsuarios.setItems(this.listUsuarios);
        }
    }


    public void setListLibrosFisicos(ObservableList<Libro> listLibros) {
        listLibrosFisicos = FXCollections.observableArrayList();

        for (Libro libroFisico : listLibros) {
            if (libroFisico.getTipoLibro() == TipoLibro.FISICO) {
                listLibrosFisicos.add(libroFisico);
            }
        }

        if (tbLibrosFisicos != null) {
            tbLibrosFisicos.setItems(this.listLibrosFisicos);
        }
    }







    @FXML
    TableView<Usuario> tbUsuarios;
    @FXML
    TableColumn<Usuario, String> tbcNombre;
    @FXML
    TableColumn<Usuario, String> tbcCorreo;
    @FXML
    TableColumn<Usuario, String> tbcCedula;
    @FXML
    TableColumn<Usuario, String> tbcContrasenia;
    @FXML
    TableColumn<Usuario, String> tbcTipoUsuario;

    @FXML
    TableView<Libro> tbLibrosFisicos;
    @FXML
    TableColumn<Libro, String> tbcTituloFisico;
    @FXML
    TableColumn<Libro, String> tbcAutorFisico;
    @FXML
    TableColumn<Libro, String> tbcEditorialFisico;
    @FXML
    TableColumn<Libro, String> tbcGeneroFisico;
    @FXML
    TableColumn<Libro, String> tbcAnioFisico;
    @FXML
    TableColumn<Libro, String> tbcDisponibleFisico;


    public void initialize() {

        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
        tbcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcContrasenia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContrasenia()));
        tbcTipoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoUsuario().toString()));


        tbcTituloFisico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tbcAutorFisico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor().toString()));
        tbcEditorialFisico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial().toString()));
        tbcGeneroFisico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero().toString()));
        tbcAnioFisico.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));
        tbcDisponibleFisico.setCellValueFactory(cellData -> {
            boolean disponible = cellData.getValue().isEstaDisponible();
            String texto = disponible ? "Sí" : "No";
            return new SimpleStringProperty(texto);

        });





    }


    public void setApp(App app) {
        this.app = app;
    }

}
