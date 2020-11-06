package edu.cscc.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//On the InsuredMember
@Entity
@Table(name = "insured_members")
@NamedQuery(
        name = InsuredMember.FIND_BY_NAME,
        query = "select im from InsuredMember im where im.firstName = :firstName and im.lastName = :lastName"
)
public class InsuredMember {

    public static final String FIND_BY_NAME = "InsuredMember.findByName";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    private Company company;

    @ManyToMany
    @JoinTable(name = "insured_member_insurance_policies",
            joinColumns = @JoinColumn(name = "insured_member_id"),
            inverseJoinColumns = @JoinColumn(name = "insurance_policy_id"))
    private List<InsurancePolicy> insurancePolicies;

    public InsuredMember() {
        this.insurancePolicies = new ArrayList<>();
    }

    public InsuredMember(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.insurancePolicies = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<InsurancePolicy> getInsurancePolicies() {
        return insurancePolicies;
    }

    public void setInsurancePolicies(List<InsurancePolicy> insurancePolicies) {
        this.insurancePolicies = insurancePolicies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuredMember that = (InsuredMember) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "InsuredMember{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
