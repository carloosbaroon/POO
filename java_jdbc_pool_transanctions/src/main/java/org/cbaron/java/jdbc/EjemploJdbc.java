package org.cbaron.java.jdbc;

import org.cbaron.java.jdbc.modelo.Categoria;
import org.cbaron.java.jdbc.modelo.Producto;
import org.cbaron.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.cbaron.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.cbaron.java.jdbc.repositorio.Repositorio;
import org.cbaron.java.jdbc.servicio.CatalogoServicio;
import org.cbaron.java.jdbc.servicio.Service;
import org.cbaron.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {

        Service service = new CatalogoServicio();
        System.out.println("============= listar =============");
        service.listar().forEach(System.out::println);
        
        Categoria categoria = new Categoria();
        categoria.setNombre("Peces");

        System.out.println("============= insertar nuevo producto =============");
        Producto producto = new Producto();
        producto.setNombre("Alimento Pez");
        producto.setPrecio(250);
        producto.setFechaRegistro(new Date());
        producto.setSku("1234zxyu");

        service.guardarProductoConCategoria(producto, categoria);

        System.out.println("Producto guardado con exito: " + producto.getId());
        service.listar().forEach(System.out::println);
    }
}

