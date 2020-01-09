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
            JenkinsGlobalRoleDataDTO jenkinsGlobalRoleDataDTO = new JenkinsGlobalRoleDataDTO();
            jenkinsGlobalRoleDataDTO.setId(jGRD.getId());
            jenkinsGlobalRoleDataDTO.setName(jGRD.getName());
            jenkinsGlobalRoleDataDTO.setStatus(jGRD.getStatus());

            jenkinsGlobalRoleDataDTO.setCredentialsCreate(jGRD.isCredentialsCreate());
            jenkinsGlobalRoleDataDTO.setCredentialsDelete(jGRD.isCredentialsDelete());
            jenkinsGlobalRoleDataDTO.setCredentialsManageDomains(jGRD.isCredentialsManageDomains());
            jenkinsGlobalRoleDataDTO.setCredentialsUpdate(jGRD.isCredentialsUpdate());
            jenkinsGlobalRoleDataDTO.setCredentialsView(jGRD.isCredentialsView());

            jenkinsGlobalRoleDataDTO.setJobBuild(jGRD.isJobBuild());
            jenkinsGlobalRoleDataDTO.setJobCancel(jGRD.isJobCancel());
            jenkinsGlobalRoleDataDTO.setJobConfigure(jGRD.isJobConfigure());
            jenkinsGlobalRoleDataDTO.setJobCreate(jGRD.isJobCreate());
            jenkinsGlobalRoleDataDTO.setJobDelete(jGRD.isJobDelete());
            jenkinsGlobalRoleDataDTO.setJobDiscover(jGRD.isJobDiscover());
            jenkinsGlobalRoleDataDTO.setJobMove(jGRD.isJobMove());
            jenkinsGlobalRoleDataDTO.setJobRead(jGRD.isJobRead());
            jenkinsGlobalRoleDataDTO.setJobWorkSpace(jGRD.isJobWorkSpace());

            jenkinsGlobalRoleDataDTO.setRunDelete(jGRD.isRunDelete());
            jenkinsGlobalRoleDataDTO.setRunReplay(jGRD.isRunReplay());
            jenkinsGlobalRoleDataDTO.setRunUpdate(jGRD.isRunUpdate());

            jenkinsGlobalRoleDataDTO.setScmTag(jGRD.isScmTag());

            jenkinsGlobalRoleDataDTO.setLockResReserve(jGRD.isLockResReserve());
            jenkinsGlobalRoleDataDTO.setLockResUnlock(jGRD.isLockResUnlock());
            jenkinsGlobalRoleDataDTO.setLockResView(jGRD.isLockResView());

            jenkinsGlobalRoleDataDTO.setOverallAdminister(jGRD.isOverallAdminister());
            jenkinsGlobalRoleDataDTO.setOverallRead(jGRD.isOverallRead());

            jenkinsGlobalRoleDataDTO.setAgentBuild(jGRD.isAgentBuild());
            jenkinsGlobalRoleDataDTO.setAgentConfigure(jGRD.isAgentConfigure());
            jenkinsGlobalRoleDataDTO.setAgentConnect(jGRD.isAgentConnect());
            jenkinsGlobalRoleDataDTO.setAgentCreate(jGRD.isAgentCreate());
            jenkinsGlobalRoleDataDTO.setAgentDelete(jGRD.isAgentDelete());
            jenkinsGlobalRoleDataDTO.setAgentDisconnect(jGRD.isAgentDisconnect());
            jenkinsGlobalRoleDataDTO.setAgentProvision(jGRD.isAgentProvision());

            jenkinsGlobalRoleDataDTO.setViewConfigure(jGRD.isViewConfigure());
            jenkinsGlobalRoleDataDTO.setViewCreate(jGRD.isViewCreate());
            jenkinsGlobalRoleDataDTO.setViewDelete(jGRD.isViewDelete());
            jenkinsGlobalRoleDataDTO.setViewRead(jGRD.isViewRead());

            jenkinsGlobalRoleDataDTOS.add(jenkinsGlobalRoleDataDTO);
        }
        return jenkinsGlobalRoleDataDTOS;
    }

    public JenkinsGlobalRoleDataDTO findById(int id){
        JenkinsGlobalRoleData jenkinsGlobalRoleData = jenkinsGlobalRoleRepository.getOne(id);

        JenkinsGlobalRoleDataDTO jenkinsGlobalRoleDataDTO = new JenkinsGlobalRoleDataDTO();

        jenkinsGlobalRoleDataDTO.setId(jenkinsGlobalRoleDataDTO.getId());
        jenkinsGlobalRoleDataDTO.setName(jenkinsGlobalRoleDataDTO.getName());
        jenkinsGlobalRoleDataDTO.setStatus(jenkinsGlobalRoleDataDTO.getStatus());

        jenkinsGlobalRoleDataDTO.setCredentialsCreate(jenkinsGlobalRoleDataDTO.isCredentialsCreate());
        jenkinsGlobalRoleDataDTO.setCredentialsDelete(jenkinsGlobalRoleDataDTO.isCredentialsDelete());
        jenkinsGlobalRoleDataDTO.setCredentialsManageDomains(jenkinsGlobalRoleDataDTO.isCredentialsManageDomains());
        jenkinsGlobalRoleDataDTO.setCredentialsUpdate(jenkinsGlobalRoleDataDTO.isCredentialsUpdate());
        jenkinsGlobalRoleDataDTO.setCredentialsView(jenkinsGlobalRoleDataDTO.isCredentialsView());

        jenkinsGlobalRoleDataDTO.setJobBuild(jenkinsGlobalRoleDataDTO.isJobBuild());
        jenkinsGlobalRoleDataDTO.setJobCancel(jenkinsGlobalRoleDataDTO.isJobCancel());
        jenkinsGlobalRoleDataDTO.setJobConfigure(jenkinsGlobalRoleDataDTO.isJobConfigure());
        jenkinsGlobalRoleDataDTO.setJobCreate(jenkinsGlobalRoleDataDTO.isJobCreate());
        jenkinsGlobalRoleDataDTO.setJobDelete(jenkinsGlobalRoleDataDTO.isJobDelete());
        jenkinsGlobalRoleDataDTO.setJobDiscover(jenkinsGlobalRoleDataDTO.isJobDiscover());
        jenkinsGlobalRoleDataDTO.setJobMove(jenkinsGlobalRoleDataDTO.isJobMove());
        jenkinsGlobalRoleDataDTO.setJobRead(jenkinsGlobalRoleDataDTO.isJobRead());
        jenkinsGlobalRoleDataDTO.setJobWorkSpace(jenkinsGlobalRoleDataDTO.isJobWorkSpace());

        jenkinsGlobalRoleDataDTO.setRunDelete(jenkinsGlobalRoleDataDTO.isRunDelete());
        jenkinsGlobalRoleDataDTO.setRunReplay(jenkinsGlobalRoleDataDTO.isRunReplay());
        jenkinsGlobalRoleDataDTO.setRunUpdate(jenkinsGlobalRoleDataDTO.isRunUpdate());

        jenkinsGlobalRoleDataDTO.setScmTag(jenkinsGlobalRoleDataDTO.isScmTag());

        jenkinsGlobalRoleDataDTO.setLockResReserve(jenkinsGlobalRoleDataDTO.isLockResReserve());
        jenkinsGlobalRoleDataDTO.setLockResUnlock(jenkinsGlobalRoleDataDTO.isLockResUnlock());
        jenkinsGlobalRoleDataDTO.setLockResView(jenkinsGlobalRoleDataDTO.isLockResView());

        jenkinsGlobalRoleDataDTO.setOverallAdminister(jenkinsGlobalRoleDataDTO.isOverallAdminister());
        jenkinsGlobalRoleDataDTO.setOverallRead(jenkinsGlobalRoleDataDTO.isOverallRead());

        jenkinsGlobalRoleDataDTO.setAgentBuild(jenkinsGlobalRoleDataDTO.isAgentBuild());
        jenkinsGlobalRoleDataDTO.setAgentConfigure(jenkinsGlobalRoleDataDTO.isAgentConfigure());
        jenkinsGlobalRoleDataDTO.setAgentConnect(jenkinsGlobalRoleDataDTO.isAgentConnect());
        jenkinsGlobalRoleDataDTO.setAgentCreate(jenkinsGlobalRoleDataDTO.isAgentCreate());
        jenkinsGlobalRoleDataDTO.setAgentDelete(jenkinsGlobalRoleDataDTO.isAgentDelete());
        jenkinsGlobalRoleDataDTO.setAgentDisconnect(jenkinsGlobalRoleDataDTO.isAgentDisconnect());
        jenkinsGlobalRoleDataDTO.setAgentProvision(jenkinsGlobalRoleDataDTO.isAgentProvision());

        jenkinsGlobalRoleDataDTO.setViewConfigure(jenkinsGlobalRoleDataDTO.isViewConfigure());
        jenkinsGlobalRoleDataDTO.setViewCreate(jenkinsGlobalRoleDataDTO.isViewCreate());
        jenkinsGlobalRoleDataDTO.setViewDelete(jenkinsGlobalRoleDataDTO.isViewDelete());
        jenkinsGlobalRoleDataDTO.setViewRead(jenkinsGlobalRoleDataDTO.isViewRead());

        return jenkinsGlobalRoleDataDTO;
    }
}
