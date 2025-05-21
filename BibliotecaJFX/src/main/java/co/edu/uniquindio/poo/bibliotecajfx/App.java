package co.edu.uniquindio.poo.bibliotecajfx;

import co.edu.uniquindio.poo.bibliotecajfx.Model.Biblioteca;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private Stage stage;
    Biblioteca biblioteca = new Biblioteca("UQ",202501,"Cra 15 #12N, Armenia, Quindío");

    @Override
    public void start(Stage primaryStage) {
        try {
            primaryStage.setTitle("BibliotecaJFX");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("pantallaCredencialesEmpleado.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openAdministradorView() {
        }





    public static void main(String[] args) {
        launch(args);
    }
}
