package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // TODO: update these three values to match your local MySQL setup
	private static final String URL = " jdbc:mysql://mysql-db:3306/library_db ";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root123";

    private static Connection connection;

    private DBConnection() {
    }

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Did you add the connector JAR to the build path?");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to database. Check your URL/username/password.");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
