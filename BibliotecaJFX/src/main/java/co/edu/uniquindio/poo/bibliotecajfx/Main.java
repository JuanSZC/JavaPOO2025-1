package co.edu.uniquindio.poo.bibliotecajfx;

import co.edu.uniquindio.poo.bibliotecajfx.Model.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca("BibliotecaUQ",202501,"por ahi");
        Administrador administrador = new Administrador("Jose Fernando",123,"1234",biblioteca);
        Bibliotecario bibliotecario = new Bibliotecario("Miguel Zapata",456,"4321",biblioteca);

        LibroFisico libro = new LibroFisico("a","b","c","d",1,true);

        Usuario usuario = new Estudiante("Fernando Rodriguez",123,"uq@uq","fe01");

        bibliotecario.registrarUsuario(usuario);
        bibliotecario.prestarLibro(libro,usuario,10);
        System.out.println(biblioteca.getListReservas());
        administrador.compararCredenciales("asdasd","dsknfsdklnf");
        bibliotecario.registrarUsuario(usuario);
    }
}
