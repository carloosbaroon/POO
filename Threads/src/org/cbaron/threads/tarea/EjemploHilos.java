package org.cbaron.threads.tarea;

public class EjemploHilos {
    public static void main(String[] args) {

        AlfanumericoTarea h1 = new AlfanumericoTarea(Tipo.LETRA);
        AlfanumericoTarea h2 = new AlfanumericoTarea(Tipo.NUMERO);

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();
    }
}
