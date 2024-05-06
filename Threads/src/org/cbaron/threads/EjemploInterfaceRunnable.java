package org.cbaron.threads;

import org.cbaron.threads.runnable.ViajeTarea;

public class EjemploInterfaceRunnable {
    public static void main(String[] args) {

        new Thread(new ViajeTarea("Acapulco")).start();
        new Thread(new ViajeTarea("Isla de Pascua")).start();
        new Thread(new ViajeTarea("Test2")).start();
        new Thread(new ViajeTarea("Test3")).start();


    }
}
