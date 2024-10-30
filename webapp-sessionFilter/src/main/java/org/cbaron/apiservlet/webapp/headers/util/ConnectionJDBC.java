package org.cbaron.apiservlet.webapp.headers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {

    private static String url = "jdbc:mysql://localhost:3306/java_curso";
    private static String username = "root";
    private static String password = "sasa";

    public static Connection getConnection() throws SQLException {
        try {
            // Explicitly load the MySQL driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }

        return DriverManager.getConnection(url, username, password);
    }
}
