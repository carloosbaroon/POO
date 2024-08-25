package org.cbaron.java.jdbc.repository;

import org.cbaron.java.jdbc.models.Producto;
import org.cbaron.java.jdbc.util.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryImpl implements Repository<Producto> {

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
    public Producto findById(Long id) {
        Producto producto = null;

        try (PreparedStatement preparedStatement = getConnection().
                prepareStatement("SELECT * from productos where id = ?")) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return producto;
    }

    @Override
    public void save(Producto producto) {
        String sql = null;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?, precio=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, fecha_registro) VALUES(?,?,?)";
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setLong(2, producto.getPrecio());
            if (producto.getId() != null && producto.getId() > 0) {
                preparedStatement.setLong(3, producto.getId());
            } else {
                preparedStatement.setDate(3, new Date(producto.getFechaRegistro().getTime()));
            }

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement statement = getConnection().prepareStatement("DELETE FROM productos where id=?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
