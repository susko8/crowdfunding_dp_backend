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
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="projectid")
    Long id;

    @Column(name="projectname")
    String ProjectName;
}
