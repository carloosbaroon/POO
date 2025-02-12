package org.cbaron.interfaces.repositorio.lista;

import org.cbaron.interfaces.modelo.Cliente;
import org.cbaron.interfaces.modelo.Producto;
import org.cbaron.interfaces.repositorio.AbstractListRepositorio;
import org.cbaron.interfaces.repositorio.Direccion;
import org.cbaron.interfaces.repositorio.excepciones.LecturaAccesoDatoExcepcion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio<Producto> {

    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoExcepcion {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.dataSource);

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

    public static int ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }
}
