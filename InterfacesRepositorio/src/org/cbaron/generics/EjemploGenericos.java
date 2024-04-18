package org.cbaron.generics;

import org.cbaron.interfaces.modelo.Cliente;
import org.cbaron.interfaces.modelo.ClientePremium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Aleph", "Baron"));

        Cliente aleph = clientes.iterator().next();

        Cliente[] clientesArray = {new Cliente("Aleph", "Baron"),
                new Cliente("Carlos", "Baron")};

        Integer[] enterosArray = {1, 2, 3};

        List<Cliente> clientesLista = fromArrayToList(clientesArray);
        List<Integer> enterosLista = fromArrayToList(enterosArray);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Aleph", "Carlos"}, enterosArray);
        nombres.forEach(System.out::println);

        List<ClientePremium> clientePremiumList = fromArrayToList(new ClientePremium[]{ new ClientePremium("Aleph", "Baron")});

        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientePremiumList);

        System.out.println("Maximo 1, 9 y 4: " + maximo(1,9, 4));
        System.out.println("Maximo 3.9, 11.6, 7.76: " + maximo(3.9,11.6,7.76));
        System.out.println("Maximo zanahoria, arandanos y manzana"  + maximo("zanahoria", "arandanos", "manzana"));
    }

    //Using T to indicate a generic array T
    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    //Using T to indicate a generic array T
    public static <T extends Number> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    //Using T to indicate a generic array T
    public static <T extends Cliente & Comparable<T>> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    //Using T and G to indicate we receive two generic arrays "T & G"
    public static <T, G> List<T> fromArrayToList(T[] c, G[] x) {
        for (G elemento : x) {
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }

    public static void imprimirClientes(List<? extends Cliente> clientes) {
        clientes.forEach(System.out::println);
    }

    // T needs to implement Comparable interface
    public static <T extends Comparable<T>> T maximo(T a, T b, T c) {
        T max = a;
        if (b.compareTo(max) > 0) {
            max = b;
        }
        if (c.compareTo(max) > 0) {
            max = c;
        }
        return max;
    }
}
