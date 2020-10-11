package edu.cscc.hibernate;

import edu.cscc.hibernate.models.Company;
import edu.cscc.hibernate.models.InsurancePolicy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class HibernateDemo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Java3Demo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Company company = entityManager.find(Company.class, 1);
        System.out.println("Company name: " + company.getName());

        InsurancePolicy lifePolicy = new InsurancePolicy("life");
        entityManager.persist(lifePolicy);
        String insurancePolicyQuery = "select ip from InsurancePolicy ip where ip.type = :type";
        TypedQuery<InsurancePolicy> query =
                entityManager.createQuery(insurancePolicyQuery, InsurancePolicy.class);
        query.setParameter("type", "life");
        List<InsurancePolicy> insurancePolicies = query.getResultList();

        InsurancePolicy foundPolicy = insurancePolicies.get(0);
        System.out.println(foundPolicy);

        entityManager.remove(foundPolicy);
    }
}
