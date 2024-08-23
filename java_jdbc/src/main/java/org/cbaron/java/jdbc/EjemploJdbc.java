package org.cbaron.java.jdbc;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java_curso";
        String username = "root";
        String password = "sasa";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM productos");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("nombre"));
            }
            resultSet.close();
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
