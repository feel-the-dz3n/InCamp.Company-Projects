package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/candidates")
public class CandidatesController {
    @Autowired
    private CandidatesService candidatesService;

    @GetMapping
    public Iterable<Person> get(@RequestParam Integer projectId) {
        return candidatesService.collectCandidates(projectId);
    }
}
