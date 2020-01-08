package com.creative.web.service;

import com.creative.web.dto.JenkinsUserDataDTO;
import com.creative.web.dto.UserDataDTO;
import com.creative.web.model.JenkinsUserData;
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
    private JenkinsService jenkinsService;

    public List<UserDataDTO> findALLJenkinsUsers(){
        List<JenkinsUserData> userList = jenkinsUserRepository.findAll();
        List<UserDataDTO> userDTOList = new ArrayList<>();
        if (userList != null) {
            for (JenkinsUserData user : userList) {
                UserDataDTO userDataDTO = new UserDataDTO();
                userDataDTO.setId(user.getId());
                userDataDTO.setName(user.getName());
                userDataDTO.setJenkinsName(user.getJenkinsName());
                userDataDTO.setJenkinsPassword(user.getJenkinsPassword());
                userDTOList.add(userDataDTO);

            }
        }
        return userDTOList;
    }

    public UserDataDTO findById(Integer id){
        JenkinsUserData user = jenkinsUserRepository.getOne(id);
        UserDataDTO userDataDTO = new UserDataDTO();
        userDataDTO.setId(user.getId());
        userDataDTO.setName(user.getName());
        userDataDTO.setJenkinsName(user.getJenkinsName());
        userDataDTO.setJenkinsPassword(user.getJenkinsPassword());
        return userDataDTO;
    }

    public void createJenkinsUser(UserDataDTO userDTO) throws IOException {
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

    public void updatejenkinsUser(UserDataDTO userDTO){
        JenkinsUserData user = new JenkinsUserData();
        user.setName(userDTO.getName());
        jenkinsUserRepository.save(user);
    }


    public void deletejenkinsUser(UserDataDTO userDTO) throws IOException {
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
