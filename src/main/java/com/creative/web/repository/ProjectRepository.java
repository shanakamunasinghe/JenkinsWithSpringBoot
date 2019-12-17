package com.creative.web.repository;

import com.creative.web.model.ProjectData;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProjectRepository extends JpaRepository<ProjectData,Integer> {
}
