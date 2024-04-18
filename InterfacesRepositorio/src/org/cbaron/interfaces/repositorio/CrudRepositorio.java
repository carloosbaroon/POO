package org.cbaron.interfaces.repositorio;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id);
    void crear(T object);
    void editar(T object);
    void eliminar(Integer id);
}
