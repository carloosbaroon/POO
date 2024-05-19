package org.cbaron.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {

        Stream<String> nombres = Stream.of("Aleph", "Carlos", "Pato", "Pepe", "Paco");

        //Operador terminal por regresar un void
        nombres.forEach(System.out::println);

        System.out.println("=======================");

        String[] nombresArray = {"Aleph", "Carlos", "Pato", "Pepe", "Paco"};
        Stream<String> nombresStream = Arrays.stream(nombresArray);

        nombresStream.forEach(System.out::println);

        System.out.println("=======================");

        Stream<String> nombresBuilder = Stream.<String>builder().add("Aleph")
                .add("Carlos")
                .add("Pato")
                .add("Pepe")
                .add("Paco")
                .build();

        nombresBuilder.forEach(System.out::println);

        System.out.println("=======================");

        List<String> nombreList = new ArrayList<>();
        nombreList.add("Aleph");
        nombreList.add("Carlos");
        nombreList.add("Pato");
        nombreList.add("Pepe");
        nombreList.add("Paco");

        //Stream<String> nombresStreamList = nombreList.stream();
        //nombresStreamList.forEach(System.out::println);

        //Para evitar crear la variable Stream "nombresStreamList"
        nombreList.forEach(System.out::println);
    }
}
