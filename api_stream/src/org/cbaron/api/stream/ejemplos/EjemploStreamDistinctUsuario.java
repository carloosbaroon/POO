package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStreamDistinctUsuario {
    public static void main(String[] args) {

        Stream<Usuario> nombres = Stream
                .of("Aleph Baron", "Carlos Baron", "Pato Gonzalez", "Pepe Gutierrez", "Paco Mena", "Pepe Garcia", "Aleph Baron")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .distinct();

        nombres.forEach(System.out::println);
    }
}
