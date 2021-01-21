package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/company")
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

    @GetMapping("/{id}/projects")
    public Iterable<CompanyProjectDTO> getCompanyProjects(@PathVariable Integer id) {
        return companyService.getCompanyProjects(id);
    }
}
