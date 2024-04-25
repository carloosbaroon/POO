package org.cbaron.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>();

        hashSet.add("uno");
        hashSet.add("dos");
        hashSet.add("tres");
        hashSet.add("cuatro");
        hashSet.add("cinco");

        System.out.println(hashSet);

        boolean b = hashSet.add("tres");

        System.out.println(hashSet);
        System.out.println("Permite elementos duplicados: " + b);
    }
}
