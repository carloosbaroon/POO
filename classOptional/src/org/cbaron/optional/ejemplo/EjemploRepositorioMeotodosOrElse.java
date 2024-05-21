package org.cbaron.optional.ejemplo;

import org.cbaron.optional.ejemplo.model.Computador;
import org.cbaron.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.cbaron.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMeotodosOrElse {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        //Computador defecto = new Computador("HP", "LA00001");

        //This one will create the instance of the object no matter what... that means it's not really good in performance
        Computador pc = repositorio.filtrar("asus").orElse(valorDefecto());
        System.out.println(pc);

        pc = repositorio.filtrar("macbook").orElseGet(EjemploRepositorioMeotodosOrElse::valorDefecto);

        System.out.println(pc);

    }

    public static Computador valorDefecto(){
        System.out.println("Obteniendo valor por defecto!!");
        return new Computador("HP", "LA00001");
    }
}
