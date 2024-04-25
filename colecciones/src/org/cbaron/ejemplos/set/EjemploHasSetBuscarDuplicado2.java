package org.cbaron.ejemplos.set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHasSetBuscarDuplicado2 {
    public static void main(String[] args) {

        String[] peces = {"Corvina", "Lenguado", "Pejerey", "Robalo", "Lenguado"};

        Set<String> unicosPeces = new HashSet<>();
        Set<String> pecesDuplicados = new HashSet<>();

        for (String pez : peces) {
            if (!unicosPeces.add(pez)) {
                pecesDuplicados.add(pez);
            }
        }

        unicosPeces.removeAll(pecesDuplicados);
        
        System.out.println("Elementos unicos: " + unicosPeces);
        System.out.println("Elementos duplicados: " + pecesDuplicados);
    }
}
