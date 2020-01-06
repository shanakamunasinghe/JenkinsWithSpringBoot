package com.creative.web.repository;

import com.creative.web.model.JenkinsJobData;
import com.creative.web.model.JenkinsJobHistoryData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JenkinsJobHistoryRepository extends JpaRepository<JenkinsJobHistoryData,Integer> {
    List<JenkinsJobHistoryData> findByJenkinsJob(JenkinsJobData jenkinsJobData);
}
