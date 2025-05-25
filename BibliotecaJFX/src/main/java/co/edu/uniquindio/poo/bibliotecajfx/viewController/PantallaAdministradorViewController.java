package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Administrador;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Bibliotecario;
import co.edu.uniquindio.poo.bibliotecajfx.Model.Empleado;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;

public class PantallaAdministradorViewController {

    App app;
    AdministradorController administradorController;
    ObservableList<Empleado> listEmpleados = FXCollections.observableArrayList();
    @FXML
    TableView<Empleado> tbEmpleados;
    @FXML
    TableColumn<Empleado, String> tbcNombre;
    @FXML
    TableColumn<Empleado, String> tbcCedula;
    @FXML
    TableColumn<Empleado, String> tbcContrasenia;
    @FXML
    TableColumn<Empleado, String> tbcTipoTrabajo;
    @FXML
    TextField tfNombre;
    @FXML
    TextField tfCedula;
    @FXML
    TextField tfContrasenia;


    public void setListEmpleado(ObservableList<Empleado> listEmpleado) {
        this.listEmpleados = listEmpleado;
        tbEmpleados.setItems(listEmpleado);
    }

    public void eliminarEmpleado() {

        Empleado empleadoSeleccionado = tbEmpleados.getSelectionModel().getSelectedItem();

        if (empleadoSeleccionado != null) {
            if(!empleadoSeleccionado.getCedula().equals("1145724059") && !empleadoSeleccionado.getCedula().equals("123456789")) {
                listEmpleados.remove(empleadoSeleccionado);
                ObservableList<Empleado> lista = FXCollections.observableArrayList(app.getListEmpleados());
                lista.remove(empleadoSeleccionado);
                app.setListEmpleados(lista);
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

    public void setApp(App app) {
        this.app = app;
    }

    public void cerrarSesion() {
        app.openPantallaBienvenida();
    }
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

    }
    public void limpiarEmpleado() {
        tfNombre.clear();
        tfCedula.clear();
        tfContrasenia.clear();

    }





    public void initialize() {
    tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
    tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
    tbcContrasenia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContrasenia()));
    tbcTipoTrabajo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoTrabajo().toString()));

    tbEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        if (newSelection != null) {
            obtenerInformacionEmpleado();
        }
    });
}
}
