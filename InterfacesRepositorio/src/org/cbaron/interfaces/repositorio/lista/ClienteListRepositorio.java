package org.cbaron.interfaces.repositorio.lista;

import org.cbaron.interfaces.modelo.Cliente;
import org.cbaron.interfaces.repositorio.AbstractListRepositorio;
import org.cbaron.interfaces.repositorio.Direccion;
import org.cbaron.interfaces.repositorio.excepciones.LecturaAccesoDatoExcepcion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstractListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoExcepcion {
        Cliente clienteActual = this.porId(cliente.getId());
        clienteActual.setNombre(cliente.getNombre());
        clienteActual.setApellido(cliente.getApellido());
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);

        listaOrdenada.sort((c1, c2) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = ordenar(campo, c1, c2);
            } else if (dir == Direccion.DESC) {
                resultado = ordenar(campo, c2, c1);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    public static int ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
