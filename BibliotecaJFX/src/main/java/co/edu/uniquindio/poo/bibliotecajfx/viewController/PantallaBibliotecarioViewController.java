package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.BibliotecarioController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

public class PantallaBibliotecarioViewController {
    App app;
    BibliotecarioController bibliotecarioController;
    ObservableList<Usuario> listUsuarios;
    ObservableList<Libro> listLibros;
    ObservableList<Libro> listLibrosFisicos;
    ObservableList<Libro> listLibrosDigitales;
    ObservableList<Libro> listLibrosReferencias;
    ObservableList<Reserva> listReservas;

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
    TextField tfNombreUsuario;
    @FXML
    TextField tfCedulaUsuario;
    @FXML
    TextField tfCorreoUsuario;
    @FXML
    TextField tfContraseniaUsuario;


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

    @FXML
    TableView<Libro> tbLibrosDigitales;
    @FXML
    TableColumn<Libro, String> tbcTituloDigital;
    @FXML
    TableColumn<Libro, String> tbcAutorDigital;
    @FXML
    TableColumn<Libro, String> tbcGeneroDigital;
    @FXML
    TableColumn<Libro, String> tbcAnioDigital;
    @FXML
    TableColumn<Libro, String> tbcDisponibleDigital;
    @FXML
    TableColumn<LibroDigital, String> tbcFormatoDigital;

    @FXML
    TableView<Libro> tbLibrosReferencias;
    @FXML
    TableColumn<Libro, String> tbcTituloReferencia;
    @FXML
    TableColumn<Libro, String> tbcAutorReferencia;
    @FXML
    TableColumn<Libro, String> tbcEditorialReferencia;
    @FXML
    TableColumn<Libro, String> tbcGeneroReferencia;
    @FXML
    TableColumn<Libro, String> tbcAnioReferencia;

    @FXML
    TableView<Reserva> tbReservas;
    @FXML
    TableColumn<Reserva, String> tbcLibroReserva;
    @FXML
    TableColumn<Reserva, String> tbcUsuarioReserva;
    @FXML
    TableColumn<Reserva, String> tbcTipoUsuarioReserva;
    @FXML
    TableColumn<Reserva, String> tbcFechaReserva;
    @FXML
    TableColumn<Reserva, String> tbcTiempoReserva;
    @FXML
    TextField tfUsuarioReserva;
    @FXML
    TextField tfLibroReserva;
    @FXML
    TextField tfTiempoReserva;


    public void setApp(App app) {
        this.app = app;
    }

    public void setListLibros(ObservableList<Libro> listLibros) {
        this.listLibros = listLibros;
    }

    public void setBibliotecarioController(BibliotecarioController bibliotecarioController) {
        this.bibliotecarioController = bibliotecarioController;
    }

    public void setListUsuarios(ObservableList<Usuario> listUsuarios) {
        this.listUsuarios = listUsuarios;
        if (tbUsuarios != null) {
            tbUsuarios.setItems(this.listUsuarios);
        }
    }

    public void agregarEstudiante() {
        String nombre = tfNombreUsuario.getText();
        String cedula = tfCedulaUsuario.getText();
        String correo = tfCorreoUsuario.getText();
        String contrasenia = tfContraseniaUsuario.getText();

        if (nombre.isEmpty() || cedula.isEmpty() || correo.isEmpty()) {
            mostrarError("Hay celdas vacías.");
        } else {

            boolean cedulaExistente = listUsuarios.stream().anyMatch(usuario -> usuario.getCedula().equals(cedula));

            if (cedulaExistente) {
                mostrarError("Ya existe un usuario con esa cédula.");
            } else {
                Estudiante estudiante = new Estudiante(nombre, cedula, correo, contrasenia);
                bibliotecarioController.registrarEstudiante(estudiante);
                listUsuarios.add(estudiante);
            }
        }
    }

