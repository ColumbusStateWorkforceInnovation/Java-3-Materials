package edu.cscc.jdbc.exercise;

public class InsurancePolicy {

    private Integer id;
    private Integer companyId;
    private String type;

    public InsurancePolicy(Integer companyId, String type) {
        this.companyId = companyId;
        this.type = type;
    }

    public InsurancePolicy(Integer id, Integer companyId, String type) {
        this.id = id;
        this.companyId = companyId;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
