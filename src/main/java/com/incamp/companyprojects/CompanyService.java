package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public Iterable<Company> getCompanies() {
        return null; // FIXME
    }

    public Company getCompany(Integer id) {
        return null; // FIXME
    }
}
