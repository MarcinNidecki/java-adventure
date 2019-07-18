package com.kodilla.hibernate.manytomany;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@NamedNativeQuery(
        name = "Company.findCompanyByNameStartingWith",
        query = "SELECT * FROM COMPANIES" +
                " WHERE COMPANY_NAME  LIKE CONCAT(:STARTING_WITH ,'%')",
        resultClass = Company.class
)
@NamedNativeQuery(
        name = "Company.findCompaniesByNameContaining",
        query = "SELECT * FROM COMPANIES WHERE COMPANY_NAME LIKE CONCAT('%',:CONTAINING_STRING,'%')",
        resultClass = Company.class
)

@Entity
@Table(name = "COMPANIES")
public class Company {
    private int id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public Company(int id, String name, List<Employee> employees) {
        this.id =id;
        this.name = name;
        this.employees =employees;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "COMPANY_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "COMPANY_NAME")
    public String getName() {
        return name;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }
    @ManyToMany (cascade =  CascadeType.ALL, mappedBy = "companies")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}