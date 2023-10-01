package edu.cscc.jdbc.statements.modifyingdata;

import edu.cscc.jdbc.Java3DBFactory;

import javax.sql.DataSource;
import java.sql.*;

import static edu.cscc.jdbc.statements.ConnectionCloser.closeConnection;

public class ExecuteUpdateDemo {
    public static void main(String[] args) {
        DataSource dataSource = Java3DBFactory.buildDataSource();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            System.out.println("Before inserts:");
            findCompanies(connection);

            insertRecords(connection);
            System.out.println("After inserts:");
            findCompanies(connection);

            updateRecords(connection);
            System.out.println("After updating...");
            findCompanies(connection);

            System.out.println("Deleting Burger King and Wendy's...");
            deleteRecords(connection);

            findCompanies(connection);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private static void deleteRecords(Connection connection) throws SQLException {
        String deleteSql =
                "delete from companies where name = ?";
        PreparedStatement deleteStatement = connection.prepareStatement(deleteSql);
        deleteStatement.setString(1, "Burger King");
        deleteStatement.executeUpdate();
        deleteStatement.setString(1, "Wendy's");
        deleteStatement.executeUpdate();
    }

    private static void updateRecords(Connection connection) throws SQLException {
        System.out.println("Updating McDonald's to Burger King...");
        String updateSql =
                "update companies c set c.name = ? where c.name = ?";
        PreparedStatement updateStatement = connection.prepareStatement(updateSql);
        updateStatement.setString(1, "Burger King");
        updateStatement.setString(2, "McDonald's");
        updateStatement.executeUpdate();
    }

    private static void insertRecords(Connection connection) throws SQLException {
        System.out.println("Inserting McDonald's and Wendy's...");
        String insertSqlStatement = "insert into companies (name) values(?)";
        String companyName = "McDonald's";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSqlStatement);
        preparedStatement.setString(1, companyName);
        int result = preparedStatement.executeUpdate();
        System.out.println("Number of records inserted: " + result);

        preparedStatement.setString(1, "Wendy's");
        result = preparedStatement.executeUpdate();
        System.out.println("Number of records inserted: " + result);
        System.out.println();
    }

    private static void findCompanies(Connection connection) throws SQLException {
        String companiesQuery = "select c.id, c.name from companies c";
        PreparedStatement companiesStatement = connection.prepareStatement(companiesQuery);
        ResultSet resultSet = companiesStatement.executeQuery();
        outputResults(resultSet);
    }

    private static void outputResults(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String companyName = resultSet.getString("name");
            System.out.println("Company: " + "name: " + companyName);
        }
        System.out.println();
    }
}
