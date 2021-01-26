package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/contribution")
public class ContributionController {
    @Autowired
    private ContributionService contribService;

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        contribService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contribution> add(@RequestBody Contribution contribution) {
        return new ResponseEntity(
                contribService.add(contribution),
                HttpStatus.OK);
    }
}
