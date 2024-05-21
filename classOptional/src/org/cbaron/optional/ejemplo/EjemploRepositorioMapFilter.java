package org.cbaron.optional.ejemplo;

import org.cbaron.optional.ejemplo.model.Computador;
import org.cbaron.optional.ejemplo.model.Fabricante;
import org.cbaron.optional.ejemplo.model.Procesador;
import org.cbaron.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.cbaron.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {
    public static void main(String[] args) {

        Repositorio<Computador> repositorio = new ComputadorRepositorio();

        String f = repositorio.filtrar("asus")
                .flatMap(Computador::getProcesador)
                .flatMap(Procesador::getFabricante)
                .filter(fabricante -> "intel".equals(fabricante.getNombre()))
                .map(Fabricante::getNombre)
                .orElse("Desconocido");

        System.out.println(f);
    }

}
