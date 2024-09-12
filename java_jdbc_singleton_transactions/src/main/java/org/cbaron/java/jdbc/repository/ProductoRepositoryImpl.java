package org.cbaron.java.jdbc.repository;

import org.cbaron.java.jdbc.models.Categoria;
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
    public List<Producto> findAll() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     "INNER JOIN categorias as c ON (p.categoria_id = c.id)")) {

            while (resultSet.next()) {
                Producto p = crearProducto(resultSet);

                productos.add(p);
            }

        }
        return productos;
    }

    @Override
    public Producto findById(Long id) throws SQLException {
        Producto producto = null;

        try (PreparedStatement preparedStatement = getConnection().
                prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                        "INNER JOIN categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }
            }

        }
        return producto;
    }

    @Override
    public void save(Producto producto) throws SQLException {
        String sql = null;
        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos SET nombre=?, precio=?  ,categoria_id=?, sku=? WHERE id=?";
        } else {
            sql = "INSERT INTO productos(nombre, precio, categoria_id, sku, fecha_registro) VALUES(?,?,?,?,?)";
        }

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setLong(2, producto.getPrecio());
            preparedStatement.setLong(3, producto.getCategoria().getId());
            preparedStatement.setString(4,producto.getSku());

            if (producto.getId() != null && producto.getId() > 0) {
                preparedStatement.setLong(5, producto.getId());
            } else {
                preparedStatement.setDate(5, new Date(producto.getFechaRegistro().getTime()));
            }

            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Long id) throws SQLException {
        try (PreparedStatement statement = getConnection().prepareStatement("DELETE FROM productos where id=?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    private static Producto crearProducto(ResultSet resultSet) throws SQLException {
        Producto p = new Producto();
        Categoria c = new Categoria();

        p.setId(resultSet.getLong("id"));
        p.setNombre(resultSet.getString("nombre"));
        p.setPrecio(resultSet.getInt("precio"));
        p.setFechaRegistro(resultSet.getDate("fecha_registro"));
        p.setSku(resultSet.getString("sku"));
        c.setId(resultSet.getLong("categoria_id"));
        c.setNombre(resultSet.getString("categoria"));
        p.setCategoria(c);
        return p;
    }
}
