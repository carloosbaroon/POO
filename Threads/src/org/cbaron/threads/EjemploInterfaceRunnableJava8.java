package org.cbaron.threads;

import org.cbaron.threads.runnable.ViajeTarea;

public class EjemploInterfaceRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {

        //Obteniendo el thread del main
        Thread mainThread = Thread.currentThread();
        //Usando una funcion anonima
        /*Runnable viaje = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long) (Math.random() * 100));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(" Finalmente me voy de viaje a: " + Thread.currentThread().getName());
            }
        };*/


        //Usando expresiones lambda
        Runnable viaje =  () -> {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + " - " + Thread.currentThread().getName());
                    try {
                        Thread.sleep((long) (Math.random() * 100));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(" Finalmente me voy de viaje a: " + Thread.currentThread().getName());
                System.out.println("Estado main thread: " + mainThread.getState());
            };

        Thread v1 = new Thread(viaje, "Acapulco");
        Thread v2 = new Thread(viaje, "Isla de Pascua");
        Thread v3 = new Thread(viaje, "Isla de Chios");
        Thread v4 = new Thread(viaje, "Robinson Crusoe");

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        //Uniendo thread principal con v1
        v1.join();
        //Uniendo thread principal con v2
        v2.join();
        //Uniendo thread principal con v3
        v3.join();
        //Uniendo thread principal con v4
        v4.join();
        //Thread.sleep(100);
        System.out.println("Estado main thread: " + mainThread.getState());
        System.out.println("Continuando con la ejecucion del metodo main: " + mainThread.getName());
    }
}
