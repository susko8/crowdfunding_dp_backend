package com.crowdfunding.dp.backend.dao;

import com.crowdfunding.dp.backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
