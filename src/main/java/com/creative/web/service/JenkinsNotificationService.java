package com.creative.web.service;

import com.creative.web.dto.JenkinsNotificationDTO;
import com.creative.web.model.JenkinsJobData;
import com.creative.web.model.JenkinsJobHistoryData;
import com.creative.web.repository.JenkinsJobHistoryRepository;
import com.creative.web.repository.JenkinsJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JenkinsNotificationService {
    private final JenkinsJobHistoryRepository jenkinsJobHistoryRepository;
    private final JenkinsJobRepository jenkinsJobRepository;

    public JenkinsNotificationService(JenkinsJobHistoryRepository jenkinsJobHistoryRepository, JenkinsJobRepository jenkinsJobRepository) {
        this.jenkinsJobHistoryRepository = jenkinsJobHistoryRepository;
        this.jenkinsJobRepository = jenkinsJobRepository;
    }

    public void SaveJenkinsJobHistory(JenkinsNotificationDTO notification){
        JenkinsJobHistoryData jenkinsJobHistoryData = new JenkinsJobHistoryData();

        // i have to check whether the
        //JenkinsJobData jenkinsJobData = jenkinsJobRepository.findByJobName(notification.getName());
        //jenkinsJobHistoryData.setJenkinsJobData(jenkinsJobData);
        jenkinsJobHistoryData.setPhase(notification.getBuild().getPhase());
        jenkinsJobHistoryData.setStatus(notification.getBuild().getStatus());
        //jenkinsJobHistoryRepository.save(jenkinsJobHistoryData);

        // i have to catch according to pattern plz check it

    }

    public List<JenkinsJobHistoryData> getJenkinsJobHistory(String jobName){
        List<JenkinsJobHistoryData> jenkinsJobHistoryData = new ArrayList<>();
        JenkinsJobData jenkinsJobData = jenkinsJobRepository.findByJobName(jobName);
        jenkinsJobHistoryData = jenkinsJobHistoryRepository.findByJenkinsJob(jenkinsJobData);

        return jenkinsJobHistoryData;
    }

    public List<JenkinsJobHistoryData> getAllJenkinsJobHistory(){
        List<JenkinsJobHistoryData> jenkinsJobHistoryData = new ArrayList<>();
        jenkinsJobHistoryData = jenkinsJobHistoryRepository.findAll();
        return jenkinsJobHistoryData;
    }
}
