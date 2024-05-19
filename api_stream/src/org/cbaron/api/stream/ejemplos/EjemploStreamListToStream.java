package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStreamListToStream {
    public static void main(String[] args) {

        List<Usuario> lista = new ArrayList<Usuario>();
        lista.add(new Usuario("Aleph", "Baron"));
        lista.add(new Usuario("Bob", "Brown"));
        lista.add(new Usuario("Carlos", "Baron"));
        lista.add(new Usuario("Pepe", "Gonzalez"));
        lista.add(new Usuario("Luis", "Gonzalez"));
        lista.add(new Usuario("Mike", "Mena"));
        lista.add(new Usuario("Juan", "Fernandez"));
        lista.add(new Usuario("Jose", "Fernandez"));
        lista.add(new Usuario("Jose", "Perez"));

        //Here we convert to a String with the concat
        Stream<String> nombres = lista.stream()
                .map(u -> u.getNombre().toUpperCase()
                .concat(" ")
                .concat(u.getApellido().toUpperCase()))
                .flatMap(nombre -> {
                    if (nombre.contains("JOSE")){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .map(String::toLowerCase)
                .peek(System.out::println);
        System.out.println(nombres.count());
    }
}
