package org.cbaron.optional.ejemplo.repositorio;

import org.cbaron.optional.ejemplo.model.Computador;
import org.cbaron.optional.ejemplo.model.Fabricante;
import org.cbaron.optional.ejemplo.model.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ComputadorRepositorio implements Repositorio<Computador> {

    private List<Computador> dataSource;

    public ComputadorRepositorio() {
        dataSource = new ArrayList<>();
        Procesador proc = new Procesador("I9-9800", new Fabricante("Intel"));
        Computador asus = new Computador("Asus Rog", "Strix G512");
        asus.setProcesador(proc);
        dataSource.add(asus);
        dataSource.add(new Computador("Macbook Pro", "MP2004"));
    }

    @Override
    public Optional<Computador> filtrar(String nombre) {
        return dataSource.stream().filter(c -> c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();
        /*for (Computador c : dataSource) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();*/
    }
}
