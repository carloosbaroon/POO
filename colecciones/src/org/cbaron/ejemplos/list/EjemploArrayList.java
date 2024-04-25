package org.cbaron.ejemplos.list;

import org.cbaron.ejemplos.modelo.Alumno;

import java.util.ArrayList;
import java.util.List;

public class EjemploArrayList {
    public static void main(String[] args) {

        List<Alumno> al = new ArrayList<>();

        System.out.println(al + " size = " + al.size());

        al.add(new Alumno("Carlos", 5));
        al.add(new Alumno("Aleph", 6));
        al.add(new Alumno("Bob", 4));
        al.add(new Alumno("Julia", 3));
        al.add(2, new Alumno("John", 7));
        al.set(3, new Alumno("Zeus", 2));

        System.out.println(al + " size = " + al.size());

        al.remove(new Alumno("Zeus", 2));
        //al.remove(3);
        System.out.println(al + " size = " + al.size());

        boolean b = al.contains(new Alumno("Zeus", 2));
        System.out.println("Lista contiene Zeus: " + b);

        Object a[] = al.toArray();
        for (int i = 0; i < a.length; i++) {
            System.out.println("Desde el arrego: " + a[i]);
        }
    }
}
