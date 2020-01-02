package com.creative.web.repository;

import com.creative.web.model.JenkinsUsersProjectsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository<JenkinsUsersProjectsData,Integer> {

}
