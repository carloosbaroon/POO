package org.cbaron.threads;

public class NombreThread extends Thread {

    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        //Here we start the execution and finalize the thread
        System.out.println("Se inicia el metodo run del hilo: " + this.getName());

        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(10);
                System.out.println(this.getName() + " " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Finaliza el metodo run del hilo: " + this.getName());
    }
}
