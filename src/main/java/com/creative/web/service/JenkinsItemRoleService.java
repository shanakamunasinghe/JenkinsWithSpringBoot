package com.creative.web.service;

import com.creative.web.dto.JenkinsItemRoleDataDTO;
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
            JenkinsItemRoleDataDTO jenkinsItemRoleDataDTO = new JenkinsItemRoleDataDTO();
            jenkinsItemRoleDataDTO.setId(jIRD.getId());
        }

        return jenkinsItemRoleDataDTOS;
    }
}
