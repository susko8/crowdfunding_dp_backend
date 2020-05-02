package com.crowdfunding.dp.backend.service;

import com.crowdfunding.dp.backend.dao.ProjectRepository;
import com.crowdfunding.dp.backend.dao.UserRepository;
import com.crowdfunding.dp.backend.model.Project;
import com.crowdfunding.dp.backend.model.User;
import com.crowdfunding.dp.backend.rest.dto.ProjectData;
import com.crowdfunding.dp.backend.rest.dto.ProjectFormData;
import com.crowdfunding.dp.backend.types.ProjectCategoryEnum;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Project> getAllProjects(String name, ProjectCategoryEnum category) {

        if (name != null) {
            List<Project> projects = projectRepository.findProjectsByNameContaining(name);
            if(category != null){
                return projects.stream().filter(p -> p.getCategory() == category).collect(Collectors.toList());
            }
            return projects;
        }
        List<Project> projects = projectRepository.findAll();
        if(category!=null){
            return projects.stream().filter(p -> p.getCategory() == category).collect(Collectors.toList());
        }
        return projectRepository.findAll();
    }

    public ProjectData getOneProject(Long projectId) {
        return ProjectData.from(Objects.requireNonNull(projectRepository.findById(projectId).orElse(null)));
    }

    public Project findOneProject(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public Project createNewProject(ProjectFormData projectData) {
        Optional<User> creator = userRepository.findById(projectData.getCreatedBy());
        if (creator.isPresent()) {
            Project newProject = new Project();
            newProject.setCreatedBy(creator.get());
            newProject.setDescription(projectData.getDescription());
            newProject.setName(projectData.getName());
            newProject.setSrc(projectData.getSrc());
            newProject.setCategory(projectData.getCategory());
            return projectRepository.save(newProject);
        }
        return null;
    }

    public Project editOneProject(ProjectFormData projectData){
        Project project = findOneProject(projectData.getProjectId());
        project.setDescription(projectData.getDescription());
        project.setName(projectData.getName());
        project.setSrc(projectData.getSrc());
        project.setCategory(projectData.getCategory());
        return projectRepository.save(project);
    }

    public void deleteProject(Long projectId){
        projectRepository.delete(findOneProject(projectId));
    }
}
