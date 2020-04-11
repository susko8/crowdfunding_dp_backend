package com.crowdfunding.dp.backend.service;

import com.crowdfunding.dp.backend.dao.ProjectRepository;
import com.crowdfunding.dp.backend.dao.UserRepository;
import com.crowdfunding.dp.backend.model.Project;
import com.crowdfunding.dp.backend.model.User;
import com.crowdfunding.dp.backend.rest.dto.ProjectData;
import com.crowdfunding.dp.backend.rest.dto.ProjectFormData;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {

    private ProjectRepository projectRepository;

    private UserRepository userRepository;

    public ProjectService(ProjectRepository projectRepository,
                          UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public ProjectData getOneProject(Long projectId) {
        return ProjectData.from(Objects.requireNonNull(projectRepository.findById(projectId).orElse(null)));
    }

    public Project createNewProject(ProjectFormData projectData) {
        Optional<User> creator = userRepository.findById(projectData.getCreatedBy());
        if (creator.isPresent()) {
            Project newProject = new Project();
            newProject.setCreatedBy(creator.get());
            newProject.setDescription(projectData.getDescription());
            newProject.setName(projectData.getName());
            newProject.setSrc(projectData.getSrc());
            return projectRepository.save(newProject);
        }
        return null;
    }
}
