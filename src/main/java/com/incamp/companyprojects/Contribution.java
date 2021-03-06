package com.incamp.companyprojects;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@SequenceGenerator(
        name = "contrib-id-gen",
        sequenceName = "contrib_id_seq",
        allocationSize = 1)
public class Contribution {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contrib-id-gen")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Person person;

    @JoinTable(name = "contrib_technologies",
            joinColumns = @JoinColumn(name = "contrib_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    @ManyToMany(fetch = FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Technology> technologies;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Technology> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<Technology> technologies) {
        this.technologies = technologies;
    }
}
