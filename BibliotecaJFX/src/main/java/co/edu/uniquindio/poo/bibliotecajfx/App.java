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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private Stage stage;
    private final Biblioteca biblioteca = new Biblioteca("Universidad del Quindio",1234,"Cra 15 #12N, Armenia, Quindío");
    private final Administrador administradorPrincipal = new Administrador("Juan Sebastian Zambrano", "1145724059", "contraseña", biblioteca);
    private final Bibliotecario bibliotecarioPrincipal = new Bibliotecario("Samuel Cuervo","1145731491","20141714",biblioteca);
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
    public List<Libro> getListLibros(){
        return listLibros;
    }
    public List<Reserva> getListReservas(){
        return listReservas;
    }
    public List<Usuario> getListUsuarios(){
        return listUsuarios;
    }
    public List<Empleado> getListEmpleados(){
        return listEmpleados;
    }
    public void setListLibros(ObservableList<Libro> listLibros){
        this.listLibros = listLibros;
    }
    public void setListReservas(ObservableList<Reserva> listReservas){
        this.listReservas = listReservas;
    }
    public void setListUsuarios(ObservableList<Usuario> listUsuarios){
        this.listUsuarios = listUsuarios;
    }
    public void setListEmpleados (ObservableList<Empleado> listEmpleados){
        this.listEmpleados = listEmpleados;
    }

    public void setUsuarioSesion(Usuario usuarioSesion) {
        this.usuarioSesion = usuarioSesion;
    }
    public Usuario getUsuarioSesion() {
        return usuarioSesion;
    }
    public Biblioteca getBiblioteca() {
        return biblioteca;
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
            controlador.setListEmpleado(listEmpleados);
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
            AnchorPane rootLayout = loader.load();

            PantallaUsuarioViewController controlador = loader.getController();
            controlador.setApp(this);
            controlador.setListLibros(this.listLibros);
            controlador.setUsuarioSesion(this.usuarioSesion);
            ObservableList<Reserva> reservasUsuario = FXCollections.observableArrayList(usuarioSesion.getListReservasUsuario());
            controlador.setListReservas(reservasUsuario);

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





    public void inicializarData() {
        administradorPrincipal.agregarAdministrador(administradorPrincipal);
        administradorPrincipal.agregarBibliotecario(bibliotecarioPrincipal);

        Administrador administrador1 = new Administrador("Jose Roca","987654","Perro123",biblioteca);
        administradorPrincipal.agregarAdministrador(administrador1);

        Bibliotecario bibliotecario2 = new Bibliotecario("Laura Martinez","1122334455","clave1",biblioteca);
        Bibliotecario bibliotecario3 = new Bibliotecario("Carlos Ramirez","2233445566","clave2",biblioteca);
        Bibliotecario bibliotecario4 = new Bibliotecario("Sofia Lopez","3344556677","clave3",biblioteca);
        Bibliotecario bibliotecario5 = new Bibliotecario("Andres Gomez","4455667788","clave4",biblioteca);
        Bibliotecario bibliotecario6 = new Bibliotecario("Daniela Torres","5566778899","clave5",biblioteca);
        Bibliotecario bibliotecario7 = new Bibliotecario("Julian Moreno","6677889900","clave6",biblioteca);

        administradorPrincipal.agregarBibliotecario(bibliotecario2);
        administradorPrincipal.agregarBibliotecario(bibliotecario3);
        administradorPrincipal.agregarBibliotecario(bibliotecario4);
        administradorPrincipal.agregarBibliotecario(bibliotecario5);
        administradorPrincipal.agregarBibliotecario(bibliotecario6);
        administradorPrincipal.agregarBibliotecario(bibliotecario7);

        Administrador administrador2 = new Administrador("Lucia Vega","11221122","admin1",biblioteca);
        Administrador administrador3 = new Administrador("Miguel Pineda","22112211","admin2",biblioteca);
        Administrador administrador4 = new Administrador("Ana Guzman","33113311","admin3",biblioteca);
        Administrador administrador5 = new Administrador("Ricardo Nuñez","44114411","admin4",biblioteca);

        administradorPrincipal.agregarAdministrador(administrador2);
        administradorPrincipal.agregarAdministrador(administrador3);
        administradorPrincipal.agregarAdministrador(administrador4);
        administradorPrincipal.agregarAdministrador(administrador5);



        Estudiante estudiante1 = new Estudiante("Ana Gómez", "123456", "ana@gemail.com", "pass123",biblioteca);
        bibliotecarioPrincipal.registrarEstudiante(estudiante1);
        Estudiante estudiante2 = new Estudiante("Carlos Pérez", "234567", "carlos@correo.com", "carlospass",biblioteca);
        bibliotecarioPrincipal.registrarEstudiante(estudiante2);
        Estudiante estudiante3 = new Estudiante("Lucía Martínez", "345678", "lucia@uni.com", "lucia123",biblioteca);
        bibliotecarioPrincipal.registrarEstudiante(estudiante3);
        Estudiante estudiante4 = new Estudiante("Juan Torres", "456789", "juan@estudiantes.com", "juan456",biblioteca);
        bibliotecarioPrincipal.registrarEstudiante(estudiante4);
        Estudiante estudiante5 = new Estudiante("Marta Ruiz", "567890", "marta@email.com", "marta789",biblioteca);
        bibliotecarioPrincipal.registrarEstudiante(estudiante5);

        Docente docente1 = new Docente("Luis Herrera", "101001", "luis@universidad.com", "docente123",biblioteca);
        bibliotecarioPrincipal.registrarDocente(docente1);
        Docente docente2 = new Docente("María Restrepo", "101002", "maria@universidad.com", "restrepo456",biblioteca);
        bibliotecarioPrincipal.registrarDocente(docente2);
        Docente docente3 = new Docente("Pedro Salazar", "101003", "pedro@universidad.com", "salazar789",biblioteca);
        bibliotecarioPrincipal.registrarDocente(docente3);
        Docente docente4 = new Docente("Claudia López", "101004", "claudia@universidad.com", "claudia2024",biblioteca);
        bibliotecarioPrincipal.registrarDocente(docente4);
        Docente docente5 = new Docente("Andrés Villa", "101005", "andres@universidad.com", "villaabc",biblioteca);
        bibliotecarioPrincipal.registrarDocente(docente5);

        LibroFisico libro1 = new LibroFisico("Cien años de soledad", "Gabriel García Márquez", "Sudamericana", "Realismo mágico", 1967,true);
        bibliotecarioPrincipal.registrarLibroFisico(libro1);
        LibroFisico libro2 = new LibroFisico("Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "Novela", 1605,true);
        bibliotecarioPrincipal.registrarLibroFisico(libro2);
        LibroFisico libro3 = new LibroFisico("1984", "George Orwell", "Secker & Warburg", "Distopía", 1949,false);
        bibliotecarioPrincipal.registrarLibroFisico(libro3);
        LibroFisico libro4 = new LibroFisico("El Principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "Fábula", 1943,true);
        bibliotecarioPrincipal.registrarLibroFisico(libro4);
        LibroFisico libro5 = new LibroFisico("La Sombra del Viento", "Carlos Ruiz Zafón", "Planeta", "Misterio", 2001,false);
        bibliotecarioPrincipal.registrarLibroFisico(libro5);

        LibroDigital libroD1 = new LibroDigital("Aprendiendo Java", "Ana Torres", "TechBooks", "Educativo", 2020, FormatoDigital.PDF, "https://descargas.com/Java2020.pdf",true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD1);
        LibroDigital libroD2 = new LibroDigital("Historia Universal", "Carlos Medina", "HistoriaEd", "Historia", 2018, FormatoDigital.EPUB, "https://descargas.com/Historia2018.epub",true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD2);
        LibroDigital libroD3 = new LibroDigital("Cuentos para dormir", "Lucía Martínez", "Fábulas SA", "Infantil", 2022, FormatoDigital.MOBI, "https://descargas.com/Cuentos2022.mobi",true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD3);

        LibroFisico libro6 = new LibroFisico("Crónica de una muerte anunciada", "Gabriel García Márquez", "Oveja Negra", "Novela corta", 1981, false);
        bibliotecarioPrincipal.registrarLibroFisico(libro6);
        LibroFisico libro7 = new LibroFisico("Rayuela", "Julio Cortázar", "Sudamericana", "Narrativa", 1963, true);
        bibliotecarioPrincipal.registrarLibroFisico(libro7);
        LibroFisico libro8 = new LibroFisico("Ficciones", "Jorge Luis Borges", "Sur", "Cuento", 1944, true);
        bibliotecarioPrincipal.registrarLibroFisico(libro8);
        LibroFisico libro9 = new LibroFisico("Pedro Páramo", "Juan Rulfo", "Fondo de Cultura Económica", "Novela", 1955, true);
        bibliotecarioPrincipal.registrarLibroFisico(libro9);
        LibroFisico libro10 = new LibroFisico("Los detectives salvajes", "Roberto Bolaño", "Anagrama", "Ficción", 1998, true);
        bibliotecarioPrincipal.registrarLibroFisico(libro10);
        LibroDigital libroD4 = new LibroDigital("Inteligencia Artificial", "María Gómez", "TechToday", "Tecnología", 2021, FormatoDigital.PDF, "https://descargas.com/IA2021.pdf", true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD4);
        LibroDigital libroD5 = new LibroDigital("Economía para todos", "Luis Ramírez", "EconEdit", "Educativo", 2019, FormatoDigital.EPUB, "https://descargas.com/Economia2019.epub", true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD5);
        LibroDigital libroD6 = new LibroDigital("Programación Web", "Laura Pérez", "CodeBooks", "Tecnología", 2022, FormatoDigital.MOBI, "https://descargas.com/Web2022.mobi", true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD6);
        LibroDigital libroD7 = new LibroDigital("Psicología básica", "Iván Torres", "CienciaEd", "Ciencia", 2017, FormatoDigital.PDF, "https://descargas.com/Psicologia2017.pdf", true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD7);
        LibroDigital libroD8 = new LibroDigital("Guía de Fotografía", "Andrea Ruiz", "ArteVisual", "Arte", 2016, FormatoDigital.EPUB, "https://descargas.com/Fotografia2016.epub", true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD8);
        LibroFisico libro11 = new LibroFisico("Ensayo sobre la ceguera", "José Saramago", "Alfaguara", "Ficción", 1995, true);
        bibliotecarioPrincipal.registrarLibroFisico(libro11);
        LibroFisico libro12 = new LibroFisico("El túnel", "Ernesto Sabato", "Sur", "Novela", 1948, true);
        bibliotecarioPrincipal.registrarLibroFisico(libro12);
        LibroFisico libro13 = new LibroFisico("La ciudad y los perros", "Mario Vargas Llosa", "Seix Barral", "Drama", 1963, true);
        bibliotecarioPrincipal.registrarLibroFisico(libro13);
        LibroDigital libroD9 = new LibroDigital("Viajes interplanetarios", "Tomás Delgado", "FuturoPress", "Ciencia ficción", 2023, FormatoDigital.MOBI, "https://descargas.com/Viajes2023.mobi", true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD9);
        LibroDigital libroD10 = new LibroDigital("Manual de cocina saludable", "Paula Castaño", "NutriBooks", "Gastronomía", 2020, FormatoDigital.PDF, "https://descargas.com/Cocina2020.pdf", true);
        bibliotecarioPrincipal.registrarLibroDigital(libroD10);
        LibroReferencia ref1 = new LibroReferencia("Enciclopedia de Ciencias", "Marcos Díaz", "CienciaPlus", "Ciencia", 2015);
        bibliotecarioPrincipal.registrarLibroReferencia(ref1);
        LibroReferencia ref2 = new LibroReferencia("Atlas Mundial", "Laura Méndez", "GeoEditores", "Geografía", 2018);
        bibliotecarioPrincipal.registrarLibroReferencia(ref2);
        LibroReferencia ref3 = new LibroReferencia("Diccionario de Lengua Española", "RAE", "Espasa", "Lengua", 2020);
        bibliotecarioPrincipal.registrarLibroReferencia(ref3);

        Reserva reseva1 = new Reserva(libro3,estudiante1,5, LocalDate.of(2025,5,24));
        biblioteca.getListReservas().add(reseva1);
        estudiante1.getListReservasUsuario().add(reseva1);
        Reserva reseva2= new Reserva(libro5,estudiante2,2, LocalDate.of(2025,5,23));
        biblioteca.getListReservas().add(reseva2);

        estudiante2.getListReservasUsuario().add(reseva2);
        Reserva reseva3 = new Reserva(libro6,docente1,3, LocalDate.of(2025,5,22));
        biblioteca.getListReservas().add(reseva3);
        docente1.getListReservasUsuario().add(reseva3);



       listUsuarios = FXCollections.observableArrayList(biblioteca.getListUsuarios());
       listEmpleados= FXCollections.observableArrayList(biblioteca.getListEmpleados());
       listLibros = FXCollections.observableArrayList(biblioteca.getListLibros());
       listReservas = FXCollections.observableArrayList(biblioteca.getListReservas());



    }



    public static void main(String[] args) {
        launch(args);
    }
}
