package org.cbaron.ejemplos.list;

import org.cbaron.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploListComparableComparator {
    public static void main(String[] args) {

        List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Carlos", 5));
        sa.add(new Alumno("Aleph", 6));
        sa.add(new Alumno("Bob", 4));
        sa.add(new Alumno("John", 7));
        sa.add(new Alumno("Julia", 3));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus", 3));

        //Using our own implementation of compareTo()
        //Collections.sort(sa);

        //Using a Comparator
        //Collections.sort(sa,(a, b) -> a.getNombre().compareTo(b.getNombre()));

        //sa.sort((a, b) -> a.getNombre().compareTo(b.getNombre()));

        sa.sort(Comparator.comparing(Alumno::getNombre).reversed());

        System.out.println(sa);

        System.out.println("Iterando usando expresiones lamba con foreach");
        sa.forEach(a -> System.out.println(a.getNombre()));

    }
}
