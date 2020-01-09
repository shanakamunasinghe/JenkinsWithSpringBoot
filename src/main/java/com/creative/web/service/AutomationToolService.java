package com.creative.web.service;

import com.creative.web.dto.AutomationToolDataDTO;
import com.creative.web.model.AutomationToolData;
import com.creative.web.repository.AutomationToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutomationToolService {

    @Autowired
    public AutomationToolRepository automationToolRepository;
//    AutomationToolData

    public List<AutomationToolDataDTO> findAllAutomationTools(){
        List<AutomationToolDataDTO> automationToolDataDTOS = new ArrayList<>();
        List<AutomationToolData> automationToolData = automationToolRepository.findAll();

        for(AutomationToolData ATD : automationToolData){
            AutomationToolDataDTO automationToolDataDTO = new AutomationToolDataDTO();
            automationToolDataDTO.setId(ATD.getId());
            automationToolDataDTO.setName(ATD.getName());
            automationToolDataDTO.setDescription(ATD.getDescription());
            automationToolDataDTO.setStatus(ATD.getStatus());
            automationToolDataDTOS.add(automationToolDataDTO);
        }

        return automationToolDataDTOS;
    }

    public AutomationToolDataDTO finById(int id){
        AutomationToolDataDTO automationToolDataDTO = new AutomationToolDataDTO();
        AutomationToolData automationToolData = automationToolRepository.getOne(id);
        automationToolDataDTO.setId(automationToolData.getId());
        automationToolDataDTO.setName(automationToolData.getName());
        automationToolDataDTO.setDescription(automationToolData.getDescription());
        automationToolDataDTO.setStatus(automationToolData.getStatus());
        return automationToolDataDTO;
    }

    public Integer createAutomationToolData(AutomationToolDataDTO automationToolDataDTO){
        AutomationToolData automationToolData = new AutomationToolData();
        automationToolData.setName(automationToolDataDTO.getName());
        automationToolData.setDescription(automationToolDataDTO.getDescription());
        automationToolData.setStatus(automationToolDataDTO.getStatus());
        automationToolRepository.save(automationToolData);
        return 1;
    }

    public Integer updateAutomationToolData(AutomationToolDataDTO automationToolDataDTO){
        AutomationToolData automationToolData = new AutomationToolData();
        automationToolData.setId(automationToolDataDTO.getId());
        automationToolData.setName(automationToolDataDTO.getName());
        automationToolData.setDescription(automationToolDataDTO.getDescription());
        automationToolData.setStatus(automationToolDataDTO.getStatus());
        automationToolRepository.save(automationToolData);
        return 1;
    }

    public Integer deleteAutomationToolData(AutomationToolDataDTO automationToolDataDTO){
        AutomationToolData automationToolData = new AutomationToolData();
        automationToolData.setId(automationToolDataDTO.getId());
        automationToolData.setName(automationToolDataDTO.getName());
        automationToolData.setDescription(automationToolDataDTO.getDescription());
        automationToolData.setStatus(automationToolDataDTO.getStatus());
        automationToolRepository.delete(automationToolData);
        return 1;
    }
}
