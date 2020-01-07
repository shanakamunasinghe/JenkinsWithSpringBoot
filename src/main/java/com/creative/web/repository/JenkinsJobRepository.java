package com.creative.web.repository;

import com.creative.web.model.JenkinsJobData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JenkinsJobRepository extends JpaRepository<JenkinsJobData,Integer> {
    public JenkinsJobData findByJobName(String jobName);
}
