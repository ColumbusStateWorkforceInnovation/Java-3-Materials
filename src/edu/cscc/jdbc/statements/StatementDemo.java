package edu.cscc.jdbc.statements;

import edu.cscc.jdbc.Java3DBFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static edu.cscc.jdbc.statements.ConnectionCloser.closeConnection;

public class StatementDemo {
    public static void main(String[] args) {
        DataSource dataSource = Java3DBFactory.buildDataSource();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select c.id, c.name from companies c");
            outputResults(resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private static void outputResults(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println("Company: " + "id: " + id + ", name: " + name);
        }
    }
}
