package com.creative.web.service;

import com.creative.web.dto.UsersProjectsDataDTO;
import com.creative.web.model.JenkinsUsersProjectsData;
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
        List<JenkinsUsersProjectsData> jenkinsUsersProjectsData = userProjectRepository.findAll();
        List<UsersProjectsDataDTO> usersProjectsDataDTOS = new ArrayList<>();
        if (jenkinsUsersProjectsData != null) {
            for(JenkinsUsersProjectsData userProject : jenkinsUsersProjectsData){
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
        JenkinsUsersProjectsData userProject = userProjectRepository.getOne(id);
        UsersProjectsDataDTO usersProjectsDataDTO = new UsersProjectsDataDTO();
        usersProjectsDataDTO.setId(userProject.getId());
        usersProjectsDataDTO.setProject(userProject.getProject());
        usersProjectsDataDTO.setUser(userProject.getUser());
        usersProjectsDataDTO.setAssignedUserId(userProject.getAssignedUserId());
        return usersProjectsDataDTO;
    }

    public void createUserProject(UsersProjectsDataDTO usersProjectsDataDTO){
        JenkinsUsersProjectsData userProject = new JenkinsUsersProjectsData();
        userProject.setId(usersProjectsDataDTO.getId());
        userProject.setProject(usersProjectsDataDTO.getProject());
        userProject.setUser(usersProjectsDataDTO.getUser());
        userProject.setAssignedUserId(usersProjectsDataDTO.getAssignedUserId());
        userProjectRepository.save(userProject);
    }

    public void deleteUserProject(UsersProjectsDataDTO usersProjectsDataDTO){
        JenkinsUsersProjectsData userProject = new JenkinsUsersProjectsData();
        userProject.setId(usersProjectsDataDTO.getId());
        userProject.setProject(usersProjectsDataDTO.getProject());
        userProject.setUser(usersProjectsDataDTO.getUser());
        userProject.setAssignedUserId(usersProjectsDataDTO.getAssignedUserId());
        userProjectRepository.delete(userProject);
    }
}
