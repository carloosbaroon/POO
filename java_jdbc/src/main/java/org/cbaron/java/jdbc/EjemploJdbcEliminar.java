package org.cbaron.java.jdbc;

import org.cbaron.java.jdbc.models.Producto;
import org.cbaron.java.jdbc.repository.ProductoRepositoryImpl;
import org.cbaron.java.jdbc.repository.Repository;
import org.cbaron.java.jdbc.util.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcEliminar {
    public static void main(String[] args) {

        try (Connection connection = ConexionDB.getInstance()) {

            Repository<Producto> repository = new ProductoRepositoryImpl();
            System.out.println("--------------- Listar ---------------");
            repository.findAll().forEach(System.out::println);

            System.out.println("--------------- Obtener por ID ---------------");
            System.out.println(repository.findById(2L));

            System.out.println("--------------- Eliminar producto ---------------");
            repository.delete(13L);
            System.out.println("Productos eliminados con exito");
            repository.findAll().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
