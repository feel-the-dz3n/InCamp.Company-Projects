package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/candidates")
public class CandidatesController {
    @Autowired
    private CandidatesService candidatesService;

    @GetMapping
    public ResponseEntity<Iterable<Person>> get(
            @RequestParam Integer projectId) {
        return new ResponseEntity(candidatesService.collectCandidates(projectId), HttpStatus.OK);
    }
}
