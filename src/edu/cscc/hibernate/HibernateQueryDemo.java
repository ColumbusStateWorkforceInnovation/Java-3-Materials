package edu.cscc.hibernate;

import edu.cscc.hibernate.models.Company;
import edu.cscc.hibernate.models.InsuredMember;

import javax.persistence.*;
import java.util.List;

public class HibernateQueryDemo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Java3Demo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        String companyQuery = "select c from Company c where c.name = :name ";
        Query query = entityManager.createQuery(companyQuery);
        String playland = "Bouncy Castle Playland";
        query.setParameter("name", playland);
        List<Company> companies = query.getResultList();
        companies.forEach(company -> System.out.println(company));

        Query updateQuery = entityManager.createQuery("update Company set name = :name");
        updateQuery.setParameter("name", "Just Playland");
        updateQuery.executeUpdate();
        Company company = companies.get(0);
        entityManager.refresh(company);
        System.out.println(company);

        entityManager.persist(new Company("Not Playland"));
        Query deleteQuery = entityManager.createQuery("delete Company c where c.name = :name");
        deleteQuery.setParameter("name", "Not Playland");
        deleteQuery.executeUpdate();

        String insertStatement = "insert into companies (name) values (:name)";
        Query nativeQuery = entityManager.createNativeQuery(insertStatement);
        nativeQuery.setParameter("name", "Another Playland");
        nativeQuery.executeUpdate();

        TypedQuery<Company> companyTypedQuery = entityManager.createQuery("select c from Company c", Company.class);
        List<Company> typedCompanies = companyTypedQuery.getResultList();
        typedCompanies.forEach(typedCompany -> System.out.println(typedCompany));

        //In main...
        Query namedQuery = entityManager.createNamedQuery(InsuredMember.FIND_BY_NAME);
        namedQuery.setParameter("firstName", "Sarah");
        namedQuery.setParameter("lastName", "Gilbert");
        List<InsuredMember> resultList = namedQuery.getResultList();
        resultList.forEach(typedCompany -> System.out.println(typedCompany));

        entityManager.getTransaction().rollback();
    }
}
