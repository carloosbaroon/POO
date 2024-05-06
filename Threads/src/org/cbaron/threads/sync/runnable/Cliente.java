package org.cbaron.threads.sync.runnable;

import org.cbaron.threads.sync.Panaderia;

public class Cliente implements Runnable {

    private Panaderia panaderia;

    public Cliente(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            synchronized (panaderia) {
                while (!panaderia.disponible) {
                    try {
                        panaderia.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                panaderia.consumir();
            }
        }

    }
}
