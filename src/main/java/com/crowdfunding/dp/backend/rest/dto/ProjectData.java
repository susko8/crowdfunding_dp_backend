package com.crowdfunding.dp.backend.rest.dto;

import com.crowdfunding.dp.backend.model.Project;
import com.crowdfunding.dp.backend.types.ProjectCategoryEnum;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProjectData {

    Long id;

    String name;

    String description;

    String src;

    ProjectCategoryEnum category;

    String createdBy;

    public static ProjectData from(Project project){
        ProjectData projectData = new ProjectData();
        projectData.id = project.getId();
        projectData.createdBy = project.getCreatedBy().getLogin();
        projectData.description = project.getDescription();
        projectData.src = project.getSrc();
        projectData.name = project.getName();
        projectData.category = project.getCategory();
        return projectData;

    }
}
