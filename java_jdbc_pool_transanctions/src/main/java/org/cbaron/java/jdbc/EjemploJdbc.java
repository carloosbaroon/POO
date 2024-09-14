package org.cbaron.java.jdbc;

import org.cbaron.java.jdbc.modelo.Categoria;
import org.cbaron.java.jdbc.modelo.Producto;
import org.cbaron.java.jdbc.repositorio.CategoriaRepositorioImpl;
import org.cbaron.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.cbaron.java.jdbc.repositorio.Repositorio;
import org.cbaron.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) throws SQLException {
            try (Connection conn = ConexionBaseDatos.getConnection()) {
                    if (conn.getAutoCommit()) {
                            conn.setAutoCommit(false);
                    }
                    try {
                            Repositorio<Categoria> repositorioCategoria = new CategoriaRepositorioImpl(conn);
                            System.out.println("============= Insertar nueva categoria =============");
                            Categoria categoria = new Categoria();
                            categoria.setNombre("Conejos");
                            Categoria nuevaCategoria = repositorioCategoria.guardar(categoria);
                            System.out.println("Categoria guardada con éxito: " + categoria.getId());
                            Repositorio<Producto> repositorio = new ProductoRepositorioImpl(conn);
                            System.out.println("============= listar =============");
                            repositorio.listar().forEach(System.out::println);

                            System.out.println("============= obtener por id =============");
                            System.out.println(repositorio.porId(1L));

                            System.out.println("============= insertar nuevo producto =============");
                            Producto producto = new Producto();
                            producto.setNombre("Alimento Conejo");
                            producto.setPrecio(600);
                            producto.setFechaRegistro(new Date());
                            producto.setSku("1234zxy");

                            producto.setCategoria(nuevaCategoria);
                            repositorio.guardar(producto);
                            System.out.println("Producto guardado con éxito: " + producto.getId());
                            repositorio.listar().forEach(System.out::println);

                    conn.commit();
                    } catch (SQLException e) {
                            conn.rollback();
                            e.printStackTrace();
                    }
            }
    }
}
