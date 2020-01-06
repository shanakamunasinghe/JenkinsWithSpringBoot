package com.creative.web.repository;

import com.creative.web.model.JenkinsJobData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JenkinsJobRepository extends JpaRepository<JenkinsJobData,Integer> {
    public JenkinsJobData findByJobName(String jobName);
}
