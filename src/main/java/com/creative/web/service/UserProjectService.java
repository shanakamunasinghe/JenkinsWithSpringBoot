package com.creative.web.service;

import com.creative.web.dto.UsersProjectsDataDTO;
import com.creative.web.model.UsersProjectsData;
import com.creative.web.repository.UserProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserProjectService {
    @Autowired
    private UserProjectRepository userProjectRepository;

    public List<UsersProjectsDataDTO> findALLUsersProjects(){
        List<UsersProjectsData> usersProjectsData = userProjectRepository.findAll();
        List<UsersProjectsDataDTO> usersProjectsDataDTOS = new ArrayList<>();
        if (usersProjectsData != null) {
            for(UsersProjectsData userProject : usersProjectsData){
                UsersProjectsDataDTO usersProjectsDataDTO = new UsersProjectsDataDTO();
                usersProjectsDataDTO.setId(userProject.getId());
                usersProjectsDataDTO.setProject(userProject.getProject());
                usersProjectsDataDTO.setUser(userProject.getUser());
                usersProjectsDataDTO.setAssignedUserId(userProject.getAssignedUserId());
            }
        }

        return usersProjectsDataDTOS;
    }
    public UsersProjectsDataDTO findById(Integer id){
        UsersProjectsData userProject = userProjectRepository.getOne(id);
        UsersProjectsDataDTO usersProjectsDataDTO = new UsersProjectsDataDTO();
        usersProjectsDataDTO.setId(userProject.getId());
        usersProjectsDataDTO.setProject(userProject.getProject());
        usersProjectsDataDTO.setUser(userProject.getUser());
        usersProjectsDataDTO.setAssignedUserId(userProject.getAssignedUserId());
        return usersProjectsDataDTO;
    }

    public void createUserProject(UsersProjectsDataDTO usersProjectsDataDTO){
        UsersProjectsData userProject = new UsersProjectsData();
        userProject.setId(usersProjectsDataDTO.getId());
        userProject.setProject(usersProjectsDataDTO.getProject());
        userProject.setUser(usersProjectsDataDTO.getUser());
        userProject.setAssignedUserId(usersProjectsDataDTO.getAssignedUserId());
        userProjectRepository.save(userProject);
    }

    public void deleteUserProject(UsersProjectsDataDTO usersProjectsDataDTO){
        UsersProjectsData userProject = new UsersProjectsData();
        userProject.setId(usersProjectsDataDTO.getId());
        userProject.setProject(usersProjectsDataDTO.getProject());
        userProject.setUser(usersProjectsDataDTO.getUser());
        userProject.setAssignedUserId(usersProjectsDataDTO.getAssignedUserId());
        userProjectRepository.delete(userProject);
    }
}
