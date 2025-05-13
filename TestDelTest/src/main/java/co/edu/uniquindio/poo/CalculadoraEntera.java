package co.edu.uniquindio.poo;

public class CalculadoraEntera {
    public int valor1;
    public int valor2;

    public CalculadoraEntera( int valor1, int valor2 ) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public int calcularSumaEntera( int valor1, int valor2 ) {
        return  valor1 + valor2;
    }
    public int calcularRestaEntera( int valor1, int valor2 ) {
        return  valor1 - valor2;
    }
    public int calcularMultiEntera( int valor1, int valor2 ) {
        return  valor1 * valor2;
    }
    public int calcularDivEntera( int valor1, int valor2 ) {
        return  valor1 / valor2;
    }
}

