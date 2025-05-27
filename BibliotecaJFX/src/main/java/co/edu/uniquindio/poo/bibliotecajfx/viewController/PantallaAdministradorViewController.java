package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.Set;

/**
 * Controlador para la pantalla del administrador, que permite gestionar
 * los empleados de la biblioteca (bibliotecarios y administradores).
 * Provee funcionalidades para agregar, modificar, eliminar empleados,
 * mostrar información en tabla y gráficos.
 */
public class PantallaAdministradorViewController {

    /** Referencia a la clase principal de la aplicación */
    App app;

    /** Controlador de administración (no utilizado en este código) */
    AdministradorController administradorController;

    /** Lista observable para manejar los empleados mostrados en la tabla */
    ObservableList<Empleado> listEmpleados = FXCollections.observableArrayList();

    /** Tabla para mostrar los empleados */
    @FXML
    TableView<Empleado> tbEmpleados;

    /** Columnas de la tabla para nombre, cédula, contraseña y tipo de trabajo */
    @FXML
    TableColumn<Empleado, String> tbcNombre;
    @FXML
    TableColumn<Empleado, String> tbcCedula;
    @FXML
    TableColumn<Empleado, String> tbcContrasenia;
    @FXML
    TableColumn<Empleado, String> tbcTipoTrabajo;

    /** Campos de texto para nombre, cédula y contraseña del empleado */
    @FXML
    TextField tfNombre;
    @FXML
    TextField tfCedula;
    @FXML
    TextField tfContrasenia;

    /** Gráfico de torta que muestra la proporción de tipos de empleados */
    @FXML
    PieChart pcEmpleados;

    /** Texto para mostrar informe resumen de empleados */
    @FXML
    Text txtInforme;


    /**
     * Establece la lista observable de empleados que se mostrará en la tabla.
     * @param listEmpleado lista observable de empleados
     */
    public void setListEmpleado(ObservableList<Empleado> listEmpleado) {
        this.listEmpleados = listEmpleado;
        tbEmpleados.setItems(listEmpleado);
    }

    /**
     * Elimina el empleado seleccionado en la tabla, excepto si es un empleado
     * principal (cédulas específicas). Actualiza las listas local y global.
     */
    public void eliminarEmpleado() {
        Empleado empleadoSeleccionado = tbEmpleados.getSelectionModel().getSelectedItem();

        if (empleadoSeleccionado != null) {
            if(!empleadoSeleccionado.getCedula().equals("1145724059") && !empleadoSeleccionado.getCedula().equals("1145731491")) {
                listEmpleados.remove(empleadoSeleccionado);
                ObservableList<Empleado> lista = FXCollections.observableArrayList(app.getListEmpleados());
                lista.remove(empleadoSeleccionado);
                app.setListEmpleados(lista);
                app.getBiblioteca().getListEmpleados().remove(empleadoSeleccionado);
                tbEmpleados.getSelectionModel().clearSelection();
            }
            else {
                mostrarError("No se puede eliminar al "+empleadoSeleccionado.getTipoTrabajo()+" PRINCIPAL.");
            }
        }
        else {
            mostrarError("Seleccione un empleado");
        }
    }

