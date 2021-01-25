package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/company")
public class CompanyController {
    @Autowired
    private UserService userService;

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public ResponseEntity<Iterable<Company>> getCompanies(
            @RequestHeader("Authorization") String token) {
        if (userService.get(token) == null)
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        return new ResponseEntity(companyService.getCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer id) {
        if (userService.get(token) == null)
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        var optionalCompany = companyService.getCompany(id);

        if (optionalCompany.isPresent())
            return new ResponseEntity(optionalCompany.get(), HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/projects")
    public ResponseEntity<Iterable<CompanyProjectDTO>> getCompanyProjects(
            @RequestHeader("Authorization") String token,
            @PathVariable Integer id) {
        if (userService.get(token) == null)
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);

        return new ResponseEntity(companyService.getCompanyProjects(id), HttpStatus.OK);
    }
}
