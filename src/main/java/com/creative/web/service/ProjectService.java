package com.creative.web.service;

import com.creative.web.dto.ProjectDataDTO;
import com.creative.web.model.ProjectData;
import com.creative.web.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<ProjectDataDTO> findALLUProjects(){
        List<ProjectData> projectList = projectRepository.findAll();
        List<ProjectDataDTO> projectDTOList = new ArrayList<>();
        if (projectList != null) {
            for (ProjectData projectData : projectList) {
                ProjectDataDTO projectDTO = new ProjectDataDTO();
                projectDTO.setId(projectData.getId());
                projectDTO.setName(projectData.getName());
                projectDTO.setCreateUser(projectData.getCreateUser());
                projectDTO.setStatus(projectData.isStatus());
                projectDTOList.add(projectDTO);

            }
        }
        return projectDTOList;
    }

    public ProjectDataDTO findById(Integer id){
        ProjectData projectData =  projectRepository.getOne(id);
        ProjectDataDTO projectDTO = new ProjectDataDTO();
        projectDTO.setId(projectData.getId());
        projectDTO.setName(projectData.getName());
        projectDTO.setCreateUser(projectData.getCreateUser());
        projectDTO.setStatus(projectData.isStatus());
        return projectDTO;

    }

    public void createProject(ProjectDataDTO projectDTO){

        ProjectData project = new ProjectData();
        project.setName(projectDTO.getName());
        project.setCreateUser(projectDTO.getCreateUser());
        project.setStatus(projectDTO.isStatus());
        projectRepository.save(project);
    }

    public void deleteProject(ProjectDataDTO projectDTO){
        ProjectData project = new ProjectData();
        projectRepository.delete(project);
    }
}
