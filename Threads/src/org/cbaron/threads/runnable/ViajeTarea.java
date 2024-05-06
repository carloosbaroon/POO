package org.cbaron.threads.runnable;

public class ViajeTarea implements Runnable {

    private String nombre;
    private static int ultimoId;
    private int id;

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
        this.id = ultimoId++;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " - " + this.nombre);
            try {
                Thread.sleep((long) (Math.random() * 100));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Thread id:" + this.id + " Finalmente me voy de viaje a: " + this.nombre);
    }
}
