package org.cbaron.api.stream.ejemplos;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class EjemploStreamRange {
    public static void main(String[] args) {

        IntStream numeros = IntStream.range(5,20).peek(System.out::println);

        //int resultado = nombres.reduce(0, Integer::sum);
        //int resultado = numeros.sum();
        IntSummaryStatistics stats = numeros.summaryStatistics();
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Average: " + stats.getAverage());

    }
}
