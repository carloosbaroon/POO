package org.cbaron.api.stream.ejemplos;

import java.util.stream.Stream;

public class EjemploStreamReduce {
    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Aleph Baron", "Carlos Baron", "Pato Gonzalez", "Pepe Gutierrez", "Paco Mena", "Pepe Garcia", "Aleph Baron", "Aleph Baron", "Aleph Baron")
                .distinct();

        String resultado = nombres.reduce("Resultado concatenacion", (a, b) -> a + ", " + b);
        System.out.println("resultado = " + resultado);

    }
}
