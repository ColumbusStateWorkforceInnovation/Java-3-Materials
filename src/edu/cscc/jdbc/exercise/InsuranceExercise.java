package edu.cscc.jdbc.exercise;

import edu.cscc.jdbc.exercise.models.Company;

import javax.sql.DataSource;
import java.util.List;
import java.util.Properties;

import static edu.cscc.jdbc.exercise.DataSourceFactory.*;

public class InsuranceExercise {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty(MYSQL_DB_URL, "jdbc:mysql://localhost:3306/java_3_db");
        properties.setProperty(MYSQL_DB_USERNAME, "root");
        properties.setProperty(MYSQL_DB_PASSWORD, "password");

        DataSource dataSource = DataSourceFactory.buildDataSource(properties);

        InsuranceService insuranceService = new InsuranceService(dataSource);
        try {
            List<Company> companies = insuranceService.getCompanies();
            companies.forEach(company -> {
                System.out.println(company);
            });

            Company company = companies.get(0);
            company.setName("Cookie's with a book");
            insuranceService.update(company);

            Company updatedCompany = insuranceService.getCompany(company.getId());
            System.out.println("Updated company " + updatedCompany.getId() + "'s name to " + updatedCompany.getName());

            Company companyToDelete = companies.get(1);
            System.out.println("Deleting company " + companyToDelete.getId());
            insuranceService.delete(companyToDelete.getId());
        } catch (InsuranceServiceException e) {
            e.printStackTrace();
        }
    }
}
