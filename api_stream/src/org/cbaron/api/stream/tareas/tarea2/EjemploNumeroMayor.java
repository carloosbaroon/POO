package org.cbaron.api.stream.tareas.tarea2;

import java.util.Arrays;
import java.util.function.Function;

public class EjemploNumeroMayor {
    public static void main(String[] args) {
        // la función lambda que obtiene el numero mayor del arreglo usando api stream en su implementación
        Function<Integer[], Integer> max = arr -> Arrays.stream(arr).reduce(0, (ac, e) -> ac > e? ac: e);

        int resultado = max.apply(new Integer[]{1, 78, -1700, 2500, 0, 2000, 54, 2});
        System.out.println(resultado);
    }
}
