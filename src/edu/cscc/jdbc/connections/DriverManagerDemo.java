package edu.cscc.jdbc.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DriverManagerDemo {
    private static final String MYSQL_DB_USERNAME = "user";
    private static final String MYSQL_DB_PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.setProperty(MYSQL_DB_USERNAME, "root");
            properties.setProperty(MYSQL_DB_PASSWORD, "password");
            String dbUrl = "jdbc:mysql://localhost:3306/java_3_db";
            Connection connection = DriverManager.getConnection(dbUrl, properties);

            System.out.println("Connection is open: " + !connection.isClosed());
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
