package com.creative.web.repository;

import com.creative.web.model.JenkinsProjectData;
import org.springframework.data.jpa.repository.JpaRepository;



public interface JenkinsProjectRepository extends JpaRepository<JenkinsProjectData,Integer> {
}
