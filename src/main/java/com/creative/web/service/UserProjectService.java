package com.creative.web.service;

import com.creative.web.dto.EmployeeDataDTO;
import com.creative.web.dto.JenkinsUserDTO;
import com.creative.web.dto.UsersProjectsDataDTO;
import com.creative.web.model.EmployeeData;
import com.creative.web.model.EmployeeProjectsData;
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
        List<EmployeeProjectsData> employeeProjectsData = userProjectRepository.findAll();
        List<UsersProjectsDataDTO> usersProjectsDataDTOS = new ArrayList<>();
        if (employeeProjectsData != null) {
            for(EmployeeProjectsData userProject : employeeProjectsData){
                UsersProjectsDataDTO usersProjectsDataDTO = new UsersProjectsDataDTO();
                usersProjectsDataDTO.setId(userProject.getId());
                usersProjectsDataDTO.setProject(userProject.getProject());

                EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
                employeeDataDTO.setId(userProject.getUser().getId());
                employeeDataDTO.setStatus(userProject.getUser().getStatus());
                employeeDataDTO.setRole(userProject.getUser().getRole());
                employeeDataDTO.setName(userProject.getUser().getName());

                usersProjectsDataDTO.setUser(employeeDataDTO);
                usersProjectsDataDTO.setAssignedUserId(userProject.getAssignedUserId());
            }
        }

        return usersProjectsDataDTOS;
    }
    public UsersProjectsDataDTO findById(Integer id){
        EmployeeProjectsData userProject = userProjectRepository.getOne(id);
        UsersProjectsDataDTO usersProjectsDataDTO = new UsersProjectsDataDTO();
        usersProjectsDataDTO.setId(userProject.getId());
        usersProjectsDataDTO.setProject(userProject.getProject());
        EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
        employeeDataDTO.setId(userProject.getUser().getId());
        employeeDataDTO.setStatus(userProject.getUser().getStatus());
        employeeDataDTO.setRole(userProject.getUser().getRole());
        employeeDataDTO.setName(userProject.getUser().getName());

        usersProjectsDataDTO.setUser(employeeDataDTO);
        usersProjectsDataDTO.setAssignedUserId(userProject.getAssignedUserId());
        return usersProjectsDataDTO;
    }

    public void createUserProject(UsersProjectsDataDTO usersProjectsDataDTO){
        EmployeeProjectsData userProject = new EmployeeProjectsData();
        userProject.setId(usersProjectsDataDTO.getId());
        userProject.setProject(usersProjectsDataDTO.getProject());


        EmployeeData employeeData = new EmployeeData();
        employeeData.setId(usersProjectsDataDTO.getUser().getId());
        employeeData.setName(usersProjectsDataDTO.getUser().getName());
        employeeData.setRole(usersProjectsDataDTO.getUser().getRole());
        employeeData.setStatus(usersProjectsDataDTO.getUser().getStatus());
        userProject.setUser(employeeData);

        userProject.setAssignedUserId(usersProjectsDataDTO.getAssignedUserId());
        userProjectRepository.save(userProject);
    }

    public void deleteUserProject(UsersProjectsDataDTO usersProjectsDataDTO){
        EmployeeProjectsData userProject = new EmployeeProjectsData();
        userProject.setId(usersProjectsDataDTO.getId());
        userProject.setProject(usersProjectsDataDTO.getProject());

        EmployeeData employeeData = new EmployeeData();
        employeeData.setId(usersProjectsDataDTO.getUser().getId());
        employeeData.setName(usersProjectsDataDTO.getUser().getName());
        employeeData.setRole(usersProjectsDataDTO.getUser().getRole());
        employeeData.setStatus(usersProjectsDataDTO.getUser().getStatus());
        userProject.setUser(employeeData);

        userProject.setAssignedUserId(usersProjectsDataDTO.getAssignedUserId());
        userProjectRepository.delete(userProject);
    }
}
