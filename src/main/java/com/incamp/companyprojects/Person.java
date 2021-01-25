package com.incamp.companyprojects;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

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

    @JoinTable(name = "person_membership",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Company> membership;

    @ManyToMany(fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Technology> skills;

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

    public List<Technology> getSkills() {
        return skills;
    }

    public void setSkills(List<Technology> skills) {
        this.skills = skills;
    }

    public List<Company> getMembership() {
        return membership;
    }

    public void setMembership(List<Company> membership) {
        this.membership = membership;
    }
}

