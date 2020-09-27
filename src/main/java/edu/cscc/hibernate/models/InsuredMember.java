package edu.cscc.hibernate.models;

import javax.persistence.*;
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

    @ManyToOne()
    private Company company;

    public InsuredMember() {
    }

    public InsuredMember(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsuredMember that = (InsuredMember) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, company);
    }

    @Override
    public String toString() {
        return "InsuredMember{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", company=" + company +
                '}';
    }
}
