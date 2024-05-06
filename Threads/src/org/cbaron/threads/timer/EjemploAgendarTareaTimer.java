package org.cbaron.threads.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Tarea realizada en: " + new Date() + "Nombre del thread: "
                        + Thread.currentThread().getName());
                timer.cancel();
            }
        }, 5000);

        System.out.println("Agendamos una tarea para 5seg mas..");
    }
}
