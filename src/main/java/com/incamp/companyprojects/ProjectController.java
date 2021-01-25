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
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<Iterable<Project>> getAll(
            @RequestHeader("Authorization") String token) {
        if (userService.get(token) == null) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(projectService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> get(
            @RequestHeader("Authorization") String token,
            @PathVariable int projectId) {
        if (!userService.isUserManaging(token, projectId)) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }

        var optionalProject = projectService.get(projectId);
        return new ResponseEntity(optionalProject.get(), HttpStatus.OK);
    }
}
