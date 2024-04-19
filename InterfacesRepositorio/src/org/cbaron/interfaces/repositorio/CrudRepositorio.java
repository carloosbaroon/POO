package org.cbaron.interfaces.repositorio;

import org.cbaron.interfaces.repositorio.excepciones.AccesoDatoExcepcion;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatoExcepcion;
    void crear(T object) throws AccesoDatoExcepcion;
    void editar(T object) throws AccesoDatoExcepcion;
    void eliminar(Integer id) throws AccesoDatoExcepcion;
}
