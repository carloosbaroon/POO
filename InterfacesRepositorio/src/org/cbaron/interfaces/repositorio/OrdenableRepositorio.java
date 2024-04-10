package org.cbaron.interfaces.repositorio;

import org.cbaron.interfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {

    List<Cliente> listar(String campo, Direccion dir);
}
