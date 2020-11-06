package edu.cscc.hibernate;

import edu.cscc.hibernate.models.Company;
import edu.cscc.hibernate.models.InsurancePolicy;
import edu.cscc.hibernate.models.InsuredMember;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class HibernateRelationshipsDemo {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Java3Demo");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        InsuredMember insuredMember = entityManager.find(InsuredMember.class, 1);
        Company company = insuredMember.getCompany();
        System.out.println(company);

        //In main
        insuredMember.getInsurancePolicies().forEach(insurancePolicy -> System.out.println(insurancePolicy));
        InsurancePolicy addInsurancePolicy = new InsurancePolicy(company, InsurancePolicy.ACCIDENTAL_DEATH_DISMEMBERMENT);
        addInsurancePolicy.getInsuredMembers().add(insuredMember);
        insuredMember.getInsurancePolicies().add(addInsurancePolicy);
        entityManager.persist(addInsurancePolicy);

        //Find the member and show that the policy was added
        Query findInsuredMemberByNameQuery = entityManager.createNamedQuery(InsuredMember.FIND_BY_NAME);
        findInsuredMemberByNameQuery.setParameter("firstName", insuredMember.getFirstName());
        findInsuredMemberByNameQuery.setParameter("lastName", insuredMember.getLastName());
        List<InsuredMember> insuredMembers = findInsuredMemberByNameQuery.getResultList();
        InsuredMember foundMember = insuredMembers.get(0);
        System.out.println(foundMember);
        foundMember.getInsurancePolicies().forEach(insurancePolicy -> {System.out.println(insurancePolicy);});

        //Delete the policy
        Optional<InsurancePolicy> optional = foundMember.getInsurancePolicies().stream().filter(insurancePolicy -> insurancePolicy.getType().equals(InsurancePolicy.ACCIDENTAL_DEATH_DISMEMBERMENT)).findFirst();
        InsurancePolicy insurancePolicy = optional.get();
        insurancePolicy.getInsuredMembers().forEach(addMember -> {System.out.println(addMember);});
        String deleteQueryString = "delete from InsurancePolicy ip where ip.id = :id";
        Query deleteQuery = entityManager.createQuery(deleteQueryString);
        deleteQuery.setParameter("id", insurancePolicy.getId());
        deleteQuery.executeUpdate();

        entityManager.getTransaction().rollback();
    }
}
