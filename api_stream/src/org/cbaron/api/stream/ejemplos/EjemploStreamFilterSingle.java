package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamFilterSingle {
    public static void main(String[] args) {

        // Here the peak shows the values toUpperCase() and then then foreach/toList toLowerCase()
        Stream<Usuario> nombres = Stream
                .of("Aleph Baron", "Carlos Baron", "Pato Gonzalez", "Pepe Gutierrez", "Paco Mena", "Pepe Garcia")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .filter(u -> u.getNombre().equals("Pepex"))
                .peek(System.out::println);

        Optional<Usuario> usuario = nombres.findFirst();
        System.out.println("=======================");
        //System.out.println(usuario.orElse(new Usuario("John", "Doe")));
        //System.out.println(usuario.orElseGet(() -> new Usuario("John", "Doe")));
        if (usuario.isPresent()) {
            //System.out.println(usuario.orElseThrow());
            System.out.println(usuario.get());
        } else {
            System.out.println("No se encontro el objecto");
        }

        //nombres.forEach(System.out::println);

    }
}
