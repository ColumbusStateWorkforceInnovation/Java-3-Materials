package edu.cscc.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementDemo {
    public static void main(String[] args) {
        MysqlDataSource dataSource = Java3DBFactory.buildDataSource();

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select c.id, c.name from companies c");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("Company: " + "id: " + id + ", name: " + name);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
