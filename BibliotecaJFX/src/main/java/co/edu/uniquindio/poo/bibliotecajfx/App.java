package co.edu.uniquindio.poo.bibliotecajfx;

import co.edu.uniquindio.poo.bibliotecajfx.Controller.AdministradorController;
import co.edu.uniquindio.poo.bibliotecajfx.Model.*;
import co.edu.uniquindio.poo.bibliotecajfx.viewController.PantallaBienvenidaViewController;
import co.edu.uniquindio.poo.bibliotecajfx.viewController.PantallaCredencialesEmpleadoViewController;
import co.edu.uniquindio.poo.bibliotecajfx.viewController.PantallaCredencialesUsuarioViewController;
import co.edu.uniquindio.poo.bibliotecajfx.viewController.PantallaVisitanteViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class App extends Application {
    private Stage stage;
    private final Biblioteca bliblioteca = new Biblioteca("Universidad del Quindio",1234,"Cra 15 #12N, Armenia, Quindío");
    private final Administrador administrador = new Administrador("Juan Sebastian Zambrano", "1145724059", "contraseña", bliblioteca);
    private final Bibliotecario bibliotecario = new Bibliotecario("Miguel Giraldo","123456789","Contrasenia",bliblioteca);



    @Override
    public void start(Stage primaryStage) {
        inicializarData();
        this.stage = primaryStage;
        primaryStage.setTitle("BibliotecaUQ");
        openPantallaBienvenida();
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
            AdministradorController administradorController = new AdministradorController(this.administrador);
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
            AdministradorController administradorController = new AdministradorController(this.administrador);
            controlador.setAdministradorController(administradorController);


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
        administrador.agregarAdministrador(administrador);
        administrador.agregarBibliotecario(bibliotecario);


        Estudiante estudiante1 = new Estudiante("Ana Gómez", "123456", "ana@gemail.com", "pass123");
        bibliotecario.registrarEstudiante(estudiante1);
        Estudiante estudiante2 = new Estudiante("Carlos Pérez", "234567", "carlos@correo.com", "carlospass");
        bibliotecario.registrarEstudiante(estudiante2);
        Estudiante estudiante3 = new Estudiante("Lucía Martínez", "345678", "lucia@uni.com", "lucia123");
        bibliotecario.registrarEstudiante(estudiante3);
        Estudiante estudiante4 = new Estudiante("Juan Torres", "456789", "juan@estudiantes.com", "juan456");
        bibliotecario.registrarEstudiante(estudiante4);
        Estudiante estudiante5 = new Estudiante("Marta Ruiz", "567890", "marta@email.com", "marta789");
        bibliotecario.registrarEstudiante(estudiante5);

        Docente docente1 = new Docente("Luis Herrera", "101001", "luis@universidad.com", "docente123");
        bibliotecario.registrarDocente(docente1);
        Docente docente2 = new Docente("María Restrepo", "101002", "maria@universidad.com", "restrepo456");
        bibliotecario.registrarDocente(docente2);
        Docente docente3 = new Docente("Pedro Salazar", "101003", "pedro@universidad.com", "salazar789");
        bibliotecario.registrarDocente(docente3);
        Docente docente4 = new Docente("Claudia López", "101004", "claudia@universidad.com", "claudia2024");
        bibliotecario.registrarDocente(docente4);
        Docente docente5 = new Docente("Andrés Villa", "101005", "andres@universidad.com", "villaabc");
        bibliotecario.registrarDocente(docente5);

        LibroFisico libro1 = new LibroFisico("Cien años de soledad", "Gabriel García Márquez", "Sudamericana", "Realismo mágico", 1967);
        bibliotecario.registrarLibroFisico(libro1);
        LibroFisico libro2 = new LibroFisico("Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "Novela", 1605);
        bibliotecario.registrarLibroFisico(libro2);
        LibroFisico libro3 = new LibroFisico("1984", "George Orwell", "Secker & Warburg", "Distopía", 1949);
        bibliotecario.registrarLibroFisico(libro3);
        LibroFisico libro4 = new LibroFisico("El Principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "Fábula", 1943);
        bibliotecario.registrarLibroFisico(libro4);
        LibroFisico libro5 = new LibroFisico("La Sombra del Viento", "Carlos Ruiz Zafón", "Planeta", "Misterio", 2001);
        bibliotecario.registrarLibroFisico(libro5);

        LibroDigital libroD1 = new LibroDigital("Aprendiendo Java", "Ana Torres", "TechBooks", "Educativo", 2020, FormatoDigital.PDF, "https://descargas.com/Java2020.pdf");
        bibliotecario.registrarLibroDigital(libroD1);
        LibroDigital libroD2 = new LibroDigital("Historia Universal", "Carlos Medina", "HistoriaEd", "Historia", 2018, FormatoDigital.EPUB, "https://descargas.com/Historia2018.epub");
        bibliotecario.registrarLibroDigital(libroD2);
        LibroDigital libroD3 = new LibroDigital("Cuentos para dormir", "Lucía Martínez", "Fábulas SA", "Infantil", 2022, FormatoDigital.MOBI, "https://descargas.com/Cuentos2022.mobi");
        bibliotecario.registrarLibroDigital(libroD3);

        LibroReferencia ref1 = new LibroReferencia("Enciclopedia de Ciencias", "Marcos Díaz", "CienciaPlus", "Ciencia", 2015);
        bibliotecario.registrarLibroReferencia(ref1);
        LibroReferencia ref2 = new LibroReferencia("Atlas Mundial", "Laura Méndez", "GeoEditores", "Geografía", 2018);
        bibliotecario.registrarLibroReferencia(ref2);
        LibroReferencia ref3 = new LibroReferencia("Diccionario de Lengua Española", "RAE", "Espasa", "Lengua", 2020);
        bibliotecario.registrarLibroReferencia(ref3);

       bibliotecario.prestarLibro(libro1,estudiante1,10);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
