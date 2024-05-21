package org.cbaron.optional.ejemplo;

import org.cbaron.optional.ejemplo.model.Computador;
import org.cbaron.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.cbaron.optional.ejemplo.repositorio.Repositorio;

import java.util.Optional;

public class EjemploRepositorioMeotodosOrElseThrow {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        Computador pc = repositorio.filtrar("asus").orElseThrow(IllegalStateException::new);
        System.out.println(pc);

        String archivo = "documento.pdf";
        String extension = Optional.ofNullable(archivo)
                .filter(a -> a.contains("."))
                .map(a -> a.substring(archivo.lastIndexOf(".") + 1))
                .orElseThrow();
        System.out.println(extension);
    }
}
