package org.cbaron.java8.lambda;

import java.util.concurrent.Future;
import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        Function<String, String> function1 = param -> "Hola que tal! " + param;
        String resultado = function1.apply("Aleph");
        System.out.println(resultado);

        Function<String, String> function2 = String::toUpperCase;
        System.out.println(function2.apply("Aleph"));

        BiFunction<String, String, String> function3 = (a, b) -> a.toUpperCase() + b.toUpperCase();
        String resultado2 = function3.apply("Aleph", "Carlos");
        System.out.println(resultado2);

        BiFunction<String, String, Integer> function4 = String::compareTo;
        System.out.println(function4.apply("Aleph", "Carlos"));
    }
}
