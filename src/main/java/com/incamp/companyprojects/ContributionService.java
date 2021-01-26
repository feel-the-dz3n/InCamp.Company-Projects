package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContributionService {
    @Autowired
    private ContributionRepository contribRepository;

    public Contribution add(Contribution contrib) {
        return contribRepository.save(contrib);
    }

    public void delete(Integer id) {
        contribRepository.deleteById(id);
    }
}
