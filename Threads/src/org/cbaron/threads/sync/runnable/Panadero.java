package org.cbaron.threads.sync.runnable;

import org.cbaron.threads.sync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable {

    private Panaderia panaderia;

    public Panadero(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (panaderia) {
                while (panaderia.disponible) {
                    try {
                        panaderia.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                panaderia.hornear("Pan: " + i);
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500, 600));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
