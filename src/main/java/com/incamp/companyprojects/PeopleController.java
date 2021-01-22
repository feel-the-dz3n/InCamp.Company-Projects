package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/people")
public class PeopleController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContributionRepository contribRepository;

    @GetMapping
    public Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person get(@PathVariable Integer id) {
        return personRepository.findById(id).get();
    }

    @GetMapping("/{personId}/contributions")
    public Iterable<ContributionProjectDTO> getContributions(@PathVariable Integer personId) {
        return contribRepository.findContributionProjectByPerson(personId);
    }
}
