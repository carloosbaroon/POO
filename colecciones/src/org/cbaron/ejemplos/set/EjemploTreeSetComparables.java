package org.cbaron.ejemplos.set;

import org.cbaron.ejemplos.modelo.Alumno;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparables {
    public static void main(String[] args) {

        //Set<Alumno> sa = new TreeSet<>((a, b) -> a.getNombre().compareTo(b.getNombre()));
        Set<Alumno> sa = new TreeSet<>(Comparator.comparing(Alumno::getNombre).reversed());
        sa.add(new Alumno("Carlos", 5));
        sa.add(new Alumno("Aleph", 6));
        sa.add(new Alumno("Bob", 4));
        sa.add(new Alumno("John", 7));
        sa.add(new Alumno("Julia", 3));
        sa.add(new Alumno("Zeus", 2));

        System.out.println(sa);
    }
}
