package com.creative.web.repository;

import com.creative.web.model.JenkinsRolesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JenkinsRolesRepository extends JpaRepository<JenkinsRolesData,Integer> {
    @Query(value = "SELECT * FROM public.jenkins_roles_data jrd WHERE jrd.jenkins_user_id = :jenkinsUserId AND jrd.type = :type",nativeQuery = true)
    public List<JenkinsRolesData> findByJenkinsUserIdAndType(Integer jenkinsUserId, String type);

    @Query(value = "SELECT * FROM public.jenkins_roles_data jrd WHERE jrd.jenkins_user_id = :jenkinsUserId AND jrd.jenkins_global_role_id = :jenkinsGlobalRoleId",nativeQuery = true)
    public JenkinsRolesData findByJenkinsUserIdAndJenkinsGlobalRoleId(Integer jenkinsUserId, Integer jenkinsGlobalRoleId);

    @Query(value = "SELECT * FROM public.jenkins_roles_data jrd WHERE jrd.jenkins_user_id = :jenkinsUserId AND jrd.jenkins_item_role_id = :jenkinsItemRoleId",nativeQuery = true)
    public JenkinsRolesData findByJenkinsUserIdAndJenkinsItemRoleId(Integer jenkinsUserId, Integer jenkinsItemRoleId);
}
