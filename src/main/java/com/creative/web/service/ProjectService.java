package com.creative.web.service;

import com.creative.web.dto.ProjectDataDTO;
import com.creative.web.model.JenkinsProjectData;
import com.creative.web.repository.JenkinsProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private JenkinsProjectRepository jenkinsProjectRepository;

    public List<ProjectDataDTO> findALLUProjects(){
        List<JenkinsProjectData> projectList = jenkinsProjectRepository.findAll();
        List<ProjectDataDTO> projectDTOList = new ArrayList<>();
        if (projectList != null) {
            for (JenkinsProjectData jenkinsProjectData : projectList) {
                ProjectDataDTO projectDTO = new ProjectDataDTO();
                projectDTO.setId(jenkinsProjectData.getId());
                projectDTO.setName(jenkinsProjectData.getName());
                projectDTO.setCreateUser(jenkinsProjectData.getCreateUser());
                projectDTO.setStatus(jenkinsProjectData.isStatus());
                projectDTOList.add(projectDTO);

            }
        }
        return projectDTOList;
    }

    public ProjectDataDTO findById(Integer id){
        JenkinsProjectData jenkinsProjectData =  jenkinsProjectRepository.getOne(id);
        ProjectDataDTO projectDTO = new ProjectDataDTO();
        projectDTO.setId(jenkinsProjectData.getId());
        projectDTO.setName(jenkinsProjectData.getName());
        projectDTO.setCreateUser(jenkinsProjectData.getCreateUser());
        projectDTO.setStatus(jenkinsProjectData.isStatus());
        return projectDTO;

    }

    public void createProject(ProjectDataDTO projectDTO){

        JenkinsProjectData project = new JenkinsProjectData();
        project.setName(projectDTO.getName());
        project.setCreateUser(projectDTO.getCreateUser());
        project.setStatus(projectDTO.isStatus());
        jenkinsProjectRepository.save(project);
    }

    public void deleteProject(ProjectDataDTO projectDTO){
        JenkinsProjectData project = new JenkinsProjectData();
        jenkinsProjectRepository.delete(project);
    }
}
