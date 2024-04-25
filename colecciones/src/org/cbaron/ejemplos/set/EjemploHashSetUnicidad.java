package org.cbaron.ejemplos.set;

import org.cbaron.ejemplos.modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {

        Set<Alumno> sa = new HashSet<>();
        //List<Alumno> sa = new ArrayList<>();
        sa.add(new Alumno("Carlos", 5));
        sa.add(new Alumno("Aleph", 6));
        sa.add(new Alumno("Bob", 4));
        sa.add(new Alumno("John", 7));
        sa.add(new Alumno("Julia", 3));
        sa.add(new Alumno("Zeus", 2));
        sa.add(new Alumno("Zeus", 3));

        System.out.println(sa);

        System.out.println("Iterando usando foreach");
        for (Alumno alumno : sa) {
            System.out.println(alumno.getNombre());
        }

        System.out.println("Iterando usando while e iterator");
        Iterator<Alumno> it = sa.iterator();
        while (it.hasNext()) {
            Alumno alumno = it.next();
            System.out.println(alumno.getNombre());
        }

        System.out.println("Iterando usando expresiones lamba con foreach");
        sa.forEach(a -> System.out.println(a.getNombre()));

        /*System.out.println("Iterando usando for solo para List");
        for (int i = 0; i < sa.size(); i++) {
            System.out.println(sa.get(i).getNombre());
        }*/
    }
}
