package com.creative.web.repository;

import com.creative.web.model.JenkinsJobData;
import com.creative.web.model.JenkinsJobHistoryData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JenkinsJobHistoryRepository extends JpaRepository<JenkinsJobHistoryData,Integer> {
    List<JenkinsJobHistoryData> findByJenkinsJob(JenkinsJobData jenkinsJobData);
}
