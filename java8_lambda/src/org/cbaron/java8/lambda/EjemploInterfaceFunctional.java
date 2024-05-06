package org.cbaron.java8.lambda;

import org.cbaron.java8.lambda.aritmetica.Aritmetica;
import org.cbaron.java8.lambda.aritmetica.Calculadora;

public class EjemploInterfaceFunctional {
    public static void main(String[] args) {

        Aritmetica suma = Double::sum;
        Aritmetica resta = (a, b) -> a - b;

        Calculadora cal = new Calculadora();
        System.out.println(cal.computar(10, 5, suma));
        System.out.println(cal.computar(10, 5, resta));
        System.out.println(cal.computar(10, 5, (x, y) -> x * y));

        System.out.println(cal.computarBiFunction(10, 5, (a, b) -> a + b));
    }
}
