package org.cbaron.java.jdbc;

import org.cbaron.java.jdbc.models.Categoria;
import org.cbaron.java.jdbc.models.Producto;
import org.cbaron.java.jdbc.repository.ProductoRepositoryImpl;
import org.cbaron.java.jdbc.repository.Repository;
import org.cbaron.java.jdbc.util.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcTransactions {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConexionDB.getInstance()) {
            if (connection.getAutoCommit()) {
                connection.setAutoCommit(false);
            }
            try {
                Repository<Producto> repository = new ProductoRepositoryImpl();
                System.out.println("--------------- Listar ---------------");
                repository.findAll().forEach(System.out::println);

                System.out.println("--------------- Obtener por ID ---------------");
                System.out.println(repository.findById(2L));

                System.out.println("--------------- Insertar nuevo producto ---------------");
                Producto producto = new Producto();
                producto.setNombre("Alimento Gato");
                producto.setPrecio(900);
                producto.setFechaRegistro(new Date());
                Categoria categoria = new Categoria();
                categoria.setId(1L);
                producto.setCategoria(categoria);
                producto.setSku("abcde12345");
                repository.save(producto);
                System.out.println("Producto guardado con exito");

                System.out.println("--------------- Actualizar producto ---------------");
                producto = new Producto();
                producto.setId(1L);
                producto.setNombre("Perchera Roja");
                producto.setPrecio(1200);
                producto.setSku("abcdef1234");
                categoria = new Categoria();
                categoria.setId(2L);
                producto.setCategoria(categoria);
                repository.save(producto);
                System.out.println("Producto actualizado con exito");
                repository.findAll().forEach(System.out::println);

                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
            }
        }
    }
}