    public void agregarReserva() {
        String cedula = tfUsuarioReserva.getText().trim();
        String tituloLibro = tfLibroReserva.getText().trim();
        int dias;

        try {
            dias = Integer.parseInt(tfTiempoReserva.getText().trim());
            if (dias <= 0) {
                mostrarError("Los días deben ser un número mayor que cero.");
                return;
            }
        } catch (NumberFormatException e) {
            mostrarError("Ingrese un número válido para los días.");
            return;
        }

        if (cedula.isEmpty()) {
            mostrarError("El campo cédula está vacío.");
            return;
        }
        if (tituloLibro.isEmpty()) {
            mostrarError("El campo título del libro está vacío.");
            return;
        }

        Usuario usuarioEncontrado = listUsuarios.stream()
                .filter(u -> u.getCedula().equalsIgnoreCase(cedula))
                .findFirst()
                .orElse(null);
        if (usuarioEncontrado == null) {
            mostrarError("No existe un usuario con esa cédula.");
            return;
        }

        Libro libroEncontrado = listLibros.stream()
                .filter(l -> l.getTitulo().equalsIgnoreCase(tituloLibro))
                .findFirst()
                .orElse(null);
        if (libroEncontrado == null) {
            mostrarError("No existe un libro con ese título.");
            return;
        }

        try {

            if (libroEncontrado.isEstaDisponible()) {
                Reserva reserva = new Reserva(libroEncontrado, usuarioEncontrado, dias, LocalDate.now());
                listReservas.add(reserva);
                libroEncontrado.setEstaDisponible(true);
                bibliotecarioController.prestarLibro(libroEncontrado, usuarioEncontrado, dias);

                refrehLibros();
            }
            else {
                mostrarError("El Libro no esta disponible.");
            }

        } catch (Exception e) {
            mostrarError("Error al agregar la reserva: " + e.getMessage());
        }
    }
    public void eliminarReserva() {
        listReservas = FXCollections.observableList(listReservas);
        if (tbReservas.getSelectionModel().getSelectedItem() != null) {
            tbReservas.getSelectionModel().getSelectedItem().getLibro().setEstaDisponible(true);
            bibliotecarioController.devolverLibro(tbReservas.getSelectionModel().getSelectedItem());
            listReservas.remove(tbReservas.getSelectionModel().getSelectedItem());
            tbReservas.getSelectionModel().clearSelection();
            limpiarReserva();
            refrehLibros();

        }
        else {
            mostrarError("No has Seleccionado ningúna Reserva.");
        }
    }





    public void agregarDocente() {
        String nombre = tfNombreUsuario.getText();
        String cedula = tfCedulaUsuario.getText();
        String correo = tfCorreoUsuario.getText();
        String contrasenia = tfContraseniaUsuario.getText();

        if (nombre.isEmpty() || cedula.isEmpty() || correo.isEmpty()) {
            mostrarError("Hay celdas vacías.");
        } else {

            boolean cedulaExistente = listUsuarios.stream().anyMatch(usuario -> usuario.getCedula().equals(cedula));

            if (cedulaExistente) {
                mostrarError("Ya existe un usuario con esa cédula.");
            } else {
                Docente docente = new Docente(nombre, cedula, correo, contrasenia);
                bibliotecarioController.registrarDocente(docente);
                listUsuarios.add(docente);
            }
        }
    }


    public void eliminarUsuario() {
        listLibros = FXCollections.observableList(listLibros);
       if (tbUsuarios.getSelectionModel().getSelectedItem() != null) {
           bibliotecarioController.eliminarUsuario(tbUsuarios.getSelectionModel().getSelectedItem());
           listUsuarios.remove(tbUsuarios.getSelectionModel().getSelectedItem());
           tbUsuarios.getSelectionModel().clearSelection();
           limpiarUsuario();

       }
       else {
            mostrarError("No has Seleccionado ningún Usuario.");
       }
    }

    public void obtenerInformacionUsuario() {
        if (tbUsuarios.getSelectionModel().getSelectedItem() != null) {
            String nombre = tbUsuarios.getSelectionModel().getSelectedItem().getNombreCompleto();
            String cedula = tbUsuarios.getSelectionModel().getSelectedItem().getCedula();
            String correo = tbUsuarios.getSelectionModel().getSelectedItem().getCorreo();
            String Contrasenia = tbUsuarios.getSelectionModel().getSelectedItem().getContrasenia();

            tfNombreUsuario.setText(nombre);
            tfCedulaUsuario.setText(cedula);
            tfCorreoUsuario.setText(correo);
            tfContraseniaUsuario.setText(Contrasenia);

        }
    }

