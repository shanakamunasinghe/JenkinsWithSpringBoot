package com.creative.web.repository;

import com.creative.web.model.JenkinsUserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JenkinsUserRepository extends JpaRepository<JenkinsUserData,Integer> {
}
