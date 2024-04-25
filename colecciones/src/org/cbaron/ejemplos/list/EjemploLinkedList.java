package org.cbaron.ejemplos.list;

import org.cbaron.ejemplos.modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {

        LinkedList<Alumno> ll = new LinkedList<>();

        System.out.println(ll + " size = " + ll.size());

        ll.add(new Alumno("Carlos", 5));
        ll.add(new Alumno("Aleph", 6));
        ll.add(new Alumno("Bob", 4));
        ll.add(new Alumno("Julia", 3));
        ll.add(new Alumno("John", 7));
        ll.add(new Alumno("Zeus", 2));

        System.out.println(ll + " size = " + ll.size());

        ll.addFirst(new Alumno("TestInicio", 5));
        ll.addLast(new Alumno("TestFinal", 6));

        System.out.println(ll + " size = " + ll.size());

        System.out.println("Primero: " + ll.getFirst());
        System.out.println("Ultimo: " + ll.getLast());
        System.out.println("Indice 2: " + ll.get(2));

        System.out.println(ll + " size = " + ll.size());

        Alumno firstLinked = ll.removeFirst();
        Alumno lastLinked = ll.removeLast();
        System.out.println(ll + " size = " + ll.size());

        ll.remove(3);
        System.out.println(ll + " size = " + ll.size());

        ListIterator<Alumno> li = ll.listIterator();

        while (li.hasNext()) {
            System.out.println(li.next());
        }

        System.out.println("=========== Previous =============");

        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }
    }
}
