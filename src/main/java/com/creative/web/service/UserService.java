package com.creative.web.service;

import com.creative.web.dto.UserDataDTO;
import com.creative.web.model.UserData;
import com.creative.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDataDTO> findALLUsers(){
        List<UserData> userList = userRepository.findAll();
        List<UserDataDTO> userDTOList = new ArrayList<>();
        if (userList != null) {
            for (UserData user : userList) {
                UserDataDTO userDataDTO = new UserDataDTO();
                userDataDTO.setName(user.getName());
                userDataDTO.setRole(user.getRole());
                userDataDTO.setJenkinsName(user.getJenkinsName());
                userDataDTO.setJenkinsPassword(user.getJenkinsPassword());
                userDataDTO.setWorkingSpace(user.getWorkingSpace());
                userDTOList.add(userDataDTO);

            }
        }
        return userDTOList;
    }

    public UserDataDTO findById(Integer id){
        UserData user = userRepository.getOne(id);
        UserDataDTO userDataDTO = new UserDataDTO();
        userDataDTO.setName(user.getName());
        userDataDTO.setRole(user.getRole());
        userDataDTO.setJenkinsName(user.getJenkinsName());
        userDataDTO.setJenkinsPassword(user.getJenkinsPassword());
        userDataDTO.setWorkingSpace(user.getWorkingSpace());
        return userDataDTO;
    }

    public void createUser(UserDataDTO userDTO){
        UserData user = new UserData();
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        user.setJenkinsName(userDTO.getJenkinsName());
        user.setJenkinsPassword(userDTO.getJenkinsPassword());
        user.setWorkingSpace(userDTO.getWorkingSpace());
        userRepository.save(user);
    }

    public void deleteUser(UserDataDTO userDTO){
        UserData user = new UserData();
        user.setName(userDTO.getName());
        user.setRole(userDTO.getRole());
        user.setJenkinsName(userDTO.getJenkinsName());
        user.setJenkinsPassword(userDTO.getJenkinsPassword());
        user.setWorkingSpace(userDTO.getWorkingSpace());
        userRepository.delete(user);
    }
}
