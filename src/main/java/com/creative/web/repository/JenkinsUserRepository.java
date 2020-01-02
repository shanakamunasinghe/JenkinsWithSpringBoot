package com.creative.web.repository;

import com.creative.web.model.JenkinsUserData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JenkinsUserRepository extends JpaRepository<JenkinsUserData,Integer> {
}
