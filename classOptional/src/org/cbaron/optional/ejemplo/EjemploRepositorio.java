package org.cbaron.optional.ejemplo;

import org.cbaron.optional.ejemplo.model.Computador;
import org.cbaron.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.cbaron.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        repositorio.filtrar("asus").ifPresentOrElse(System.out::println, () -> System.out.println("No se encontro"));

        /*Optional<Computador> pc = repositorio.filtrar("asus");

        if(pc.isPresent()) {
            System.out.println(pc.get().toString());
        } else {
            System.out.println("No se encontro");
        }*/
    }
}
