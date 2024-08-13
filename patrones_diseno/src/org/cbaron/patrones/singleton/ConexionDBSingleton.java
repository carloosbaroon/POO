package org.cbaron.patrones.singleton;

public class ConexionDBSingleton {

    private static ConexionDBSingleton instancia;

    private ConexionDBSingleton() {
        System.out.println("Conectandose algun motor de DB");
    }

    public static ConexionDBSingleton getInstance() {

        if(instancia == null){
            instancia = new ConexionDBSingleton();
        }

        return instancia;
    }
}
