package co.edu.uniquindio.poo.bibliotecajfx.viewController;

import co.edu.uniquindio.poo.bibliotecajfx.App;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.BibliotecarioController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.text.TextFlow;

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
    TextField tfTituloFisico;
    @FXML
    TextField tfAutorFisico;
    @FXML
    TextField tfEditorialFisico;
    @FXML
    TextField tfGeneroFisico;
    @FXML
    TextField tfAnioFisico;
    @FXML
    CheckBox chbDisponibleFisico;

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
    TextField tfTituloDigital;
    @FXML
    TextField tfAutorDigital;
    @FXML
    TextField tfGeneroDigital;
    @FXML
    TextField tfAnioDigital;
    @FXML
    CheckBox chbDisponibleDigital;
    @FXML
    ComboBox<FormatoDigital> cbFormato;



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
    TextField tfTituloReferencia;
    @FXML
    TextField tfAutorReferencia;
    @FXML
    TextField tfEditorialReferencia;
    @FXML
    TextField tfGeneroReferencia;
    @FXML
    TextField tfAnioReferencia;


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

    @FXML
    PieChart pcGraficaLibros;


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
                Estudiante estudiante = new Estudiante(nombre, cedula, correo, contrasenia,app.getBiblioteca());
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
        if (libroEncontrado.getTipoLibro() == TipoLibro.REFERENCIA) {
            mostrarError("No se puede reservar un libro de tipo Referencia.");
            return;
        }

        try {
            if (dias > usuarioEncontrado.getMaxDias()){
                mostrarError("El usuario es de tipo "+usuarioEncontrado.getTipoUsuario().toString()+" Y su maximo de tiempo permitido es de "+usuarioEncontrado.getMaxDias()+" dias.");

            return;}

            if (libroEncontrado.isEstaDisponible()) {
                Reserva reserva = new Reserva(libroEncontrado, usuarioEncontrado, dias, LocalDate.now());
                listReservas.add(reserva);
                libroEncontrado.setEstaDisponible(true);
                bibliotecarioController.prestarLibro(libroEncontrado, usuarioEncontrado, dias);

                refrehLibros();
                mostrarMensaje("Reserva creada con Éxito.");
            } else {
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
            mostrarMensaje("Reserva Eliminada con Éxito.");

        } else {
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
                Docente docente = new Docente(nombre, cedula, correo, contrasenia,app.getBiblioteca());
                bibliotecarioController.registrarDocente(docente);
                listUsuarios.add(docente);
                mostrarMensaje("Docente Creado con Éxito.");
            }
        }
    }

    public void agregarLibroDigital() {
        String tituloLibro = tfTituloDigital.getText();
        String autor = tfAutorDigital.getText();
        String genero = tfGeneroDigital.getText();
        String anioTexto = tfAnioDigital.getText();
        FormatoDigital formato = cbFormato.getSelectionModel().getSelectedItem();
        boolean disponible = chbDisponibleDigital.isSelected();

        if (tituloLibro.isEmpty() || autor.isEmpty() || genero.isEmpty()) {
            mostrarError("Hay Celdas Vacías");
            return;
        }

        if (formato == null) {
            mostrarError("Seleccione un formato.");
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioTexto);
        } catch (NumberFormatException e) {
            mostrarError("El año debe ser un número entero válido.");
            return;
        }


        LibroDigital libroDigital = new LibroDigital(tituloLibro, autor, "", genero, anio, formato, "",disponible);
        bibliotecarioController.registrarLibroDigital(libroDigital);
        listLibrosDigitales.add(libroDigital);
        mostrarMensaje("Libro creado con Éxito.");

    }

    public void agregarLibroFisico() {
        String tituloLibro = tfTituloFisico.getText();
        String autor = tfAutorFisico.getText();
        String editorial = tfEditorialFisico.getText();
        String genero = tfGeneroFisico.getText();


        boolean disponible = chbDisponibleFisico.isSelected();

        if (tituloLibro.isEmpty() || autor.isEmpty() || genero.isEmpty()|| editorial.isEmpty()) {
            mostrarError("Hay Celdas Vacías");
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(tfAnioFisico.getText());
        } catch (NumberFormatException e) {
            mostrarError("El año debe ser un número entero válido.");
            return;
        }


        LibroFisico libroFisico = new LibroFisico(tituloLibro,autor,editorial,genero,anio,disponible);
        bibliotecarioController.registrarLibroFisico(libroFisico);
        listLibrosFisicos.add(libroFisico);
        mostrarMensaje("Libro creado con Éxito.");

    }



    public void agregarLibroReferencia() {
        String titulo = tfTituloReferencia.getText();
        String autor = tfAutorReferencia.getText();
        String editorial = tfEditorialReferencia.getText();
        String genero = tfGeneroReferencia.getText();
        String anioTexto = tfAnioReferencia.getText();

        if (titulo.isEmpty() || autor.isEmpty() || editorial.isEmpty() || genero.isEmpty() || anioTexto.isEmpty()) {
            mostrarError("Hay celdas vacías.");
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioTexto);
        } catch (NumberFormatException e) {
            mostrarError("El año debe ser un número entero válido.");
            return;
        }

        LibroReferencia libroReferencia = new LibroReferencia(titulo, autor, editorial, genero, anio);
        bibliotecarioController.registrarLibroReferencia(libroReferencia);
        listLibrosReferencias.add(libroReferencia);
        mostrarMensaje("Libro creado con Éxito.");


    }



    public void eliminarUsuario() {
        for (Reserva reserva : app.getListReservas()) {
            if (reserva.getUsuario().equals(tbUsuarios.getSelectionModel().getSelectedItem())) {
                mostrarError("No se puede eliminar el usuario, debido a que tiene libros reservados.");
                return;
            }
        }
        if (tbUsuarios.getSelectionModel().getSelectedItem() != null) {
            bibliotecarioController.eliminarUsuario(tbUsuarios.getSelectionModel().getSelectedItem());
            listUsuarios.remove(tbUsuarios.getSelectionModel().getSelectedItem());
            tbUsuarios.getSelectionModel().clearSelection();
            limpiarUsuario();
            mostrarMensaje("Usuario Eliminado con Éxito.");

        } else {
            mostrarError("No has Seleccionado ningún Usuario.");
        }
    }

    public void eliminarLibroDigital() {
        Libro libroSeleccionado = tbLibrosDigitales.getSelectionModel().getSelectedItem();
        for (Reserva reserva : app.getListReservas()) {
            if (reserva.getLibro().equals(libroSeleccionado)) {
                mostrarError("El libro se encuentra Reservado.");
                return;
            }

        }


        if (libroSeleccionado != null) {
            bibliotecarioController.eliminarLibro(libroSeleccionado);
            listLibrosDigitales.remove(libroSeleccionado);
            app.getListLibros().remove(libroSeleccionado);

            tbLibrosDigitales.getSelectionModel().clearSelection();
            mostrarMensaje("Libro eliminado con éxito.");
        } else {
            mostrarError("No has seleccionado ningún libro.");
        }
    }

    public void eliminarLibroReferencia() {
        Libro libroSeleccionado = tbLibrosReferencias.getSelectionModel().getSelectedItem();
        for (Reserva reserva : app.getListReservas()) {
            if (reserva.getLibro().equals(libroSeleccionado)) {
                mostrarError("El libro se encuentra Reservado.");
                return;
            }

        }
        if (libroSeleccionado != null) {
            bibliotecarioController.eliminarLibro(libroSeleccionado);
            listLibrosReferencias.remove(libroSeleccionado);

            ObservableList<Libro> lista = FXCollections.observableArrayList(app.getListLibros());
            lista.remove(libroSeleccionado);
            app.setListLibros(lista);

            tbLibrosReferencias.getSelectionModel().clearSelection();
            mostrarMensaje("Libro eliminado con éxito.");
        } else {
            mostrarError("No has seleccionado ningún libro.");
        }
    }

    public void eliminarLibroFisico() {
        Libro libroSeleccionado = tbLibrosFisicos.getSelectionModel().getSelectedItem();
        for (Reserva reserva : app.getListReservas()) {
            if (reserva.getLibro().equals(libroSeleccionado)) {
                mostrarError("El libro se encuentra Reservado.");
                return;
            }

        }
        if (libroSeleccionado != null) {
            bibliotecarioController.eliminarLibro(libroSeleccionado);
            listLibrosFisicos.remove(libroSeleccionado);

            ObservableList<Libro> lista = FXCollections.observableArrayList(app.getListLibros());
            lista.remove(libroSeleccionado);
            app.setListLibros(lista);

            tbLibrosFisicos.getSelectionModel().clearSelection();
            mostrarMensaje("Libro eliminado con éxito.");
        } else {
            mostrarError("No has seleccionado ningún libro.");
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

    public void obtenerInformacionReserva() {
        if (tbReservas.getSelectionModel().getSelectedItem() != null) {
            String cedulaUsuario = tbReservas.getSelectionModel().getSelectedItem().getUsuario().getCedula();
            String LibroReserva = tbReservas.getSelectionModel().getSelectedItem().getLibro().getTitulo();
            int tiempo = tbReservas.getSelectionModel().getSelectedItem().getTiempoDias();

            tfUsuarioReserva.setText(cedulaUsuario);
            tfLibroReserva.setText(LibroReserva);
            tfTiempoReserva.setText(String.valueOf(tiempo));

        }


    }


    public void obtenerInformacionLibroDigital() {
        if (tbLibrosDigitales.getSelectionModel().getSelectedItem() != null) {
            Libro libro = tbLibrosDigitales.getSelectionModel().getSelectedItem();

            String titulo = libro.getTitulo();
            String autor = libro.getAutor();
            String genero = libro.getGenero();
            int anio = libro.getAnio();
            boolean disponible = libro.isEstaDisponible();

            tfTituloDigital.setText(titulo);
            tfAutorDigital.setText(autor);
            tfGeneroDigital.setText(genero);
            tfAnioDigital.setText(String.valueOf(anio));
            chbDisponibleDigital.setSelected(disponible);

            if (libro instanceof LibroDigital libroDigital) {
                FormatoDigital formato = libroDigital.getFormatoDigital();
                cbFormato.setValue(formato);
            } else {
                cbFormato.setValue(null);
            }
        }
    }
    public void obtenerInformacionLibroReferencia() {
        if (tbLibrosReferencias.getSelectionModel().getSelectedItem() != null) {
            Libro libro = tbLibrosReferencias.getSelectionModel().getSelectedItem();

            if (libro instanceof LibroReferencia) {
                LibroReferencia libroRef = (LibroReferencia) libro;

                String titulo = libroRef.getTitulo();
                String autor = libroRef.getAutor();
                String editorial = libroRef.getEditorial();
                String genero = libroRef.getGenero();
                int anio = libroRef.getAnio();

                tfTituloReferencia.setText(titulo);
                tfAutorReferencia.setText(autor);
                tfEditorialReferencia.setText(editorial);
                tfGeneroReferencia.setText(genero);
                tfAnioReferencia.setText(String.valueOf(anio));
            }
        }
    }

    public void obtenerInformacionLibroFisico() {
        if (tbLibrosFisicos.getSelectionModel().getSelectedItem() != null) {
            Libro libro = tbLibrosFisicos.getSelectionModel().getSelectedItem();

            if (libro instanceof LibroFisico) {
                LibroFisico libroFisico = (LibroFisico) libro;

                String titulo = libroFisico.getTitulo();
                String editorial = libroFisico.getEditorial();
                String autor = libroFisico.getAutor();
                String genero = libroFisico.getGenero();
                int anio = libroFisico.getAnio();
                boolean disponible = libroFisico.isEstaDisponible();


                tfTituloFisico.setText(titulo);
                tfEditorialFisico.setText(editorial);
                tfAutorFisico.setText(autor);
                tfGeneroFisico.setText(genero);
                tfAnioFisico.setText(String.valueOf(anio));
                chbDisponibleFisico.setSelected(disponible);

            }
        }
    }


    public void modificarLibroReferencia() {
        if (tbLibrosReferencias.getSelectionModel().getSelectedItem() != null) {
            Libro libro = tbLibrosReferencias.getSelectionModel().getSelectedItem();

            if (libro instanceof LibroReferencia) {
                String titulo = tfTituloReferencia.getText();
                String autor = tfAutorReferencia.getText();
                String editorial = tfEditorialReferencia.getText();
                String genero = tfGeneroReferencia.getText();
                String anioTexto = tfAnioReferencia.getText();

                if (titulo.isEmpty() || autor.isEmpty() || editorial.isEmpty() || genero.isEmpty() || anioTexto.isEmpty()) {
                    mostrarError("Hay celdas vacías.");
                    return;
                }

                int anio;
                try {
                    anio = Integer.parseInt(anioTexto);
                } catch (NumberFormatException e) {
                    mostrarError("El año debe ser un número.");
                    return;
                }

                LibroReferencia libroRef = (LibroReferencia) libro;
                libroRef.setTitulo(titulo);
                libroRef.setAutor(autor);
                libroRef.setEditorial(editorial);
                libroRef.setGenero(genero);
                libroRef.setAnio(anio);

                tbLibrosReferencias.refresh();
                mostrarMensaje("Libro modificado con Éxito.");

            }
        } else {
            mostrarError("Seleccione un libro de referencia para modificar.");
        }
    }




    public void modificarLibroDigital() {
        Libro libroSeleccionado = tbLibrosDigitales.getSelectionModel().getSelectedItem();

        if (libroSeleccionado == null) {
            mostrarError("Seleccione un libro digital de la tabla para modificar.");
            return;
        }

        if (!(libroSeleccionado instanceof LibroDigital)) {
            mostrarError("El libro seleccionado no es un libro digital.");
            return;
        }

        String titulo = tfTituloDigital.getText();
        String autor = tfAutorDigital.getText();
        String genero = tfGeneroDigital.getText();
        String anioTexto = tfAnioDigital.getText();
        boolean disponible = chbDisponibleDigital.isSelected();
        FormatoDigital formato = cbFormato.getSelectionModel().getSelectedItem();

        if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || anioTexto.isEmpty()) {
            mostrarError("Todos los campos deben estar llenos.");
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioTexto);
        } catch (NumberFormatException e) {
            mostrarError("El año debe ser un número entero.");
            return;
        }

        if (formato == null) {
            mostrarError("Debe seleccionar un formato digital.");
            return;
        }


        LibroDigital libroDigital = (LibroDigital) libroSeleccionado;
        libroDigital.setTitulo(titulo);
        libroDigital.setAutor(autor);
        libroDigital.setGenero(genero);
        libroDigital.setAnio(anio);
        libroDigital.setEstaDisponible(disponible);
        libroDigital.setFormatoDigital(formato);


        tbLibrosDigitales.refresh();
        mostrarMensaje("Libro modificado con Éxito.");


    }

    public void modificarLibroFisico() {
        Libro libroSeleccionado = tbLibrosFisicos.getSelectionModel().getSelectedItem();

        if (libroSeleccionado == null) {
            mostrarError("Seleccione un libro físico de la tabla para modificar.");
            return;
        }

        if (!(libroSeleccionado instanceof LibroFisico)) {
            mostrarError("El libro seleccionado no es un libro físico.");
            return;
        }

        String titulo = tfTituloFisico.getText();
        String autor = tfAutorFisico.getText();
        String genero = tfGeneroFisico.getText();
        String anioTexto = tfAnioFisico.getText();
        boolean disponible = chbDisponibleFisico.isSelected();

        String editorial = tfEditorialFisico.getText();


        if (titulo.isEmpty() || autor.isEmpty() || genero.isEmpty() || anioTexto.isEmpty() || editorial.isEmpty() ) {
            mostrarError("Todos los campos deben estar llenos.");
            return;
        }

        int anio;
        int paginas;
        try {
            anio = Integer.parseInt(anioTexto);
        } catch (NumberFormatException e) {
            mostrarError("El año debe ser un número entero.");
            return;
        }

        LibroFisico libroFisico = (LibroFisico) libroSeleccionado;
        libroFisico.setTitulo(titulo);
        libroFisico.setAutor(autor);
        libroFisico.setGenero(genero);
        libroFisico.setAnio(anio);
        libroFisico.setEstaDisponible(disponible);
        libroFisico.setEditorial(editorial);


        tbLibrosFisicos.refresh();
        mostrarMensaje("Libro físico modificado con éxito.");
    }




    public void modificarUsuario() {
        Usuario seleccionado = tbUsuarios.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarError("Debe seleccionar un Usuario para modificar.");
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
            mostrarMensaje("Usuario modificado con Éxito.");

        }
    }


    public void setListReservas(ObservableList<Reserva> listReservas) {
        this.listReservas = listReservas;
        if (tbReservas != null) {
            tbReservas.setItems(this.listReservas);
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


    public void setListLibrosReferencia(ObservableList<Libro> listLibros) {
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

    public void setListLibrosDigitales(ObservableList<Libro> listLibros) {
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


    public void limpiarUsuario() {
        tbUsuarios.getSelectionModel().clearSelection();

        tfNombreUsuario.clear();
        tfCedulaUsuario.clear();
        tfCorreoUsuario.clear();
        tfContraseniaUsuario.clear();
    }


    public void limpiarReserva() {
        tbReservas.getSelectionModel().clearSelection();

        tfUsuarioReserva.clear();
        tfLibroReserva.clear();
        tfTiempoReserva.clear();

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

    public void refrehLibros() {
        tbLibrosFisicos.refresh();
        tbLibrosReferencias.refresh();
        tbLibrosDigitales.refresh();
    }

    public void generarGraficaLibros(List<Libro> libros) {
        PieChart pieChart = pcGraficaLibros;
        ObservableList<Libro> librosFisicos = FXCollections.observableArrayList();
        ObservableList<Libro> librosReferencias = FXCollections.observableArrayList();
        ObservableList<Libro> librosDigitales = FXCollections.observableArrayList();
        double fisicos = 0 ;
        double referencias = 0;
        double digitales  = 0;

        for (Libro libroFisico : libros) {
            if (libroFisico.getTipoLibro() == TipoLibro.FISICO) {
                librosFisicos.add(libroFisico);
            } else if (libroFisico.getTipoLibro() == TipoLibro.REFERENCIA) {
                librosReferencias.add(libroFisico);

            } else if (libroFisico.getTipoLibro() == TipoLibro.DIGITAL) {
                librosDigitales.add(libroFisico);
            }
        }
        if (tbLibrosFisicos != null) {
            fisicos = librosFisicos.size();
        }
        if (tbLibrosReferencias != null) {
            referencias = librosReferencias.size();
        }
        if (tbLibrosDigitales != null) {
            digitales = librosDigitales.size();
        }
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Libros Fisicos", fisicos),
                new PieChart.Data("Libros Referencias", referencias),
                new PieChart.Data("Libros Digitales", digitales)
        );
         pieChart.setData(pieChartData);


    }





    public void initialize() {


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
        tbLibrosDigitales.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                obtenerInformacionLibroDigital();
            }
        });
        tbLibrosReferencias.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                obtenerInformacionLibroReferencia();
            }
        });
        tbLibrosFisicos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                obtenerInformacionLibroFisico();
            }
        });


        cbFormato.setItems(FXCollections.observableArrayList(FormatoDigital.PDF, FormatoDigital.EPUB, FormatoDigital.MOBI));




    }

}





