package com.crowdfunding.dp.backend.model;

import com.crowdfunding.dp.backend.types.ProjectCategoryEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="projectid")
    private Long id;

    @Column(name="projectname")
    private String name;

    @Column(name="projectdescription")
    private String description;

    @Column(name="projectimagesrc")
    private String src;

    @Column(name="projectcategory")
    private ProjectCategoryEnum category;

    @OneToOne
    @JoinColumn(name="createdby")
    private User createdBy;
}
