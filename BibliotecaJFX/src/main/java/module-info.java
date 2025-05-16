module co.edu.uniquindio.poo.bibliotecajfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.bibliotecajfx to javafx.fxml;
    exports co.edu.uniquindio.poo.bibliotecajfx;
}