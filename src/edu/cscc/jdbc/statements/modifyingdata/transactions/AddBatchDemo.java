package edu.cscc.jdbc.statements.modifyingdata.transactions;

import edu.cscc.jdbc.Java3DBFactory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.cscc.jdbc.statements.ConnectionCloser.closeConnection;

public class AddBatchDemo {
    public static void main(String[] args) {
        DataSource dataSource = Java3DBFactory.buildDataSource();
        Connection connection = null;

        List<Member> members = buildMemberList();

        try {
            connection = dataSource.getConnection();
            System.out.println("Before inserting...");
            displayMemberCount(connection);
            addMembers(members, connection);
            displayMemberCount(connection);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private static List<Member> buildMemberList() {
        List<Member> members = new ArrayList<>();
        members.add(new Member(1, "Joey", "Monahan"));
        members.add(new Member(1, "Benedict", "Rutherford"));
        members.add(new Member(1, "Margaretta", "Kutch DC"));
        members.add(new Member(2, "Edmundo", "Kub"));
        members.add(new Member(2, "Bruce", "Gislason"));
        members.add(new Member(2, "Muoi", "Howell"));
        members.add(new Member(3, "Lester", "Schuster"));
        members.add(new Member(3, "Susana", "Fadel"));
        members.add(new Member(3, "Saran", "Aufderhar"));
        return members;
    }

    private static void addMembers(List<Member> members, Connection connection) throws SQLException {
        String insertSql =
                "insert into insured_members (company_id, first_name, last_Name) "
                        + " values (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertSql);
        members.forEach(member -> {
            try {
                System.out.println("Adding member: " + member);
                preparedStatement.setInt(1, member.getCompanyId());
                preparedStatement.setString(2, member.getFirstName());
                preparedStatement.setString(3, member.getLastName());
                preparedStatement.addBatch();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });

        preparedStatement.executeBatch();
    }

    private static void displayMemberCount(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(im.id) from insured_members im");
        resultSet.next();
        int count = resultSet.getInt(1);
        System.out.println("Insured Members: " + count);
    }
}
