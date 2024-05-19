package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamFilter {
    public static void main(String[] args) {

        // Here the peak shows the values toUpperCase() and then then foreach/toList toLowerCase()
        Stream<Usuario> nombres = Stream
                .of("Aleph Baron", "Carlos Baron", "Pato Gonzalez", "Pepe Gutierrez", "Paco Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepe"))
                .peek(System.out::println);

        List<Usuario> list = nombres.toList();
        System.out.println("=======================");
        list.forEach(u -> System.out.println(u.getNombre()));
        list.forEach(u -> System.out.println(u.getApellido()));
        //nombres.forEach(System.out::println);

    }
}
