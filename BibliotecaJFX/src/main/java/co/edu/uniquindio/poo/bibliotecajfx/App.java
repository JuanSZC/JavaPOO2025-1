package co.edu.uniquindio.poo.bibliotecajfx;

import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Controller.BibliotecarioController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import co.edu.uniquindio.poo.bibliotecajfx.viewController.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private Stage stage;
    private final Biblioteca biblioteca = new Biblioteca("Universidad del Quindio",1234,"Cra 15 #12N, Armenia, Quindío");
    private final Administrador administradorPrincipal = new Administrador("Juan Sebastian Zambrano", "1145724059", "contraseña", biblioteca);
    private final Bibliotecario bibliotecarioPrincipal = new Bibliotecario("Miguel Giraldo","123456789","Contrasenia",biblioteca);
    Usuario usuarioSesion;
    ObservableList<Usuario> listUsuarios;
    ObservableList<Libro> listLibros;
    ObservableList<Empleado> listEmpleados;
    ObservableList<Reserva> listReservas;



    @Override
    public void start(Stage primaryStage) {
        inicializarData();
        this.stage = primaryStage;
        primaryStage.setTitle("BibliotecaUQ");
        openPantallaBienvenida();

    }
    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }
    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }

    public void openPantallaBienvenida() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bibliotecajfx/pantallaBienvenida.fxml"));
            AnchorPane rootLayout = loader.load();

            PantallaBienvenidaViewController pantallaBienvenidaViewController = loader.getController();
            pantallaBienvenidaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();

            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void openPantallaCredencialesEmpleado(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bibliotecajfx/pantallaCredencialesEmpleado.fxml"));
            AnchorPane rootLayout= loader.load();

            PantallaCredencialesEmpleadoViewController controlador = loader.getController();
            controlador.setApp(this);

            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();

            stage.show();
            AdministradorController administradorController = new AdministradorController(this.administradorPrincipal);
            controlador.setAdministradorController(administradorController);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaCredencialesUsuario(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bibliotecajfx/pantallaCredencialesUsuario.fxml"));
            AnchorPane rootLayout= loader.load();

            PantallaCredencialesUsuarioViewController controlador = loader.getController();
            controlador.setApp(this);

            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            stage.setResizable(false);
            stage.centerOnScreen();
            AdministradorController administradorController = new AdministradorController(this.administradorPrincipal);
            controlador.setAdministradorController(administradorController);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaAdministrador(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bibliotecajfx/pantallaAdministrador.fxml"));
            AnchorPane rootLayout= loader.load();

            PantallaAdministradorViewController controlador = loader.getController();
            controlador.setApp(this);

            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaBibliotecario(){

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bibliotecajfx/pantallaBibliotecario.fxml"));
            AnchorPane rootLayout= loader.load();

            PantallaBibliotecarioViewController controlador = loader.getController();
            BibliotecarioController bibliotecarioControlador = new BibliotecarioController(this.bibliotecarioPrincipal);
            controlador.setApp(this);


            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();
            controlador.setListLibros(this.listLibros);
            controlador.setListUsuarios(this.listUsuarios);
            controlador.setListLibrosFisicos(this.listLibros);
            controlador.setListLibrosDigitales(this.listLibros);
            controlador.setListLibrosReferencia(this.listLibros);
            controlador.setListReservas(this.listReservas);

            controlador.setBibliotecarioController(bibliotecarioControlador);





        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void openPantallaUsuario(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bibliotecajfx/pantallaUsuario.fxml"));
            AnchorPane rootLayout= loader.load();

            PantallaUsuarioViewController controlador = loader.getController();
            controlador.setApp(this);
            controlador.setListLibros(this.listLibros);

            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();



        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaVisitante(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/bibliotecajfx/pantallaVisitante.fxml"));
            AnchorPane rootLayout= loader.load();

            PantallaVisitanteViewController controlador = loader.getController();
            controlador.setApp(this);

            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }





    public void inicializarData() {
        administradorPrincipal.agregarAdministrador(administradorPrincipal);
        administradorPrincipal.agregarBibliotecario(bibliotecarioPrincipal);


        Estudiante estudiante1 = new Estudiante("Ana Gómez", "123456", "ana@gemail.com", "pass123");
        bibliotecarioPrincipal.registrarEstudiante(estudiante1);
        Estudiante estudiante2 = new Estudiante("Carlos Pérez", "234567", "carlos@correo.com", "carlospass");
        bibliotecarioPrincipal.registrarEstudiante(estudiante2);
        Estudiante estudiante3 = new Estudiante("Lucía Martínez", "345678", "lucia@uni.com", "lucia123");
        bibliotecarioPrincipal.registrarEstudiante(estudiante3);
        Estudiante estudiante4 = new Estudiante("Juan Torres", "456789", "juan@estudiantes.com", "juan456");
        bibliotecarioPrincipal.registrarEstudiante(estudiante4);
        Estudiante estudiante5 = new Estudiante("Marta Ruiz", "567890", "marta@email.com", "marta789");
        bibliotecarioPrincipal.registrarEstudiante(estudiante5);

        Docente docente1 = new Docente("Luis Herrera", "101001", "luis@universidad.com", "docente123");
        bibliotecarioPrincipal.registrarDocente(docente1);
        Docente docente2 = new Docente("María Restrepo", "101002", "maria@universidad.com", "restrepo456");
        bibliotecarioPrincipal.registrarDocente(docente2);
        Docente docente3 = new Docente("Pedro Salazar", "101003", "pedro@universidad.com", "salazar789");
        bibliotecarioPrincipal.registrarDocente(docente3);
        Docente docente4 = new Docente("Claudia López", "101004", "claudia@universidad.com", "claudia2024");
        bibliotecarioPrincipal.registrarDocente(docente4);
        Docente docente5 = new Docente("Andrés Villa", "101005", "andres@universidad.com", "villaabc");
        bibliotecarioPrincipal.registrarDocente(docente5);

        LibroFisico libro1 = new LibroFisico("Cien años de soledad", "Gabriel García Márquez", "Sudamericana", "Realismo mágico", 1967,true);
        bibliotecarioPrincipal.registrarLibroFisico(libro1);
        LibroFisico libro2 = new LibroFisico("Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "Novela", 1605,false);
        bibliotecarioPrincipal.registrarLibroFisico(libro2);
        LibroFisico libro3 = new LibroFisico("1984", "George Orwell", "Secker & Warburg", "Distopía", 1949,true);
        bibliotecarioPrincipal.registrarLibroFisico(libro3);
        LibroFisico libro4 = new LibroFisico("El Principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "Fábula", 1943,true);
        bibliotecarioPrincipal.registrarLibroFisico(libro4);
        LibroFisico libro5 = new LibroFisico("La Sombra del Viento", "Carlos Ruiz Zafón", "Planeta", "Misterio", 2001,false);
        bibliotecarioPrincipal.registrarLibroFisico(libro5);

        LibroDigital libroD1 = new LibroDigital("Aprendiendo Java", "Ana Torres", "TechBooks", "Educativo", 2020, FormatoDigital.PDF, "https://descargas.com/Java2020.pdf",true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD1);
        LibroDigital libroD2 = new LibroDigital("Historia Universal", "Carlos Medina", "HistoriaEd", "Historia", 2018, FormatoDigital.EPUB, "https://descargas.com/Historia2018.epub",false);
        bibliotecarioPrincipal.registrarLibroDigital(libroD2);
        LibroDigital libroD3 = new LibroDigital("Cuentos para dormir", "Lucía Martínez", "Fábulas SA", "Infantil", 2022, FormatoDigital.MOBI, "https://descargas.com/Cuentos2022.mobi",true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD3);

        LibroReferencia ref1 = new LibroReferencia("Enciclopedia de Ciencias", "Marcos Díaz", "CienciaPlus", "Ciencia", 2015);
        bibliotecarioPrincipal.registrarLibroReferencia(ref1);
        LibroReferencia ref2 = new LibroReferencia("Atlas Mundial", "Laura Méndez", "GeoEditores", "Geografía", 2018);
        bibliotecarioPrincipal.registrarLibroReferencia(ref2);
        LibroReferencia ref3 = new LibroReferencia("Diccionario de Lengua Española", "RAE", "Espasa", "Lengua", 2020);
        bibliotecarioPrincipal.registrarLibroReferencia(ref3);

        bibliotecarioPrincipal.prestarLibro(libro1,estudiante1,10);


       listUsuarios = FXCollections.observableArrayList(biblioteca.getListUsuarios());
       listEmpleados= FXCollections.observableArrayList(biblioteca.getListEmpleados());
       listLibros = FXCollections.observableArrayList(biblioteca.getListLibros());
       listReservas = FXCollections.observableArrayList(biblioteca.getListReservas());



    }



    public static void main(String[] args) {
        launch(args);
    }
}
