package org.cbaron.threads.executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
            System.out.println("Fin de la tarea...");
            return "Algun resultado de una consulta";
        };

        Future<String> resultado = executor.submit(tarea);
        executor.shutdown();
        System.out.println("Continuando con la ejecucion del main 1...");

        //System.out.println(resultado.isDone());

        while (!resultado.isDone()) {
            System.out.println("Ejecutando tarea...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        //Similar al join, espera a que terminen los threads
        System.out.println(resultado.get(5, TimeUnit.SECONDS));
        System.out.println("Finaliza la tarea: " + resultado.isDone());
        System.out.println("Continuamos...");
    }
}
