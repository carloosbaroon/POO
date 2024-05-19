package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamFilterEmpty {
    public static void main(String[] args) {

        Long count = Stream
                .of("Aleph Baron", "Carlos Baron", "Pato Gonzalez", "", "Paco Mena", "")
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();

        System.out.println(count);



    }
}
