package com.creative.web.service;

import com.creative.web.dto.VersionControllerDataDTO;
import com.creative.web.model.VersionControllerData;
import com.creative.web.repository.VersionControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VersionControllerService {

    @Autowired
    public VersionControllerRepository versionControllerRepository;

    public List<VersionControllerDataDTO> getAllVersionControllerData(){
        List<VersionControllerDataDTO> versionControllerDataDTOS = new ArrayList<>();
        List<VersionControllerData> versionControllerData = versionControllerRepository.findAll();

        for(VersionControllerData vCD : versionControllerData){
            VersionControllerDataDTO vCDDTO = new VersionControllerDataDTO();
            vCDDTO.setId(vCD.getId());
            vCDDTO.setName(vCDDTO.getName());
            vCDDTO.setValid(vCD.getValid());
            versionControllerDataDTOS.add(vCDDTO);
        }
        return versionControllerDataDTOS;
    }

    public VersionControllerDataDTO getById(int id){
        VersionControllerDataDTO versionControllerDataDTO = new VersionControllerDataDTO();
        VersionControllerData versionControllerData = versionControllerRepository.getOne(id);
        versionControllerDataDTO.setId(versionControllerData.getId());
        versionControllerDataDTO.setValid(versionControllerData.getValid());
        versionControllerDataDTO.setName(versionControllerData.getName());
        return versionControllerDataDTO;
    }

    public Integer createVersionController(VersionControllerDataDTO versionControllerDataDTO){
        VersionControllerData versionControllerData = new VersionControllerData();
        versionControllerData.setName(versionControllerDataDTO.getName());
        versionControllerData.setValid(versionControllerDataDTO.getValid());
        versionControllerRepository.save(versionControllerData);
        return 1;
    }

    public Integer updateVersionController(VersionControllerDataDTO versionControllerDataDTO){
        VersionControllerData versionControllerData = new VersionControllerData();
        versionControllerData.setId(versionControllerDataDTO.getId());
        versionControllerData.setName(versionControllerDataDTO.getName());
        versionControllerData.setValid(versionControllerDataDTO.getValid());
        versionControllerRepository.save(versionControllerData);
        return 1;
    }

    public Integer deleteVersionController(VersionControllerDataDTO versionControllerDataDTO){
        VersionControllerData versionControllerData = new VersionControllerData();
        versionControllerData.setId(versionControllerDataDTO.getId());
        versionControllerData.setName(versionControllerDataDTO.getName());
        versionControllerData.setValid(versionControllerDataDTO.getValid());
        versionControllerRepository.delete(versionControllerData);
        return 1;
    }
}
