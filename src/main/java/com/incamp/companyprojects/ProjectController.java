package com.incamp.companyprojects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private ContributionRepository contribRepository;

    @GetMapping
    public ResponseEntity<Iterable<Project>> getAll() {
        return new ResponseEntity(projectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> get(
            @PathVariable int projectId) {
        var optionalProject = projectService.get(projectId);
        return new ResponseEntity(optionalProject.get(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}/contributions")
    public ResponseEntity<Project> getContributions(
            @PathVariable int projectId) {
        return new ResponseEntity(
                contribRepository.findByProject(projectId),
                HttpStatus.OK);
    }
}
