package com.incamp.companyprojects;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "person-id-gen",
        sequenceName = "person_id_seq",
        allocationSize = 1)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person-id-gen")
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

