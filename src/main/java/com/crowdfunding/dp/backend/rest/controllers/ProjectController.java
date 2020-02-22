package com.crowdfunding.dp.backend.rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/api/projects")
public class ProjectController {

    @GetMapping
    public String getProjects(){
        return "ahoj";
    }
}
