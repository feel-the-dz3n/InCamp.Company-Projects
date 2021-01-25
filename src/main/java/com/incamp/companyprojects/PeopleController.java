package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/people")
public class PeopleController {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContributionRepository contribRepository;

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<Iterable<Person>> getAll() {
        return new ResponseEntity(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> get(
            @PathVariable Integer personId) {
        var optionalPerson = personRepository.findById(personId);

        if (optionalPerson.isPresent())
            return new ResponseEntity(optionalPerson.get(), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{personId}/contributions")
    public ResponseEntity<Iterable<Contribution>> getContributions(
            @PathVariable Integer personId) {
        return new ResponseEntity(
                contribRepository.findByPerson(personId),
                HttpStatus.OK);
    }

    @GetMapping("/{personId}/membership-projects")
    public ResponseEntity<Iterable<Project>> getMembershipProjects(
            @PathVariable Integer personId) {
        return new ResponseEntity(
                projectService.getForPerson(personId),
                HttpStatus.OK);
    }
}
