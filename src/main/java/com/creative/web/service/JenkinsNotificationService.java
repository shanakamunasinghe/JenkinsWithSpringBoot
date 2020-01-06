package com.creative.web.service;

import com.creative.web.dto.JenkinsJobHistoryDTO;
import com.creative.web.dto.JenkinsNotificationDTO;
import com.creative.web.model.JenkinsJobData;
import com.creative.web.model.JenkinsJobHistoryData;
import com.creative.web.repository.JenkinsJobHistoryRepository;
import com.creative.web.repository.JenkinsJobRepository;
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

    // get according to the job name
    public List<JenkinsJobHistoryDTO> getJenkinsJobHistory(String jobName){
        List<JenkinsJobHistoryData> jenkinsJobHistoryData = new ArrayList<>();
        List<JenkinsJobHistoryDTO> jenkinsJobHistoryDTOS = new ArrayList<>();

        JenkinsJobData jenkinsJobData = jenkinsJobRepository.findByJobName(jobName);
        jenkinsJobHistoryData = jenkinsJobHistoryRepository.findByJenkinsJob(jenkinsJobData);

        return getJenkinsJobHistoryDTOS(jenkinsJobHistoryData, jenkinsJobHistoryDTOS);
    }

    // get all the job history data
    public List<JenkinsJobHistoryDTO> getAllJenkinsJobHistory(){
        List<JenkinsJobHistoryData> jenkinsJobHistoryData = new ArrayList<>();
        List<JenkinsJobHistoryDTO> jenkinsJobHistoryDTOS = new ArrayList<>();
        jenkinsJobHistoryData = jenkinsJobHistoryRepository.findAll();

        return getJenkinsJobHistoryDTOS(jenkinsJobHistoryData, jenkinsJobHistoryDTOS);
    }

    private List<JenkinsJobHistoryDTO> getJenkinsJobHistoryDTOS(List<JenkinsJobHistoryData> jenkinsJobHistoryData, List<JenkinsJobHistoryDTO> jenkinsJobHistoryDTOS) {
        if(!jenkinsJobHistoryData.isEmpty()){
            for(JenkinsJobHistoryData jb : jenkinsJobHistoryData){
                JenkinsJobHistoryDTO jbDTO = new JenkinsJobHistoryDTO();
                jbDTO.setId(jb.getId());
                jbDTO.setJobId(jb.getJenkinsJob().getId());
                jbDTO.setJobName(jb.getJenkinsJob().getJobName());
                jbDTO.setPhase(jb.getPhase());
                jbDTO.setStatus(jb.getStatus());
                jenkinsJobHistoryDTOS.add(jbDTO);
            }
        }

        return jenkinsJobHistoryDTOS;
    }
}
