package edu.cscc.jdbc.statements;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCloser {

    static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
