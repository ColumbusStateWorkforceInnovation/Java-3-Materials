package edu.cscc.hibernate.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy {

    public static final String ACCIDENTAL_DEATH_DISMEMBERMENT = "accidental-death-dismemberment";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "type")
    private String type;

    public InsurancePolicy() {}

    public InsurancePolicy(String type) {
        this.type = type;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, type);
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", type='" + type + '\'' +
                '}';
    }
}
