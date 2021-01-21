package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Optional<Project> get(int id) {
        return projectRepository.findById(id);
    }

    public Iterable<Project> getAll() {
        return projectRepository.findAll();
    }
}
