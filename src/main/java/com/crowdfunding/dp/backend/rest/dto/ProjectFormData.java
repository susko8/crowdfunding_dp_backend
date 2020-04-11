package com.crowdfunding.dp.backend.rest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectFormData {

    String name;

    String description;

    String src;

    Long createdBy;
}
