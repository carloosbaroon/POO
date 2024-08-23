package org.cbaron.java.jdbc;

import org.cbaron.java.jdbc.util.ConexionDB;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection connection = ConexionDB.getInstance();
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery("SELECT * FROM productos")) {

            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.print(" | ");
                System.out.print(resultSet.getString("nombre"));
                System.out.print(" | ");
                System.out.print(resultSet.getInt("precio"));
                System.out.print(" | ");
                System.out.println(resultSet.getDate("fecha_registro"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
