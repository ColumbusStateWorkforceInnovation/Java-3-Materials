package edu.cscc.hibernate.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy {

    public static final String ACCIDENTAL_DEATH_DISMEMBERMENT = "accidental-death-dismemberment";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Other properties
    @ManyToOne
    private Company company;

    @Column(name = "type")
    private String type;

    @ManyToMany(mappedBy = "insurancePolicies")
    private List<InsuredMember> insuredMembers;

    public InsurancePolicy() {
        insuredMembers = new ArrayList<>();
    }

    public InsurancePolicy(String type) {
        this.type = type;
        insuredMembers = new ArrayList<>();
    }

    public InsurancePolicy(Company company, String type) {
        this.company = company;
        this.type = type;
        insuredMembers = new ArrayList<>();
    }

    //Getters and setters, other methods

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<InsuredMember> getInsuredMembers() {
        return insuredMembers;
    }

    public void setInsuredMembers(List<InsuredMember> insuredMembers) {
        this.insuredMembers = insuredMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
