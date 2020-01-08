package com.creative.web.repository;

import com.creative.web.model.JenkinsGlobalRoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenkinsGlobalRoleRepository extends JpaRepository<JenkinsGlobalRoleData,Integer> {
    public JenkinsGlobalRoleData findByName(String roleName);
}
