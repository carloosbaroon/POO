package org.cbaron.threads.ejemplos;

import org.cbaron.threads.NombreThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new NombreThread("Aleph");
        System.out.println(hilo.getState());

        hilo.start();
        System.out.println(hilo.getState());

        Thread hilo2 = new NombreThread("Carlos");
        System.out.println(hilo2.getState());
        hilo2.start();
        System.out.println(hilo2.getState());

        NombreThread hilo3 = new NombreThread("Test");
        System.out.println(hilo3.getState());
        hilo3.start();
        System.out.println(hilo3.getState());
    }
}
