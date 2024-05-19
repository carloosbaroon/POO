package org.cbaron.api.stream.ejemplos;

import org.cbaron.api.stream.ejemplos.models.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStreamParallel {
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

        long t1 = System.currentTimeMillis();
        //Here we convert to a String with the concat
        String resultado = lista.stream()
                .parallel()
                .map(u -> u.toString().toUpperCase())
                .peek(System.out::println)
                .flatMap(nombre -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (nombre.contains("JOSE")){
                        return Stream.of(nombre);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo total: " + (t2 - t1));
        System.out.println(resultado);
    }
}
