package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public Iterable<Project> getAll() {
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Project get(@PathVariable int id) {
        return projectService.get(id).get();
    }
}
