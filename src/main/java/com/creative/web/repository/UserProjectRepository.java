package com.creative.web.repository;

import com.creative.web.model.JenkinsUsersProjectsData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectRepository extends JpaRepository<JenkinsUsersProjectsData,Integer> {

}
