package com.creative.web.service;

import com.creative.web.dto.UserDataDTO;
import com.creative.web.model.UserData;
import com.creative.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JenkinsService jenkinsService;

    public List<UserDataDTO> findALLUsers(){
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

    public void createUser(UserDataDTO userDTO) throws IOException {
        UserData user = new UserData();
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        user.setJenkinsName(userDTO.getJenkinsName());
        user.setJenkinsPassword(userDTO.getJenkinsPassword());
        jenkinsService.createJenkinsUser(userDTO);
        String apiToken = jenkinsService.generateJenkinsUserAPIToken(userDTO.getName());
        if(apiToken != null){
            user.setJenkinsAPIToken(apiToken);
        }
        userRepository.save(user);

    }
    public void updateUser(UserDataDTO userDTO){
        UserData user = new UserData();
        user.setName(userDTO.getName());
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
