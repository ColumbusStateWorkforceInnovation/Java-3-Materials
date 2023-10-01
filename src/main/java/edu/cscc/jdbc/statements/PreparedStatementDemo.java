package edu.cscc.jdbc.statements;

import edu.cscc.jdbc.Java3DBFactory;

import javax.sql.DataSource;
import java.sql.*;

import static edu.cscc.jdbc.statements.ConnectionCloser.closeConnection;

public class PreparedStatementDemo {
    public static void main(String[] args) {
        DataSource dataSource = Java3DBFactory.buildDataSource();
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            String query =
                    "select c.name, im.first_name, im.last_name"
                            + " from companies c "
                            + " inner join insured_members im on c.id = im.company_id"
                            + " where c.id = ?"
                            + " and im.last_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            int companyId = 1;
            String lastName = "Gilbert";
            statement.setInt(1, companyId);
            statement.setString(2, lastName);
            ResultSet resultSet = statement.executeQuery();
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
