package co.edu.uniquindio.poo;

public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine("Royal","1234");
        Funcion funcion = new FuncionVIP("LosAvengers",207,"noche",150,true,false);
        System.out.println(funcion.calcularPrecio());

    }

}