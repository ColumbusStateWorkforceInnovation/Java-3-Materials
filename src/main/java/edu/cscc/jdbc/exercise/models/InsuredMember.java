package edu.cscc.jdbc.exercise.models;

public class InsuredMember {
    private Integer id;
    private Integer companyId;
    private String firstName;
    private String lastName;

    public InsuredMember(Integer companyId, String firstName, String lastName) {
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public InsuredMember(Integer id, Integer companyId, String firstName, String lastName) {
        this.id = id;
        this.companyId = companyId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    @Override
    public String toString() {
        return "InsuredMember{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
