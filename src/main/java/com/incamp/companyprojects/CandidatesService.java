package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class CandidatesService {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private PersonRepository personRepository;

    public Iterable<Person> collectCandidates(Integer projectId) {
        var project = projectService.get(projectId).get();
        return collectCandidates(
                List.of(project.getCompany()),
                project.getTechnologies(),
                project);
    }

    public Iterable<Person> collectCandidates(
            Collection<Company> membership,
            Collection<Technology> techRequirements,
            Project excludeProjectPeople) {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .filter(person -> excludeProjectPeople == null
                        || !excludeProjectPeople.getPeople().contains(person))
                .filter(person -> person.getMembership().containsAll(membership))
                .filter(person -> person.getSkills().containsAll(techRequirements))
                .collect(Collectors.toList());
    }
}
