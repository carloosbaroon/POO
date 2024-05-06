package org.cbaron.threads.timer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriodo {
    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();

        //Nos permite utilizar el contador en la funcion anonima de timer
        AtomicInteger contador = new AtomicInteger(3);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = contador.getAndDecrement();
                if (i > 0) {
                    toolkit.beep();
                    System.out.println("Tarea " + i + " periodica en: " + new Date() + "Nombre del thread: "
                            + Thread.currentThread().getName());
                } else {
                    System.out.println("Finaliza el tiempo");
                    timer.cancel();
                }
            }
        }, 5000, 6000);

        System.out.println("Agendamos una tarea para 5seg mas..");
    }
}
