package com.creative.web.repository;
import com.creative.web.model.JenkinsItemRoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenkinsItemRoleRepository extends JpaRepository<JenkinsItemRoleData,Integer> {
}