    /**
     * Crea y agrega un nuevo bibliotecario con los datos ingresados en los campos de texto.
     * Valida que no haya campos vacíos ni cédulas duplicadas.
     */
    public void agregarBibliotecario() {
        String nombre = tfNombre.getText();
        String cedula = tfCedula.getText();
        String contrasenia = tfContrasenia.getText();

        if (nombre.isEmpty() || cedula.isEmpty() || contrasenia.isEmpty()) {
            mostrarError("Hay celdas vacías.");
        } else {
            boolean cedulaExistente = listEmpleados.stream()
                    .anyMatch(usuario -> usuario.getCedula().equals(cedula));

            if (cedulaExistente) {
                mostrarError("Ya existe un Empleado con esa cédula.");
            } else {
                Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula,  contrasenia, app.getBiblioteca());
                ObservableList<Empleado> lista = FXCollections.observableArrayList(app.getListEmpleados());
                lista.add(bibliotecario);
                app.setListEmpleados(lista);
                listEmpleados.add(bibliotecario);
                mostrarMensaje("Bibliotecario creado con éxito.");
            }
        }
    }

    /**
     * Crea y agrega un nuevo administrador con los datos ingresados en los campos de texto.
     * Valida que no haya campos vacíos ni cédulas duplicadas.
     */
    public void agregarAdministrador() {
        String nombre = tfNombre.getText();
        String cedula = tfCedula.getText();
        String contrasenia = tfContrasenia.getText();

        if (nombre.isEmpty() || cedula.isEmpty() || contrasenia.isEmpty()) {
            mostrarError("Hay celdas vacías.");
        } else {
            boolean cedulaExistente = listEmpleados.stream()
                    .anyMatch(usuario -> usuario.getCedula().equals(cedula));

            if (cedulaExistente) {
                mostrarError("Ya existe un Empleado con esa cédula.");
            } else {
                Administrador administrador = new Administrador(nombre, cedula, contrasenia, app.getBiblioteca());
                ObservableList<Empleado> lista = FXCollections.observableArrayList(app.getListEmpleados());
                lista.add(administrador);
                app.setListEmpleados(lista);
                listEmpleados.add(administrador);
                mostrarMensaje("Administrador creado con éxito.");
            }
        }
    }

    /**
     * Modifica los datos del empleado seleccionado con los datos ingresados en los campos de texto.
     * Valida campos vacíos y evita cédulas duplicadas.
     */
    public void modificarEmpleado() {
        Empleado seleccionado = tbEmpleados.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarError("Debe seleccionar un Empleado para modificar.");
        } else {
            String nuevoNombre = tfNombre.getText();
            String nuevaCedula = tfCedula.getText();
            String nuevaContrasenia = tfContrasenia.getText();

            if (nuevoNombre.isEmpty() || nuevaCedula.isEmpty() || nuevaContrasenia.isEmpty()) {
                mostrarError("Hay campos vacíos");
                return;
            }

            boolean cedulaDuplicada = listEmpleados.stream()
                    .anyMatch(emp -> !emp.equals(seleccionado) && emp.getCedula().equals(nuevaCedula));

            if (cedulaDuplicada) {
                mostrarError("Ya existe un Empleado con esa cédula.");
                return;
            }

            seleccionado.setNombreCompleto(nuevoNombre);
            seleccionado.setCedula(nuevaCedula);
            seleccionado.setContrasenia(nuevaContrasenia);

            tbEmpleados.refresh();
            tbEmpleados.getSelectionModel().clearSelection();
            mostrarMensaje("Empleado modificado con éxito.");
        }
    }

    /**
     * Carga la información del empleado seleccionado en los campos de texto
     * para poder modificarla.
     */
    public void obtenerInformacionEmpleado() {
        if (tbEmpleados.getSelectionModel().getSelectedItem() != null) {
            String nombre = tbEmpleados.getSelectionModel().getSelectedItem().getNombreCompleto();
            String cedula = tbEmpleados.getSelectionModel().getSelectedItem().getCedula();
            String Contrasenia = tbEmpleados.getSelectionModel().getSelectedItem().getContrasenia();

            tfNombre.setText(nombre);
            tfCedula.setText(cedula);
            tfContrasenia.setText(Contrasenia);
        }
    }

    /**
     * Asigna la referencia a la clase principal de la aplicación.
     * @param app instancia principal de la aplicación
     */
    public void setApp(App app) {
        this.app = app;
    }

    /**
     * Cierra sesión y regresa a la pantalla de bienvenida.
     */
    public void cerrarSesion() {
        app.openPantallaBienvenida();
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje de error.
     * @param error mensaje de error a mostrar
     */
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Muestra un cuadro de diálogo con un mensaje informativo.
     * @param mensaje mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Limpia los campos de texto para ingreso/modificación de empleados.
     */
    public void limpiarEmpleado() {
        tfNombre.clear();
        tfCedula.clear();
        tfContrasenia.clear();
    }

    /**
     * Carga y muestra el gráfico de torta con la proporción
     * de administradores y bibliotecarios, así como el resumen en texto.
     */
    public void cargarGraficas() {
        pcEmpleados.setTitle("Proporción de empleados");

        ObservableList<Empleado> lista = FXCollections.observableArrayList(listEmpleados);

        double bibliotecarios = 0.0;
        double administradores = 0.0;

        for (Empleado emp : lista) {
            if (emp.getTipoTrabajo().equals(TipoTrabajo.ADMINISTRADOR)) {
                administradores++;
            } else if (emp.getTipoTrabajo().equals(TipoTrabajo.BIBLIOTECARIO)) {
                bibliotecarios++;
            }
        }

        pcEmpleados.getData().addAll(
                new PieChart.Data("Administradores", administradores),
                new PieChart.Data("Bibliotecarios", bibliotecarios)
        );
        pcEmpleados.setLegendVisible(true);
        pcEmpleados.setLabelsVisible(true);

        txtInforme.setText(
                "Cantidad de Empleados: " + listEmpleados.size()+"\n"+
                        "Administradores: " + Math.round(administradores)+"\n"+
                        "Bibliotecarios: " + Math.round(bibliotecarios));
    }

    /**
     * Elimina el gráfico y oculta leyendas y etiquetas.
     */
    public void eliminarGrafica() {
        if (pcEmpleados != null) {
            pcEmpleados.getData().clear();
            pcEmpleados.setLegendVisible(false);
            pcEmpleados.setLabelsVisible(false);
            ocultarLabels( pcEmpleados );
        }
    }
    private void ocultarLabels(PieChart pieChart) {
        Platform.runLater(() -> {
            Set<Node> labels = pieChart.lookupAll(".chart-pie-label");
            for (Node label : labels) {
                label.setVisible(false);
                label.setManaged(false);
                label.setMouseTransparent(true);
            }
            pieChart.requestLayout();
            pieChart.layout();
        });
    }


    /**
     * Inicializa la tabla configurando las columnas para mostrar
     * el nombre, cédula, contraseña y tipo de trabajo de cada empleado.
     */
    @FXML
    public void initialize() {
       {
            tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
            tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
            tbcContrasenia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContrasenia()));
            tbcTipoTrabajo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoTrabajo().name()));
            tbEmpleados.setItems(listEmpleados);


           tbEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
               if (newSelection != null) {
                   obtenerInformacionEmpleado();
               }
           });

        };
    }
}
