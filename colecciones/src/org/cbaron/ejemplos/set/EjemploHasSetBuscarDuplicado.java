package org.cbaron.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHasSetBuscarDuplicado {
    public static void main(String[] args) {

        String[] peces = {"Corvina", "Lenguado", "Pejerey", "Robalo", "Lenguado"};

        Set<String> unicosPeces = new HashSet<>();

        for (String pez : peces) {
            if (!unicosPeces.add(pez)) {
                System.out.println("Elemento duplicado: " + pez);
            }
        }
        System.out.println("Elementos unicos: " + unicosPeces);
    }
}
