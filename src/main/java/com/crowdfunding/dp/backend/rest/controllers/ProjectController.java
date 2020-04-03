package com.crowdfunding.dp.backend.rest.controllers;

import com.crowdfunding.dp.backend.model.Project;
import com.crowdfunding.dp.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("rest/api/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getOneProjects(@PathVariable("id") Long projectId){
        return new ResponseEntity<>(projectService.getOneProject(projectId), HttpStatus.OK);
    }
}
