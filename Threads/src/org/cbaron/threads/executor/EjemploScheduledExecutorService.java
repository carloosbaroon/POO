package org.cbaron.threads.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduledExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");

        executor.schedule(() -> {
            System.out.println("Hola1 desde la tarea");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola2 desde la tarea");
        }, 200, TimeUnit.MILLISECONDS);

        System.out.println("Alguna otra tarea...");
        executor.shutdown();
    }
}
