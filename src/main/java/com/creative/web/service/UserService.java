package com.creative.web.service;

import com.creative.web.dto.UserDataDTO;
import com.creative.web.model.JenkinsUserData;
import com.creative.web.repository.JenkinsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private JenkinsUserRepository jenkinsUserRepository;

    @Autowired
    private JenkinsService jenkinsService;

    public List<UserDataDTO> findALLUsers(){
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

    public void createUser(UserDataDTO userDTO) throws IOException {
        JenkinsUserData user = new JenkinsUserData();
        user.setName(userDTO.getName());
        user.setJenkinsName(userDTO.getJenkinsName());
        user.setJenkinsPassword(userDTO.getJenkinsPassword());
        jenkinsService.createJenkinsUser(userDTO);
        String apiToken = jenkinsService.generateJenkinsUserAPIToken(userDTO.getName());
        if(apiToken != null){
            user.setJenkinsAPIToken(apiToken);
        }
        jenkinsUserRepository.save(user);

    }
    public void updateUser(UserDataDTO userDTO){
        JenkinsUserData user = new JenkinsUserData();
        user.setName(userDTO.getName());
        jenkinsUserRepository.save(user);
    }


    public void deleteUser(UserDataDTO userDTO){
        JenkinsUserData user = new JenkinsUserData();
        user.setName(userDTO.getName());
        user.setJenkinsName(userDTO.getJenkinsName());
        user.setJenkinsPassword(userDTO.getJenkinsPassword());
        jenkinsUserRepository.delete(user);
    }
}