        public void obtenerInformacionReserva () {
            if (tbReservas.getSelectionModel().getSelectedItem() != null) {
                String cedulaUsuario = tbReservas.getSelectionModel().getSelectedItem().getUsuario().getCedula();
                String LibroReserva = tbReservas.getSelectionModel().getSelectedItem().getLibro().getTitulo();
                int tiempo = tbReservas.getSelectionModel().getSelectedItem().getTiempoDias();

                tfUsuarioReserva.setText(cedulaUsuario);
                tfLibroReserva.setText(LibroReserva);
                tfTiempoReserva.setText(String.valueOf(tiempo));

            }


        }
        public void modificarUsuario () {
            Usuario seleccionado = tbUsuarios.getSelectionModel().getSelectedItem();

            if (seleccionado == null) {
                mostrarError("Debe seleccionar un estudiante para modificar.");
            } else {
                String nuevoNombre = tfNombreUsuario.getText();
                String nuevaCedula = tfCedulaUsuario.getText();
                String nuevoCorreo = tfCorreoUsuario.getText();
                String nuevaContrasenia = tfContraseniaUsuario.getText();

                if (nuevoNombre.isEmpty() || nuevaCedula.isEmpty() || nuevoCorreo.isEmpty()) {
                    mostrarError("Hay celdas vacías");
                    return;
                }

                boolean cedulaDuplicada = listUsuarios.stream()
                        .anyMatch(est -> !est.equals(seleccionado) && est.getCedula().equals(nuevaCedula));

                if (cedulaDuplicada) {
                    mostrarError("Ya existe un usuario con esa cédula..");
                    return;
                }

                seleccionado.setNombreCompleto(nuevoNombre);
                seleccionado.setCedula(nuevaCedula);
                seleccionado.setCorreo(nuevoCorreo);
                seleccionado.setContrasenia(nuevaContrasenia);

                tbUsuarios.refresh();
                tbUsuarios.getSelectionModel().clearSelection();
            }
        }







    public void setListReservas (ObservableList < Reserva > listReservas) {
            this.listReservas = listReservas;
            if (tbReservas != null) {
                tbReservas.setItems(this.listReservas);
            }
        }


        public void setListLibrosFisicos (ObservableList < Libro > listLibros) {
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


        public void setListLibrosReferencia (ObservableList < Libro > listLibros) {
            listLibrosReferencias = FXCollections.observableArrayList();

            for (Libro libroReferencia : listLibros) {
                if (libroReferencia.getTipoLibro() == TipoLibro.REFERENCIA) {
                    listLibrosReferencias.add(libroReferencia);
                }
            }

            if (tbLibrosReferencias != null) {
                tbLibrosReferencias.setItems(this.listLibrosReferencias);
            }
        }

        public void setListLibrosDigitales (ObservableList < Libro > listLibros) {
            listLibrosDigitales = FXCollections.observableArrayList();

            for (Libro libroDigital : listLibros) {
                if (libroDigital.getTipoLibro() == TipoLibro.DIGITAL) {
                    listLibrosDigitales.add(libroDigital);
                }
            }

            if (tbLibrosDigitales != null) {
                tbLibrosDigitales.setItems(this.listLibrosDigitales);
            }
        }



        public void limpiarUsuario () {
            tbUsuarios.getSelectionModel().clearSelection();

            tfNombreUsuario.clear();
            tfCedulaUsuario.clear();
            tfCorreoUsuario.clear();
            tfContraseniaUsuario.clear();
        }


    public void limpiarReserva () {
        tbReservas.getSelectionModel().clearSelection();

        tfUsuarioReserva.clear();
        tfLibroReserva.clear();
        tfTiempoReserva.clear();

    }



        public void cerrarSesion () {
            app.openPantallaBienvenida();
        }

    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void refrehLibros(){
        tbLibrosFisicos.refresh();
        tbLibrosReferencias.refresh();
        tbLibrosDigitales.refresh();
    }


        public void initialize () {


            tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombreCompleto()));
            tbcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
            tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
            tbcContrasenia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContrasenia()));
            tbcTipoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoUsuario().toString()));

            tbcLibroReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibro().getTitulo()));
            tbcUsuarioReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario().getNombreCompleto()));
            tbcTipoUsuarioReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario().getTipoUsuario().toString()));
            tbcFechaReserva.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
            tbcTiempoReserva.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTiempoDias())));


            tbcTituloFisico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
            tbcAutorFisico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
            tbcEditorialFisico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
            tbcGeneroFisico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
            tbcAnioFisico.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));
            tbcDisponibleFisico.setCellValueFactory(cellData -> {
                boolean disponible = cellData.getValue().isEstaDisponible();
                String texto = disponible ? "Sí" : "No";
                return new SimpleStringProperty(texto);

            });

            tbcTituloDigital.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
            tbcAutorDigital.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
            tbcGeneroDigital.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
            tbcAnioDigital.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));
            tbcFormatoDigital.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFormatoDigital().toString()));
            tbcDisponibleDigital.setCellValueFactory(cellData -> {
                boolean disponible = cellData.getValue().isEstaDisponible();
                String texto = disponible ? "Sí" : "No";
                return new SimpleStringProperty(texto);
            });

            tbcTituloReferencia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
            tbcAutorReferencia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
            tbcEditorialReferencia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
            tbcGeneroReferencia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGenero()));
            tbcAnioReferencia.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));


            tbUsuarios.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    obtenerInformacionUsuario();
                }
            });

            tbReservas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    obtenerInformacionReserva();
                }
            });

        }
    }





