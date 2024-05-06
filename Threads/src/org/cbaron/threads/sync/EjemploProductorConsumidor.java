package org.cbaron.threads.sync;

import org.cbaron.threads.sync.runnable.Cliente;
import org.cbaron.threads.sync.runnable.Panadero;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panaderia p = new Panaderia();

        // Start only one Panadero thread to bake bread
        Thread panaderoThread = new Thread(new Panadero(p));
        panaderoThread.start();

        // Start one Cliente thread to consume bread
        Thread clienteThread = new Thread(new Cliente(p));
        clienteThread.start();

        // Wait for both threads to finish before the main thread exits
        try {
            panaderoThread.join();
            clienteThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
