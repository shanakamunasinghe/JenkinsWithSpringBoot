package com.creative.web.service;

import com.creative.web.dto.UserDataDTO;
import com.creative.web.model.UserData;
import com.creative.web.repository.UserRepository;
//import com.creative.web.util.JenkinsAPIManager;
import com.creative.web.util.JenkinsAPIManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDataDTO> findALLUsers() throws IOException {
        List<UserData> userList = userRepository.findAll();
        List<UserDataDTO> userDTOList = new ArrayList<>();
        if (userList != null) {
            for (UserData user : userList) {
                UserDataDTO userDataDTO = new UserDataDTO();
                userDataDTO.setId(user.getId());
                userDataDTO.setName(user.getName());
                userDataDTO.setRole(user.getRole());
                userDataDTO.setJenkinsName(user.getJenkinsName());
                userDataDTO.setJenkinsPassword(user.getJenkinsPassword());
                userDTOList.add(userDataDTO);

            }
        }
        JenkinsAPIManager jenkinsAPIManager = new JenkinsAPIManager();
        jenkinsAPIManager.getJenkinsStatusData();
        jenkinsAPIManager.runJenkinsJob("HelloWorld");
        return userDTOList;
    }

    public UserDataDTO findById(Integer id){
        UserData user = userRepository.getOne(id);
        UserDataDTO userDataDTO = new UserDataDTO();
        userDataDTO.setId(user.getId());
        userDataDTO.setName(user.getName());
        userDataDTO.setRole(user.getRole());
        userDataDTO.setJenkinsName(user.getJenkinsName());
        userDataDTO.setJenkinsPassword(user.getJenkinsPassword());
        return userDataDTO;
    }

    public void createUser(UserDataDTO userDTO){
        UserData user = new UserData();
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        user.setJenkinsName(userDTO.getJenkinsName());
        user.setJenkinsPassword(userDTO.getJenkinsPassword());
        userRepository.save(user);
    }

    public void deleteUser(UserDataDTO userDTO){
        UserData user = new UserData();
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        user.setJenkinsName(userDTO.getJenkinsName());
        user.setJenkinsPassword(userDTO.getJenkinsPassword());
        userRepository.delete(user);
    }
}
