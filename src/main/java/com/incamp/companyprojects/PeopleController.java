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
    private UserService userService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ContributionRepository contribRepository;

    @GetMapping
    public ResponseEntity<Iterable<Person>> getAll(
            @RequestHeader("Authorization") String token) {
        if (userService.get(token) == null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> get(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer personId) {
        if (userService.get(token) == null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        var optionalPerson = personRepository.findById(personId);

        if (optionalPerson.isPresent())
            return new ResponseEntity(optionalPerson.get(), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{personId}/contributions")
    public ResponseEntity<Iterable<ContributionProjectDTO>> getContributions(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer personId) {
        if (userService.get(token) == null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(
                contribRepository.findContributionProjectByPerson(personId),
                HttpStatus.OK);
    }
}
