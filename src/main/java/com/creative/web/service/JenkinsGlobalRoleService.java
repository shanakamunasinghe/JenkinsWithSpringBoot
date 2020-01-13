package com.creative.web.service;

import com.creative.web.dto.JenkinsGlobalRoleDataDTO;
import com.creative.web.model.JenkinsGlobalRoleData;
import com.creative.web.repository.JenkinsGlobalRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JenkinsGlobalRoleService {

    @Autowired
    public JenkinsGlobalRoleRepository jenkinsGlobalRoleRepository;

    public List<JenkinsGlobalRoleDataDTO> getAllGlobalRoleData(){
        List<JenkinsGlobalRoleData> jenkinsGlobalRoleData = jenkinsGlobalRoleRepository.findAll();
        List<JenkinsGlobalRoleDataDTO> jenkinsGlobalRoleDataDTOS = new ArrayList<>();
        for(JenkinsGlobalRoleData jGRD : jenkinsGlobalRoleData){
            jenkinsGlobalRoleDataDTOS.add(mapJenkinsGlobalRoleDataToDTO(jGRD));
        }
        return jenkinsGlobalRoleDataDTOS;
    }

    public JenkinsGlobalRoleDataDTO getJenkinsGlobalRoleDataById(int id){
        JenkinsGlobalRoleData jenkinsGlobalRoleData = jenkinsGlobalRoleRepository.getOne(id);
        return mapJenkinsGlobalRoleDataToDTO(jenkinsGlobalRoleData);
    }

    public JenkinsGlobalRoleDataDTO mapJenkinsGlobalRoleDataToDTO(JenkinsGlobalRoleData jenkinsGlobalRoleData){
        JenkinsGlobalRoleDataDTO jenkinsGlobalRoleDataDTO = new JenkinsGlobalRoleDataDTO();

        jenkinsGlobalRoleDataDTO.setId(jenkinsGlobalRoleData.getId());
        jenkinsGlobalRoleDataDTO.setName(jenkinsGlobalRoleData.getName());
        jenkinsGlobalRoleDataDTO.setStatus(jenkinsGlobalRoleData.getStatus());

        jenkinsGlobalRoleDataDTO.setCredentialsCreate(jenkinsGlobalRoleData.isCredentialsCreate());
        jenkinsGlobalRoleDataDTO.setCredentialsDelete(jenkinsGlobalRoleData.isCredentialsDelete());
        jenkinsGlobalRoleDataDTO.setCredentialsManageDomains(jenkinsGlobalRoleData.isCredentialsManageDomains());
        jenkinsGlobalRoleDataDTO.setCredentialsUpdate(jenkinsGlobalRoleData.isCredentialsUpdate());
        jenkinsGlobalRoleDataDTO.setCredentialsView(jenkinsGlobalRoleData.isCredentialsView());

        jenkinsGlobalRoleDataDTO.setJobBuild(jenkinsGlobalRoleData.isJobBuild());
        jenkinsGlobalRoleDataDTO.setJobCancel(jenkinsGlobalRoleData.isJobCancel());
        jenkinsGlobalRoleDataDTO.setJobConfigure(jenkinsGlobalRoleData.isJobConfigure());
        jenkinsGlobalRoleDataDTO.setJobCreate(jenkinsGlobalRoleData.isJobCreate());
        jenkinsGlobalRoleDataDTO.setJobDelete(jenkinsGlobalRoleData.isJobDelete());
        jenkinsGlobalRoleDataDTO.setJobDiscover(jenkinsGlobalRoleData.isJobDiscover());
        jenkinsGlobalRoleDataDTO.setJobMove(jenkinsGlobalRoleData.isJobMove());
        jenkinsGlobalRoleDataDTO.setJobRead(jenkinsGlobalRoleData.isJobRead());
        jenkinsGlobalRoleDataDTO.setJobWorkSpace(jenkinsGlobalRoleData.isJobWorkSpace());

        jenkinsGlobalRoleDataDTO.setRunDelete(jenkinsGlobalRoleData.isRunDelete());
        jenkinsGlobalRoleDataDTO.setRunReplay(jenkinsGlobalRoleData.isRunReplay());
        jenkinsGlobalRoleDataDTO.setRunUpdate(jenkinsGlobalRoleData.isRunUpdate());

        jenkinsGlobalRoleDataDTO.setScmTag(jenkinsGlobalRoleData.isScmTag());

        jenkinsGlobalRoleDataDTO.setLockResReserve(jenkinsGlobalRoleData.isLockResReserve());
        jenkinsGlobalRoleDataDTO.setLockResUnlock(jenkinsGlobalRoleData.isLockResUnlock());
        jenkinsGlobalRoleDataDTO.setLockResView(jenkinsGlobalRoleData.isLockResView());

        jenkinsGlobalRoleDataDTO.setOverallAdminister(jenkinsGlobalRoleData.isOverallAdminister());
        jenkinsGlobalRoleDataDTO.setOverallRead(jenkinsGlobalRoleData.isOverallRead());

        jenkinsGlobalRoleDataDTO.setAgentBuild(jenkinsGlobalRoleData.isAgentBuild());
        jenkinsGlobalRoleDataDTO.setAgentConfigure(jenkinsGlobalRoleData.isAgentConfigure());
        jenkinsGlobalRoleDataDTO.setAgentConnect(jenkinsGlobalRoleData.isAgentConnect());
        jenkinsGlobalRoleDataDTO.setAgentCreate(jenkinsGlobalRoleData.isAgentCreate());
        jenkinsGlobalRoleDataDTO.setAgentDelete(jenkinsGlobalRoleData.isAgentDelete());
        jenkinsGlobalRoleDataDTO.setAgentDisconnect(jenkinsGlobalRoleData.isAgentDisconnect());
        jenkinsGlobalRoleDataDTO.setAgentProvision(jenkinsGlobalRoleData.isAgentProvision());

        jenkinsGlobalRoleDataDTO.setViewConfigure(jenkinsGlobalRoleData.isViewConfigure());
        jenkinsGlobalRoleDataDTO.setViewCreate(jenkinsGlobalRoleData.isViewCreate());
        jenkinsGlobalRoleDataDTO.setViewDelete(jenkinsGlobalRoleData.isViewDelete());
        jenkinsGlobalRoleDataDTO.setViewRead(jenkinsGlobalRoleData.isViewRead());

        return jenkinsGlobalRoleDataDTO;
    }
}
