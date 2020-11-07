package edu.cscc.jdbc.exercise;

import edu.cscc.jdbc.exercise.models.Company;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsuranceService {

    private final DataSource dataSource;

    public InsuranceService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Company> getCompanies() throws InsuranceServiceException {
        List<Company> companies = new ArrayList<>();
        try {
            String sql = "select c.id, c.name from companies c";
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int companyId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Company company = new Company(companyId, name);
                companies.add(company);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new InsuranceServiceException("Couldn't retrieve companies");
        }

        return companies;
    }

    public int update(Company company) throws InsuranceServiceException {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "update companies set name = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, company.getName());
            preparedStatement.setInt(2, company.getId());

            return preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new InsuranceServiceException("Could not update company");
        }
    }

    public Company getCompany(Integer id) throws InsuranceServiceException {
        try {
            String sql = "select c.id, c.name from companies c where c.id = ?";
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int companyId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                return new Company(companyId, name);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new InsuranceServiceException("Couldn't retrieve company");
        }

        return null;
    }

    public boolean delete(Integer id) throws InsuranceServiceException {
        try {
            String sql = "delete from companies where id = ?";
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                return true;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new InsuranceServiceException("Couldn't delete company");
        }

        return false;
    }
}
