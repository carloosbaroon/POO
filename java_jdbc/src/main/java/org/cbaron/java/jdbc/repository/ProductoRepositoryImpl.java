package org.cbaron.java.jdbc.repository;



import org.cbaron.java.jdbc.models.Producto;
import org.cbaron.java.jdbc.util.ConexionDB;

import java.sql.*;
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
                Producto p = crearProducto(resultSet);

                productos.add(p);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productos;
    }

    @Override
    public Object findById(Long id) {
        Producto producto = null;

        try (PreparedStatement preparedStatement = getConnection().
                prepareStatement("SELECT * from productos where id = ?")) {

            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                producto = crearProducto(resultSet);
            }
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void delete(Long id) {

    }

    private static Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto p = new Producto();
        p.setId(resultSet.getLong("id"));
        p.setNombre(resultSet.getString("nombre"));
        p.setPrecio(resultSet.getInt("precio"));
        p.setFechaRegistro(resultSet.getDate("fecha_registro"));
        return p;
    }
}
