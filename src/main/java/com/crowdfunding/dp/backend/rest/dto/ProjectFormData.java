package com.crowdfunding.dp.backend.rest.dto;

import com.crowdfunding.dp.backend.types.ProjectCategoryEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectFormData {

    Long projectId;

    String name;

    String description;

    String src;

    Long createdBy;

    ProjectCategoryEnum category;
}
