package org.cbaron.java.jdbc;

import org.cbaron.java.jdbc.models.Producto;
import org.cbaron.java.jdbc.repository.ProductoRepositoryImpl;
import org.cbaron.java.jdbc.repository.Repository;
import org.cbaron.java.jdbc.util.ConexionDB;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection connection = ConexionDB.getInstance()) {

            Repository<Producto> repository = new ProductoRepositoryImpl();
            repository.findAll().forEach(System.out::println);

            System.out.println(repository.findById(2L));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
