package org.cbaron.patrones.singleton;

public class EjemploSingleton {
    public static void main(String[] args) {
        
        for (int i = 0; i < 10; i++) {
            ConexionDBSingleton con = ConexionDBSingleton.getInstance();
            System.out.println("con = " + con);
        }
    }
}
