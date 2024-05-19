package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDisctinct {
    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Aleph Baron", "Carlos Baron", "Pato Gonzalez", "Pepe Gutierrez", "Paco Mena", "Pepe Garcia", "Aleph Baron", "Aleph Baron", "Aleph Baron")
                .distinct();

        nombres.forEach(System.out::println);

    }
}
