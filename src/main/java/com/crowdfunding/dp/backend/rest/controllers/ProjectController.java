package com.crowdfunding.dp.backend.rest.controllers;

import com.crowdfunding.dp.backend.model.Project;
import com.crowdfunding.dp.backend.model.Transaction;
import com.crowdfunding.dp.backend.rest.dto.ContributionData;
import com.crowdfunding.dp.backend.rest.dto.ProjectData;
import com.crowdfunding.dp.backend.rest.dto.ProjectFormData;
import com.crowdfunding.dp.backend.service.ProjectService;
import com.crowdfunding.dp.backend.service.TransactionService;
import com.crowdfunding.dp.backend.types.ProjectCategoryEnum;
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

    @Autowired
    TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(@RequestParam String name, @RequestParam ProjectCategoryEnum category){
        return new ResponseEntity<>(projectService.getAllProjects(name, category), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectData> getOneProjects(@PathVariable("id") Long projectId){
        return new ResponseEntity<>(projectService.getOneProject(projectId), HttpStatus.OK);
    }

    @GetMapping("/contributions")
    public ResponseEntity<List<Transaction>> getAllContributions(){
        return new ResponseEntity<>(transactionService.getAllTransactions(), HttpStatus.OK);
    }

    @GetMapping("/contributions/{id}")
    public ResponseEntity<List<Transaction>> getContributionsForProject(@PathVariable("id") Long projectId){
        return new ResponseEntity<>(transactionService.getTransactionsForProject(projectId), HttpStatus.OK);
    }

    @PostMapping("/contribute/{id}")
    public ResponseEntity<List<Transaction>> contributeToProject(@PathVariable("id") Long projectId, @RequestBody ContributionData contributionData){
        return new ResponseEntity<>(transactionService.contributeToProject(projectId, contributionData), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Project> createNewProject(@RequestBody ProjectFormData project){
        return new ResponseEntity<>(projectService.createNewProject(project), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable("id") Long projectId){
        projectService.deleteProject(projectId);
    }
}
