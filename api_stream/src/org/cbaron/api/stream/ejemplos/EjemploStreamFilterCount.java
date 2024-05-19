package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.stream.Stream;

public class EjemploStreamFilterCount {
    public static void main(String[] args) {


        long count = Stream
                .of("Aleph Baron", "Carlos Baron", "Pato Gonzalez", "Pepe Gutierrez", "Paco Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .count();

        System.out.println(count);


    }
}
