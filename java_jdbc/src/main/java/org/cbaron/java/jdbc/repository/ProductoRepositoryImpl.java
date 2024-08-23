package org.cbaron.java.jdbc.repository;



import org.cbaron.java.jdbc.models.Producto;
import org.cbaron.java.jdbc.util.ConexionDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl implements Repository{

    private Connection getConnection() throws SQLException {
        return ConexionDB.getInstance();
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> productos = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM productos")) {

            while (resultSet.next()) {
                Producto p = new Producto();
                p.setId(resultSet.getLong("id"));
                p.setNombre(resultSet.getString("nombre"));
                p.setPrecio(resultSet.getInt("precio"));
                p.setFechaRegistro(resultSet.getDate("fecha_registro"));

                productos.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void delete(Long id) {

    }
}
