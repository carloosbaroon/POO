package org.cbaron.java.jdbc;

import org.cbaron.java.jdbc.models.Producto;
import org.cbaron.java.jdbc.repository.ProductoRepositoryImpl;
import org.cbaron.java.jdbc.repository.Repository;
import org.cbaron.java.jdbc.util.ConexionDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcEditar {
    public static void main(String[] args) {

        try (Connection connection = ConexionDB.getInstance()) {

            Repository<Producto> repository = new ProductoRepositoryImpl();
            System.out.println("--------------- Listar ---------------");
            repository.findAll().forEach(System.out::println);

            System.out.println("--------------- Obtener por ID ---------------");
            System.out.println(repository.findById(2L));

            System.out.println("--------------- Actualizar producto ---------------");
            Producto producto = new Producto();
            producto.setId(3L);
            producto.setNombre("Collar Rojo");
            producto.setPrecio(699);
            repository.save(producto);
            System.out.println("Producto actualizado con exito");
            repository.findAll().forEach(System.out::println);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
