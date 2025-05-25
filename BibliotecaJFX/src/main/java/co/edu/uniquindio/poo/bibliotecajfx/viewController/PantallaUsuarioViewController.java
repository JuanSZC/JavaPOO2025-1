package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.BibliotecarioController;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.UsuarioController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import javax.swing.*;
import java.time.LocalDate;

/**
 * Controlador para la pantalla principal de usuario.
 * Permite visualizar libros disponibles, gestionar reservas y mostrar información del usuario en sesión.
 */
public class PantallaUsuarioViewController {

    /**
     * Referencia a la aplicación principal para manejar navegación y datos globales.
     */
    private App app;

    /**
     * Usuario que ha iniciado sesión.
     */
    private Usuario usuarioSesion;

    /**
     * Lista observable de libros para mostrar en la tabla.
     */
    private ObservableList<Libro> listLibros;

    /**
     * Lista observable de reservas para mostrar en la tabla.
     */
    private ObservableList<Reserva> listReservas;

    /**
     * Controlador para operaciones relacionadas con el usuario.
     */
    private UsuarioController usuarioController;

    /**
     * Controlador para operaciones relacionadas con el bibliotecario.
     */
    private BibliotecarioController bibliotecarioController;

    // Controles FXML

    @FXML
    private Text txtTipoUser1;

    @FXML
    private Text txtTipoUser2;

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
    private TableColumn<Libro, String> tbcTipoLibro;

    @FXML
    private TableColumn<Libro, String> tbcDisponible;

    @FXML
    private TableColumn<Libro, String> tbcAnio;

    @FXML
    private TextField tfTiempo;

    @FXML
    private TableView<Reserva> tbReservas;

    @FXML
    private TableColumn<Reserva, String> tbcLibroReserva;

    @FXML
    private TableColumn<Reserva, String> tbcTipoLibroReserva;

    @FXML
    private TableColumn<Reserva, String> tbcFechaReserva;

    @FXML
    private TableColumn<Reserva, String> tbcTiempoReserva;

    @FXML
    private TableColumn<Reserva, String> tbcFinFecha;


    /**
     * Establece la lista observable de libros y la asigna a la tabla.
     * @param listLibros lista observable de libros
     */
    public void setListLibros(ObservableList<Libro> listLibros) {
        this.listLibros = listLibros;
        tbLibros.setItems(listLibros);
    }

    /**
     * Establece la lista observable de reservas y la asigna a la tabla.
     * @param listReservas lista observable de reservas
     */
    public void setListReservas(ObservableList<Reserva> listReservas) {
        this.listReservas = listReservas;
        tbReservas.setItems(listReservas);
        System.out.print(listReservas);
    }

    /**
     * Establece la referencia a la aplicación principal.
     * @param app instancia principal de la aplicación
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Establece el usuario en sesión, inicializa el controlador y actualiza etiquetas con el tipo de usuario.
     * @param usuarioSesion usuario que ha iniciado sesión
     */
    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
        this.usuarioController = new UsuarioController(usuarioSesion);
        txtTipoUser1.setText(usuarioSesion.getTipoUsuario().toString());
        txtTipoUser2.setText(usuarioSesion.getTipoUsuario().toString());
    }

    /**
     * Crea una reserva para el libro seleccionado con el tiempo indicado.
     * Valida disponibilidad, tipo de libro, límite de reservas y días máximos permitidos.
     * Muestra mensajes de error o éxito según corresponda.
     */
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
            mostrarError("No se puede reservar un libro del tipo Referencia.");
            return;
        }
        if (usuarioSesion.getListReservasUsuario().size() >= usuarioSesion.getMaxReservas()){
            mostrarError("Se ha superado el límite de reservas para el usuario del tipo " + usuarioSesion.getTipoUsuario() + ".");
            return;
        }
        if (tiempo > usuarioSesion.getMaxDias()) {
            mostrarError("El usuario de tipo " + usuarioSesion.getTipoUsuario() + " solo puede reservar por un máximo de " + usuarioSesion.getMaxDias() + " días.");
            return;
        }

        // Buscar usuario en la lista global y agregar la reserva
        for (Usuario user : app.getListUsuarios()) {
            if (user.equals(usuarioSesion)) {
                Reserva reserva = new Reserva(libroSeleccionado, usuarioSesion, tiempo, LocalDate.now());
                user.getListReservasUsuario().add(reserva);

                app.getListReservas().add(reserva);
                listReservas.add(reserva);
                libroSeleccionado.setEstaDisponible(false);
                tbLibros.refresh();
                tbReservas.refresh();
                mostrarMensaje("El libro ha sido reservado con éxito.");
                System.out.println(usuarioSesion.getMaxReservas() + "--" + usuarioSesion.getListReservasUsuario().size());
                break;
            }
        }
    }

    /**
     * Elimina la reserva seleccionada, actualiza la disponibilidad del libro y refresca las tablas.
     * Muestra mensajes de error o éxito según corresponda.
     */
    public void eliminarReserva() {
        Reserva reservaSeleccionado = tbReservas.getSelectionModel().getSelectedItem();
        if (reservaSeleccionado == null) {
            mostrarError("Debe seleccionar una reserva.");
            return;
        }
        reservaSeleccionado.getLibro().setEstaDisponible(true);
        app.getListReservas().remove(reservaSeleccionado);
        usuarioSesion.getListReservasUsuario().remove(reservaSeleccionado);
        listReservas.remove(reservaSeleccionado);
        tbReservas.getSelectionModel().select(reservaSeleccionado);
        mostrarMensaje("La reserva ha sido eliminada con éxito.");
        tbReservas.refresh();
        tbLibros.refresh();
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje de error.
     * @param error texto del mensaje de error
     */
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje informativo.
     * @param mensaje texto del mensaje informativo
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Cierra la sesión del usuario y regresa a la pantalla de bienvenida.
     */
    public void cerrarSesion() {
        app.openPantallaBienvenida();
    }

    /**
     * Inicializa las columnas de las tablas con los valores correspondientes de los objetos Libro y Reserva.
     * Este método se invoca automáticamente al cargar la interfaz.
     */
    public void initialize() {
        tbcTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        tbcAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        tbcEditorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
        tbcGenero.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
        tbcTipoLibro.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTipoLibro())));
        tbcAnio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));
        tbcDisponible.setCellValueFactory(cellData -> {
            boolean disponible = cellData.getValue().isEstaDisponible();
            return new SimpleStringProperty(disponible ? "Sí" : "No");
        });

        tbcLibroReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibro().getTitulo()));
        tbcTipoLibroReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibro().getTipoLibro().toString()));
        tbcFechaReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        tbcTiempoReserva.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTiempoDias())));
        tbcFinFecha.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getFecha().plusDays(cellData.getValue().getTiempoDias()).toString()
        ));
    }
}
