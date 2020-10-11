package edu.cscc.hibernate;

import edu.cscc.hibernate.models.Company;
import edu.cscc.hibernate.models.InsurancePolicy;
import edu.cscc.hibernate.models.InsuredMember;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.File;
import java.util.List;

public class HibernateDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure(new File("resources/META-INF/hibernate.cfg.xml")).buildSessionFactory();
        Session session = sessionFactory.openSession();
        Company company = session.find(Company.class, 1);
        System.out.println("Company name: " + company.getName());
        company.getInsuredMembers().forEach(insuredMember -> System.out.println(insuredMember));

        session.getTransaction().begin();

        InsurancePolicy accidentalDeathDismembermentPolicy = new InsurancePolicy(InsurancePolicy.ACCIDENTAL_DEATH_DISMEMBERMENT);
        accidentalDeathDismembermentPolicy.setCompanyId(company.getId());
        session.persist(accidentalDeathDismembermentPolicy);
        String insurancePolicyQuery = "select ip from InsurancePolicy ip where ip.type = :type";
        TypedQuery<InsurancePolicy> query =
                session.createQuery(insurancePolicyQuery, InsurancePolicy.class);
        query.setParameter("type", InsurancePolicy.ACCIDENTAL_DEATH_DISMEMBERMENT);
        List<InsurancePolicy> insurancePolicies = query.getResultList();

        InsurancePolicy foundPolicy = insurancePolicies.get(0);
        System.out.println(foundPolicy);

        InsuredMember insuredMember = new InsuredMember("Baker", "Mayfield");
        insuredMember.setCompany(company);
        session.persist(insuredMember);

        String insuredMemberQuery = "select im from InsuredMember im order by im.id desc";
        InsuredMember foundMember = (InsuredMember) session.createQuery(insuredMemberQuery).getResultList().get(0);
        System.out.println(foundMember);

        session.remove(foundPolicy);
        session.remove(foundMember);

        session.getTransaction().rollback();
        session.close();
    }
}
