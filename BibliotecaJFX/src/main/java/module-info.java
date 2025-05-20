module co.edu.uniquindio.poo.bibliotecajfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens co.edu.uniquindio.poo.bibliotecajfx to javafx.fxml;
    exports co.edu.uniquindio.poo.bibliotecajfx;
}