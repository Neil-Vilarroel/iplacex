package com.ejemplo;

public class MiClase {
    public static void main(String[] args) {
        System.out.println("¡Hola, Mundo!");

        // Utilizando la calculadora
        Calculadora calculadora = new Calculadora();
        int resultadoSuma = calculadora.sumar(5, 3);
        int resultadoResta = calculadora.restar(10, 4);
        int resultadoMultiplicacion = calculadora.multiplicar(3, 7);
        double resultadoDivision = calculadora.dividir(15, 3);

        // Mostrar resultados
        System.out.println("Suma: " + resultadoSuma);
        System.out.println("Resta: " + resultadoResta);
        System.out.println("Multiplicación: " + resultadoMultiplicacion);
        System.out.println("División: " + resultadoDivision);
    }
}
