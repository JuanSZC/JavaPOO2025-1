package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.BibliotecarioController;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.UsuarioController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import javax.swing.*;

import java.time.LocalDate;

import static javafx.collections.FXCollections.observableArrayList;


public class PantallaUsuarioViewController {
    App app;
    public Usuario usuarioSesion;
    public ObservableList<Libro> listLibros;
    public UsuarioController usuarioController;
    public ObservableList<Reserva> listReservas;
    public BibliotecarioController bibliotecarioController;

    @FXML
    Text txtTipoUser1;
    @FXML
    Text txtTipoUser2;
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
    @FXML
    TextField tfTiempo;

    @FXML
    TableView<Reserva> tbReservas;
    @FXML
    TableColumn<Reserva, String> tbcLibroReserva;
    @FXML
    TableColumn<Reserva, String> tbcTipoLibroReserva;
    @FXML
    TableColumn<Reserva, String> tbcFechaReserva;
    @FXML
    TableColumn<Reserva, String> tbcTiempoReserva;
    @FXML
    TableColumn<Reserva, String> tbcFinFecha;



    public void setListLibros(ObservableList<Libro> listLibros) {
        this.listLibros = listLibros;
        tbLibros.setItems(listLibros);
    }
    public void setListReservas(ObservableList<Reserva> listReservas) {
        this.listReservas = listReservas;
        tbReservas.setItems(listReservas);
        System.out.print(listReservas);
    }

    public void setApp(App app) {
        this.app = app;
    }
    public void setUsuarioSesion(Usuario usuarioSesion) {

            this.usuarioSesion = usuarioSesion;
            this.usuarioController = new UsuarioController(usuarioSesion);
            txtTipoUser1.setText(usuarioSesion.getTipoUsuario().toString());
            txtTipoUser2.setText(usuarioSesion.getTipoUsuario().toString());

    }



    public void crearReserva() {
        Libro libroSeleccionado = tbLibros.getSelectionModel().getSelectedItem();

        if (libroSeleccionado == null) {
            mostrarError("Debe seleccionar un libro.");
            return;
        }

        int tiempo;
        try {
            tiempo = Integer.parseInt(tfTiempo.getText());
        } catch (NumberFormatException e) {
            mostrarError("El tiempo de préstamo debe ser un número entero.");
            return;
        }

        if (!libroSeleccionado.isEstaDisponible()) {
            mostrarError("El libro seleccionado no está disponible.");
            return;
        }
        if (libroSeleccionado.getTipoLibro() == TipoLibro.REFERENCIA) {
            mostrarError("No se puede reservar una libro del tipo Referencia.");
            return;
        }
        if (usuarioSesion.getListReservasUsuario().size() >= usuarioSesion.getMaxReservas()){
            mostrarError("Se ha superado el limite de Reservas de el usuario del tipo "+usuarioSesion.getTipoUsuario().toString()+".");
        }
        if (tiempo > usuarioSesion.getMaxDias()) {
            mostrarError("El Usuario de tipo "+usuarioSesion.getTipoUsuario()+" Solo puede reservar por un máximo de "+usuarioSesion.getMaxDias()+" dias.");
            return;
        }

        if (usuarioController != null) {
            usuarioSesion.solicitarPrestamoLibro(libroSeleccionado, tiempo);

            Reserva reserva = new Reserva(libroSeleccionado,usuarioSesion,tiempo, LocalDate.now());

            app.getListReservas().add(reserva);

            libroSeleccionado.setEstaDisponible(false);
            tbLibros.refresh();
            mostrarMensaje("El libro ha sido reservado con éxito.");
            System.out.println(usuarioSesion.getMaxReservas()+"--"+usuarioSesion.getListReservasUsuario().size());
        }
    }

    public void eliminarReserva() {
        Reserva reservaSeleccionado = tbReservas.getSelectionModel().getSelectedItem();
        if (reservaSeleccionado == null) {
            mostrarError("Debe seleccionar una reserva.");
            return;
        }
        reservaSeleccionado.getLibro().setEstaDisponible(true);
        app.getListReservas().remove(reservaSeleccionado);
        usuarioSesion.getListReservasUsuario().remove(reservaSeleccionado);
        reservaSeleccionado.getLibro().setEstaDisponible(true);
        listReservas.remove(reservaSeleccionado);
        tbReservas.getSelectionModel().select(reservaSeleccionado);
        mostrarMensaje("La reserva ha sido eliminada con Éxito.");
        tbReservas.refresh();
        tbLibros.refresh();
    }

    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

    }

    public void cerrarSesion() {
        app.openPantallaBienvenida();
    }


    public void initialize(){





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

        tbcLibroReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibro().getTitulo()));
        tbcTipoLibroReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibro().getTipoLibro().toString()));
        tbcFechaReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        tbcTiempoReserva.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTiempoDias())));
        tbcFinFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().plusDays(cellData.getValue().getTiempoDias()).toString()
                )
        );





    }



}
