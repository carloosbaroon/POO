package org.cbaron.interfaces;

import org.cbaron.interfaces.modelo.Cliente;
import org.cbaron.interfaces.modelo.Producto;
import org.cbaron.interfaces.repositorio.Direccion;
import org.cbaron.interfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.cbaron.interfaces.repositorio.excepciones.AccesoDatoExcepcion;
import org.cbaron.interfaces.repositorio.excepciones.LecturaAccesoDatoExcepcion;
import org.cbaron.interfaces.repositorio.lista.ClienteListRepositorio;
import org.cbaron.interfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try {
            OrdenablePaginableCrudRepositorio<Producto> repositorio = new ProductoListRepositorio();

            repositorio.crear(new Producto(5, "Cosa1"));
            repositorio.crear(new Producto(5, "Cosa1"));
            repositorio.crear(new Producto(5, "Cosa1"));
            repositorio.crear(new Producto(5, "Cosa1"));

            List<Producto> productos = repositorio.listar();
            productos.forEach(System.out::println);

            System.out.println("==== PAGINABLE ====");

            List<Producto> productoPaginable = repositorio.listar(1, 3);
            productoPaginable.forEach(System.out::println);

            System.out.println("==== ORDENAR ====");

            List<Producto> productoOrdenAsc = (repositorio).listar("apellido", Direccion.ASC);
            for (Producto producto : productoOrdenAsc) {
                System.out.println(producto);
            }

            System.out.println("==== EDITAR ====");

            Producto actualizar = new Producto(10, "ProductoActu");
            actualizar.setId(1);
            repositorio.editar(actualizar);
            Producto productoActualizada = repositorio.porId(1);
            System.out.println(productoActualizada);

            System.out.println("==== ELIMINAR ====");
            repositorio.eliminar(1);
            repositorio.listar().forEach(System.out::println);

            System.out.println("==== Total ====");
            System.out.println("Total registros: " + repositorio.total());
        } catch (LecturaAccesoDatoExcepcion e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (AccesoDatoExcepcion e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
