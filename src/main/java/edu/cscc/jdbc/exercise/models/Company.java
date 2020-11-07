package edu.cscc.jdbc.exercise.models;

public class Company {

    private Integer id;
    private String name;

    public Company(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Company(String name) {
        this.name = name;
    }

    //Getters and Setters...

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Other methods...

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
