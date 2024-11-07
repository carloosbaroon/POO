package org.cbaron.apiservlet.webapp.headers.repositories;

import org.cbaron.apiservlet.webapp.headers.models.Categoria;
import org.cbaron.apiservlet.webapp.headers.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto> {

    private Connection connection;

    public ProductoRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     " inner join categorias as c ON (p.categoria_id = c.id)")) {

            while (rs.next()) {
                Producto p = getProducto(rs);
                productos.add(p);
            }
        }
        return productos;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto producto = null;

        try (PreparedStatement statement = connection.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")) {

            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    producto = getProducto(resultSet);
                }
            }
        }

        return producto;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {

        String sql;

        if (producto.getId() != null && producto.getId() > 0) {
            sql = "UPDATE productos set nombre=?, precio=?, sku=?, categoria_id=? WHERE id=?";
        } else {
            sql = "INSERT into productos(nombre, precio, sku, categoria_id, fecha_registro) values (?,?,?,?,?)";
        }

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, producto.getNombre());
            statement.setInt(2, producto.getPrecio());
            statement.setString(3, producto.getSku());
            statement.setLong(4, producto.getCategoria().getId());

            if (producto.getId() != null && producto.getId() > 0) {
                statement.setLong(5, producto.getId());
            } else {
                statement.setDate(5, Date.valueOf(producto.getFechaRegistro()));
            }

            statement.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {

        String sql = "DELETE from productos WHERE id=?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }

    }

    private static Producto getProducto(ResultSet rs) throws SQLException {
        Producto p = new Producto();
        p.setId(rs.getLong("id"));
        p.setNombre(rs.getString("nombre"));
        p.setPrecio(rs.getInt("precio"));
        p.setSku(rs.getString("sku"));
        p.setFechaRegistro(rs.getDate("fecha_registro").toLocalDate());
        Categoria c = new Categoria();
        c.setId(rs.getLong("categoria_id"));
        c.setNombre(rs.getString("categoria"));
        p.setCategoria(c);
        return p;
    }
}
