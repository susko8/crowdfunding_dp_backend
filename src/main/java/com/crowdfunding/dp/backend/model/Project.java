package com.crowdfunding.dp.backend.model;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="createdby")
    private User createdBy;
}
