package org.cbaron.apiservlet.webapp.headers.services;

import org.cbaron.apiservlet.webapp.headers.models.Categoria;
import org.cbaron.apiservlet.webapp.headers.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService{
    @Override
    public List<Producto> listar() {
        return Arrays.asList(new Producto(1L, "notebook", "computacion", 17500),
                new Producto(2L, "mesa escritorio", "oficina", 1000),
                new Producto(3L, "teclado mecanico", "computacion", 400));
    }

    @Override
    public Optional<Producto> getById(Long id) {
        return listar().stream().filter(producto -> producto.getId().equals(id)).findAny();
    }

    @Override
    public void guardar(Producto producto) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategoria() {
        return List.of();
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}
