package org.cbaron.ejemplos.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {

        Set<String> treeSet = new TreeSet<>(Comparator.reverseOrder());

        treeSet.add("uno");
        treeSet.add("dos");
        treeSet.add("tres");
        treeSet.add("tres");
        treeSet.add("cuatro");
        treeSet.add("cinco");

        System.out.println("tree set: " + treeSet);

        Set<Integer> treeSetNumeros = new TreeSet<>();

        treeSetNumeros.add(1);
        treeSetNumeros.add(3);
        treeSetNumeros.add(2);
        treeSetNumeros.add(4);
        treeSetNumeros.add(10);
        treeSetNumeros.add(5);

        System.out.println("tree set numeros: " + treeSetNumeros);
    }
}
