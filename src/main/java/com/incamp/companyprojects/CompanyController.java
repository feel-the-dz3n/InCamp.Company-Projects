package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/company")
@CrossOrigin
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping
    public Iterable<Company> getCompanies() {
        return companyService.getCompanies();
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable Integer id) {
        return companyService.getCompany(id).get();
    }
}
