package org.cbaron.threads.sync;

public class Panaderia {

    private String pan;
    public boolean disponible;

    public synchronized void hornear(String masa) {
        while (disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        this.pan = masa;
        System.out.println("Panadero hornea: " + this.pan);
        this.disponible = true;
        notifyAll();
    }

    public synchronized String consumir() {
        while (!disponible) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Cliente consume: " + this.pan);
        this.disponible = false;
        notifyAll();
        return this.pan;
    }
}
