package com.creative.web.service;

import com.creative.web.dto.JenkinsUserDataDTO;
import com.creative.web.dto.JenkinsUserDTO;
import com.creative.web.model.JenkinsUserData;
import com.creative.web.repository.EmployeeRepository;
import com.creative.web.repository.JenkinsUserRepository;
import com.creative.web.util.JenkinsAPIManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JenkinsUserService {
    @Autowired
    private JenkinsUserRepository jenkinsUserRepository;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    private JenkinsService jenkinsService;

    public List<JenkinsUserDTO> findALLJenkinsUsers(){
        List<JenkinsUserData> userList = jenkinsUserRepository.findAll();
        List<JenkinsUserDTO> userDTOList = new ArrayList<>();
        if (userList != null) {
            for (JenkinsUserData user : userList) {
                JenkinsUserDTO jenkinsUserDTO = new JenkinsUserDTO();
                jenkinsUserDTO.setId(user.getId());
                jenkinsUserDTO.setName(user.getName());
                jenkinsUserDTO.setJenkinsName(user.getJenkinsName());
                jenkinsUserDTO.setJenkinsPassword(user.getJenkinsPassword());
                jenkinsUserDTO.setJenkinsAPIToken(user.getJenkinsAPIToken());
                userDTOList.add(jenkinsUserDTO);

            }
        }
        return userDTOList;
    }

    public JenkinsUserDTO getJenkinsUserById(Integer id){
        JenkinsUserData user = jenkinsUserRepository.getOne(id);
        JenkinsUserDTO jenkinsUserDTO = new JenkinsUserDTO();
        jenkinsUserDTO.setId(user.getId());
        jenkinsUserDTO.setName(user.getName());
        jenkinsUserDTO.setJenkinsName(user.getJenkinsName());
        jenkinsUserDTO.setJenkinsPassword(user.getJenkinsPassword());
        jenkinsUserDTO.setJenkinsAPIToken(user.getJenkinsAPIToken());
        return jenkinsUserDTO;
    }

    public void createJenkinsUser(JenkinsUserDTO userDTO) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        JenkinsUserData jenkinsUserData = jenkinsUserRepository.findByJenkinsName(userDTO.getJenkinsName());
        if(jenkinsUserData != null){
            // cant create from the same name
        }else{
            JenkinsUserDataDTO jenkinsUserDataDTO = new JenkinsUserDataDTO(userDTO.getName(), userDTO.getJenkinsPassword(), userDTO.getName() + "@gmail.com");
            jenkinsAPIManager.createJenkinsUser(jenkinsUserDataDTO);
            JenkinsUserData jUD = new JenkinsUserData();
            jUD.setName(userDTO.getName());
            jUD.setJenkinsName(userDTO.getJenkinsName());
            jUD.setJenkinsPassword(userDTO.getJenkinsPassword());
            jUD.setStatus("Active");
            String apiToken = jenkinsService.generateJenkinsUserAPIToken(userDTO.getJenkinsName());
            if(apiToken != null){
                jUD.setJenkinsAPIToken(apiToken);
            }
            jUD.setEmployeeData(employeeRepository.findByName(userDTO.getName()));
            jenkinsUserRepository.save(jUD);
        }

    }

    public int inactiveJenkinsUser(String userName) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        JenkinsUserData jenkinsUserData = jenkinsUserRepository.findByJenkinsName(userName);
        if(jenkinsUserData != null){
            jenkinsAPIManager.deleteJenkinsUser(userName);
            jenkinsUserData.setStatus("Inactive");
        }
        return 1;
    }

    public void updateJenkinsUser(JenkinsUserDTO userDTO){
        JenkinsUserData user = new JenkinsUserData();
        user.setName(userDTO.getName());
        jenkinsUserRepository.save(user);
    }


    public void deleteJenkinsUser(JenkinsUserDTO userDTO) throws IOException {
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        JenkinsUserData user = new JenkinsUserData();
        user.setName(userDTO.getName());
        user.setJenkinsName(userDTO.getJenkinsName());
        user.setJenkinsPassword(userDTO.getJenkinsPassword());
        JenkinsUserData jenkinsUserData = jenkinsUserRepository.findByJenkinsName(userDTO.getName());
        if(jenkinsUserData != null){
            jenkinsAPIManager.deleteJenkinsUser(userDTO.getName());
        }
        jenkinsUserRepository.delete(user);
    }
}
