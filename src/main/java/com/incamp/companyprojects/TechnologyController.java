package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/skills")
public class TechnologyController {
    @Autowired
    private TechnologyRepository technologyRepository;

    @GetMapping
    public ResponseEntity<Iterable<Technology>> get() {
        return new ResponseEntity(technologyRepository.findAll(), HttpStatus.OK);
    }
}
