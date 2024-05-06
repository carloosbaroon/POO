package org.cbaron.threads.executor;

import java.util.concurrent.*;

public class EjemploScheduledExecutorServicePeriodo {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main...");

        CountDownLatch lock = new CountDownLatch(5);

        executor.scheduleAtFixedRate(() -> {
            System.out.println("Hola1 desde la tarea");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                lock.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hola2 desde la tarea");
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        //TimeUnit.SECONDS.sleep(10);
        lock.await();
        System.out.println("Alguna otra tarea...");
        executor.shutdown();
    }
}
