package org.cbaron.optional.ejemplo.repositorio;

import org.cbaron.optional.ejemplo.model.Computador;

import java.util.Optional;

public interface Repositorio<T> {

    Optional<Computador> filtrar(String nombre);
}
