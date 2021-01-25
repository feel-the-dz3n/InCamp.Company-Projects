package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private PersonRepository personRepository;

    public Optional<Project> get(int id) {
        return projectRepository.findById(id);
    }

    public Iterable<Project> getAll() {
        return projectRepository.findAll();
    }

    public Iterable<Project> getForPerson(Integer personId) {
        var person = personRepository.findById(personId).get();
        return StreamSupport.stream(projectRepository.findAll().spliterator(), false)
                .filter(project -> person.getMembership().contains(project.getCompany()))
                .collect(Collectors.toList());
    }
}
