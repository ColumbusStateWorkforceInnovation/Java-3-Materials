package edu.cscc.hibernate;

import edu.cscc.hibernate.models.Company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateDemo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Java3Demo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Company company = entityManager.find(Company.class, 1);
        System.out.println("Company name: " + company.getName());
    }
}
