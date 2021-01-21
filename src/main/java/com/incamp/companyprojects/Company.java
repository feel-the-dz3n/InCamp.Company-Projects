package com.incamp.companyprojects;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "company-id-gen",
        sequenceName = "COMPANY_SEQ",
        allocationSize = 1)
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company-id-gen")
    private Integer id;
    private String name;

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
}
