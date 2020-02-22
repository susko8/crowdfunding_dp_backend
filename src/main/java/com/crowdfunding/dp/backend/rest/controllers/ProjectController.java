package com.crowdfunding.dp.backend.rest.controllers;

import com.crowdfunding.dp.backend.model.project.Project;
import com.crowdfunding.dp.backend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest/api/projects")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(){
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }
}
