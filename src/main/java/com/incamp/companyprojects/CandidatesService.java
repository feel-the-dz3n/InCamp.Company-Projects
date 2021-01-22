package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
        return collectCandidates(
                projectService.get(projectId).get().getTechnologies()
        );
    }

    public Iterable<Person> collectCandidates(Collection<Technology> reqs) {
        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .filter(person -> person.getSkills().containsAll(reqs))
                .collect(Collectors.toList());
    }
}
