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

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<Iterable<Person>> get(
            @RequestHeader("Authorization") String token,
            @RequestParam Integer projectId) {
        if (!userService.isUserManaging(token, projectId))
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        return new ResponseEntity(candidatesService.collectCandidates(projectId), HttpStatus.OK);
    }
}
