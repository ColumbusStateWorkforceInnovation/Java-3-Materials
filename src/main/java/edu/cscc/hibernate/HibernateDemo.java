package edu.cscc.hibernate;

import edu.cscc.hibernate.models.Company;
import edu.cscc.hibernate.models.InsurancePolicy;
import edu.cscc.hibernate.models.InsuredMember;

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

        entityManager.getTransaction().begin();

        InsurancePolicy accidentalDeathDismembermentPolicy = new InsurancePolicy(InsurancePolicy.ACCIDENTAL_DEATH_DISMEMBERMENT);
        accidentalDeathDismembermentPolicy.setCompanyId(company.getId());
        entityManager.persist(accidentalDeathDismembermentPolicy);
        String insurancePolicyQuery = "select ip from InsurancePolicy ip where ip.type = :type";
        TypedQuery<InsurancePolicy> query =
                entityManager.createQuery(insurancePolicyQuery, InsurancePolicy.class);
        query.setParameter("type", InsurancePolicy.ACCIDENTAL_DEATH_DISMEMBERMENT);
        List<InsurancePolicy> insurancePolicies = query.getResultList();

        InsurancePolicy foundPolicy = insurancePolicies.get(0);
        System.out.println(foundPolicy);

        InsuredMember insuredMember = new InsuredMember("Baker", "Mayfield");
        insuredMember.setCompanyId(company.getId());
        entityManager.persist(insuredMember);

        String insuredMemberQuery = "select im from InsuredMember im order by im.id desc";
        InsuredMember foundMember = (InsuredMember) entityManager.createQuery(insuredMemberQuery).getResultList().get(0);
        System.out.println(foundMember);

        entityManager.remove(foundPolicy);
        entityManager.remove(foundMember);

        entityManager.getTransaction().commit();
    }
}
