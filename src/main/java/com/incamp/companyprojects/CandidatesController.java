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
            @RequestParam Integer projectId,
            @RequestParam boolean checkProjectMembership,
            @RequestParam boolean checkCompanyMembership,
            @RequestParam boolean checkSkills,
            @RequestParam boolean noTargetProjectContrib) {
        return new ResponseEntity(
                candidatesService.collectCandidates(
                        projectId,
                        checkProjectMembership,
                        checkCompanyMembership,
                        checkSkills,
                        noTargetProjectContrib),
                HttpStatus.OK);
    }
}
