package com.crowdfunding.dp.backend.service;

import com.crowdfunding.dp.backend.dao.ProjectRepository;
import com.crowdfunding.dp.backend.model.Project;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getOneProject(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }
}
