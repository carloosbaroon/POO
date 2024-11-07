package org.cbaron.apiservlet.webapp.headers.repositories;

import org.cbaron.apiservlet.webapp.headers.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryImpl implements Repository<Categoria>{

    private Connection connection;

    public CategoriaRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM categorias")){
            while (resultSet.next()) {
                Categoria categoria = getCategoria(resultSet);
                categorias.add(categoria);
            }
        }
        return List.of();
    }

    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria categoria = null;

        try (PreparedStatement statement = connection.prepareStatement("SELECT * from categorias as c WHERE c.id=?")){
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    categoria = getCategoria(resultSet);
                }
            }
        }

        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private static Categoria getCategoria(ResultSet resultSet) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setNombre(resultSet.getString("nombre"));
        categoria.setId(resultSet.getLong("id"));
        return categoria;
    }
}
