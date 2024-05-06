package org.cbaron.java8.lambda.tareas.ejercicio2;

import java.util.Map;

@FunctionalInterface
public interface ContadorPalabras {
    Map<String,Integer> contarPalabras(String frase);

}
