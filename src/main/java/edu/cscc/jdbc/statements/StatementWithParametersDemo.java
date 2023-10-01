package edu.cscc.jdbc.statements;

import edu.cscc.jdbc.Java3DBFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static edu.cscc.jdbc.statements.ConnectionCloser.closeConnection;

public class StatementWithParametersDemo {
    public static void main(String[] args) {
        DataSource dataSource = Java3DBFactory.buildDataSource();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            String companyId = "1";
            String query =
                    "select c.name, im.first_name, im.last_name"
                    + " from companies c "
                    + " inner join insured_members im on c.id = im.company_id"
                    + " where c.id = " + companyId;

            ResultSet resultSet = statement.executeQuery(query);
            outputResults(resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private static void outputResults(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String companyName = resultSet.getString("name");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            System.out.println("Company: " + "name: " + companyName);
            System.out.println(firstName + " " + lastName);
        }
    }
}
