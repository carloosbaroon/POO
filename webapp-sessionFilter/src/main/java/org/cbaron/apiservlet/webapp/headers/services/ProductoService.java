package org.cbaron.apiservlet.webapp.headers.services;

import org.cbaron.apiservlet.webapp.headers.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listar();
    Optional<Producto> getById(Long id);
}
