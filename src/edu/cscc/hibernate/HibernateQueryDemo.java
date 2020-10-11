package edu.cscc.hibernate;

import edu.cscc.hibernate.models.Company;
import edu.cscc.hibernate.models.InsuredMember;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.io.File;
import java.util.List;

public class HibernateQueryDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure(new File("resources/META-INF/hibernate.cfg.xml")).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        String companyQuery = "select c from Company c where c.name = :name ";
        Query query = session.createQuery(companyQuery);
        String playland = "Bouncy Castle Playland";
        query.setParameter("name", playland);
        List<Company> companies = query.getResultList();
        companies.forEach(company -> System.out.println(company));

        Query updateQuery = session.createQuery("update Company set name = :name");
        updateQuery.setParameter("name", "Just Playland");
        updateQuery.executeUpdate();
        Company company = companies.get(0);
        session.refresh(company);
        System.out.println(company);

        session.persist(new Company("Not Playland"));
        Query deleteQuery = session.createQuery("delete Company c where c.name = :name");
        deleteQuery.setParameter("name", "Not Playland");
        deleteQuery.executeUpdate();

        String insertStatement = "insert into companies (name) values (:name)";
        Query nativeQuery = session.createNativeQuery(insertStatement);
        nativeQuery.setParameter("name", "Another Playland");
        nativeQuery.executeUpdate();

        TypedQuery<Company> companyTypedQuery = session.createQuery("select c from Company c", Company.class);
        List<Company> typedCompanies = companyTypedQuery.getResultList();
        typedCompanies.forEach(typedCompany -> System.out.println(typedCompany));

        //In main...
        Query namedQuery = session.createNamedQuery(InsuredMember.FIND_BY_NAME);
        namedQuery.setParameter("firstName", "Sarah");
        namedQuery.setParameter("lastName", "Gilbert");
        List<InsuredMember> resultList = namedQuery.getResultList();
        resultList.forEach(typedCompany -> System.out.println(typedCompany));

        session.getTransaction().rollback();
    }
}
