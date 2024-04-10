package org.cbaron.interfaces.repositorio;

import org.cbaron.interfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {

    List<Cliente> listar(int desde, int hasta);
}
