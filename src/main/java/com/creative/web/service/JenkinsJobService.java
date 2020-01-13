package com.creative.web.service;

import com.creative.web.dto.AutomationToolDataDTO;
import com.creative.web.dto.JenkinsJobDataDTO;
import com.creative.web.dto.ProjectDataDTO;
import com.creative.web.model.JenkinsJobData;
import com.creative.web.repository.JenkinsJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JenkinsJobService {

    @Autowired
    public JenkinsJobRepository jenkinsJobRepository;

    public List<JenkinsJobDataDTO> getAllJenkinsJobs(){
        List<JenkinsJobData> jenkinsJobData = jenkinsJobRepository.findAll();
        List<JenkinsJobDataDTO> jenkinsJobDataDTOS = new ArrayList<>();
        for(JenkinsJobData jenkinsJD: jenkinsJobData){
            jenkinsJobDataDTOS.add(mapJenkinsJobDataToDTO(jenkinsJD));
        }
        return jenkinsJobDataDTOS;
    }

    public JenkinsJobDataDTO getJenkinsJobById(int id){
        JenkinsJobData jenkinsJD = jenkinsJobRepository.getOne(id);
        return mapJenkinsJobDataToDTO(jenkinsJD);
    }

    public JenkinsJobDataDTO mapJenkinsJobDataToDTO(JenkinsJobData jenkinsJD){
        JenkinsJobDataDTO jenkinsJobDataDTO = new JenkinsJobDataDTO();
        jenkinsJobDataDTO.setId(jenkinsJD.getId());
        jenkinsJobDataDTO.setJobName(jenkinsJD.getJobName());
        jenkinsJobDataDTO.setDescription(jenkinsJD.getDescription());
        jenkinsJobDataDTO.setStatus(jenkinsJD.getStatus());

        ProjectDataDTO projectDataDTO = new ProjectDataDTO();
        projectDataDTO.setId(jenkinsJD.getProjectData().getId());
        projectDataDTO.setName(jenkinsJD.getProjectData().getName());

        AutomationToolDataDTO automationToolDataDTO = new AutomationToolDataDTO();
        automationToolDataDTO.setId(jenkinsJD.getProjectData().getAutomationToolData().getId());
        automationToolDataDTO.setName(jenkinsJD.getProjectData().getAutomationToolData().getName());
        projectDataDTO.setAutomationToolDataDTO(automationToolDataDTO);
        jenkinsJobDataDTO.setProjectDataDTO(projectDataDTO);
        return jenkinsJobDataDTO;
    }


}
