package com.creative.web.service;

import com.creative.web.dto.AutomationToolDataDTO;
import com.creative.web.dto.JenkinsItemRoleDataDTO;
import com.creative.web.dto.ProjectDataDTO;
import com.creative.web.model.JenkinsItemRoleData;
import com.creative.web.repository.JenkinsItemRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JenkinsItemRoleService {

    @Autowired
    public JenkinsItemRoleRepository jenkinsItemRoleRepository;

    public List<JenkinsItemRoleDataDTO> getAllItemRoleData(){
        List<JenkinsItemRoleDataDTO> jenkinsItemRoleDataDTOS = new ArrayList<>();
        List<JenkinsItemRoleData> jenkinsItemRoleData = jenkinsItemRoleRepository.findAll();

        for(JenkinsItemRoleData jIRD : jenkinsItemRoleData){
            jenkinsItemRoleDataDTOS.add(mapJenkinsItemRoleDataToDTO(jIRD));
        }
        return jenkinsItemRoleDataDTOS;
    }

    public JenkinsItemRoleDataDTO getItemRoleById(int id){
        JenkinsItemRoleData jIRD = jenkinsItemRoleRepository.getOne(id);
        return mapJenkinsItemRoleDataToDTO(jIRD);
    }

    public JenkinsItemRoleDataDTO mapJenkinsItemRoleDataToDTO(JenkinsItemRoleData jIRD){
        JenkinsItemRoleDataDTO jenkinsItemRoleDataDTO = new JenkinsItemRoleDataDTO();
        jenkinsItemRoleDataDTO.setId(jIRD.getId());
        jenkinsItemRoleDataDTO.setName(jIRD.getName());
        jenkinsItemRoleDataDTO.setPattern(jIRD.getPattern());
        // set up project data DTO
        ProjectDataDTO projectDataDTO = new ProjectDataDTO();
        projectDataDTO.setId(jIRD.getProjectData().getId());
        // set up automation tool
        AutomationToolDataDTO automationToolDataDTO = new AutomationToolDataDTO();
        automationToolDataDTO.setId(jIRD.getProjectData().getAutomationToolData().getId());
        automationToolDataDTO.setName(jIRD.getProjectData().getAutomationToolData().getName());
        automationToolDataDTO.setDescription(jIRD.getProjectData().getAutomationToolData().getDescription());

        projectDataDTO.setAutomationToolDataDTO(automationToolDataDTO);
        projectDataDTO.setName(jIRD.getProjectData().getName());

        jenkinsItemRoleDataDTO.setProjectDataDTO(projectDataDTO);
        jenkinsItemRoleDataDTO.setStatus(jIRD.getStatus());

        jenkinsItemRoleDataDTO.setCredentialsCreate(jIRD.isCredentialsCreate());
        jenkinsItemRoleDataDTO.setCredentialsDelete(jIRD.isCredentialsDelete());
        jenkinsItemRoleDataDTO.setCredentialsUpdate(jIRD.isCredentialsUpdate());
        jenkinsItemRoleDataDTO.setCredentialsManageDomains(jIRD.isCredentialsManageDomains());
        jenkinsItemRoleDataDTO.setCredentialsView(jIRD.isCredentialsView());

        jenkinsItemRoleDataDTO.setRunDelete(jIRD.isRunDelete());
        jenkinsItemRoleDataDTO.setRunReplay(jIRD.isRunReplay());
        jenkinsItemRoleDataDTO.setRunUpdate(jIRD.isRunUpdate());

        jenkinsItemRoleDataDTO.setJobBuild(jIRD.isJobBuild());
        jenkinsItemRoleDataDTO.setJobCancel(jIRD.isJobCancel());
        jenkinsItemRoleDataDTO.setJobConfigure(jIRD.isJobConfigure());
        jenkinsItemRoleDataDTO.setJobCreate(jIRD.isJobCreate());
        jenkinsItemRoleDataDTO.setJobDelete(jIRD.isJobDelete());
        jenkinsItemRoleDataDTO.setJobDiscover(jIRD.isJobDiscover());
        jenkinsItemRoleDataDTO.setJobMove(jIRD.isJobMove());
        jenkinsItemRoleDataDTO.setJobRead(jIRD.isJobRead());
        jenkinsItemRoleDataDTO.setJobWorkSpace(jIRD.isJobWorkSpace());

        jenkinsItemRoleDataDTO.setScmTag(jIRD.isScmTag());

        jenkinsItemRoleDataDTO.setLockResReserve(jIRD.isLockResReserve());
        jenkinsItemRoleDataDTO.setLockResUnlock(jIRD.isLockResUnlock());
        jenkinsItemRoleDataDTO.setLockResView(jIRD.isLockResView());
        return jenkinsItemRoleDataDTO;
    }
}
