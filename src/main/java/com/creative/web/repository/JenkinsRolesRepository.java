package com.creative.web.repository;

import com.creative.web.model.JenkinsRolesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenkinsRolesRepository extends JpaRepository<JenkinsRolesData,Integer> {
}
