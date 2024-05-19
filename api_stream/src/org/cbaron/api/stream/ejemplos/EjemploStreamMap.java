package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStreamMap {
    public static void main(String[] args) {

        // Here the peak shows the values toUpperCase() and then then foreach/toList toLowerCase()
        Stream<Usuario> nombres = Stream
                .of("Aleph Baron", "Carlos Baron", "Pato Gonzalez", "Pepe Gutierrez", "Paco Mena")
                .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
                .peek(u -> System.out.println(u.getNombre()))
                .peek(u -> System.out.println(u.getApellido()))
                .map(usuario -> {
                  String nombre = usuario.getNombre().toLowerCase();
                  String apellido = usuario.getApellido().toLowerCase();
                  usuario.setNombre(nombre);
                  usuario.setApellido(apellido);
                  return usuario;
                })
                .peek(u -> System.out.println(u.getNombre()))
                .peek(u -> System.out.println(u.getApellido()));
        List<Usuario> list = nombres.toList();
        System.out.println("=======================");
        list.forEach(u -> System.out.println(u.getNombre()));
        list.forEach(u -> System.out.println(u.getApellido()));
        //nombres.forEach(System.out::println);

    }
}
