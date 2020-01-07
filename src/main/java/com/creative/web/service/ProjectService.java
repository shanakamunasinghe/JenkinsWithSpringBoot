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

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<ProjectDataDTO> findALLUProjects(){
        List<ProjectData> projectList = projectRepository.findAll();
        List<ProjectDataDTO> projectDTOList = new ArrayList<>();
        if (projectList != null) {
            for (ProjectData projectData : projectList) {
                projectDTOList.add(mapProjectDataToDTO(projectData));

            }
        }
        return projectDTOList;
    }

    public ProjectDataDTO findById(Integer id){
        return mapProjectDataToDTO(projectRepository.getOne(id));
    }

    public void createProject(ProjectDataDTO projectDTO){

        ProjectData project = new ProjectData();
        project.setName(projectDTO.getName());
        project.setCreateUserId(projectDTO.getCreateUserId());
        project.setStatus(projectDTO.isStatus());
        if(projectDTO.getAutomationToolData() != null){
            project.setAutomationToolData(projectDTO.getAutomationToolData());
        }
        projectRepository.save(project);
    }

    public void deleteProject(ProjectDataDTO projectDTO){
        ProjectData project = new ProjectData();
        projectRepository.delete(project);
    }

    public ProjectDataDTO mapProjectDataToDTO(ProjectData projectData){
        ProjectDataDTO projectDTO = new ProjectDataDTO();
        projectDTO.setId(projectData.getId());
        projectDTO.setName(projectData.getName());
        projectDTO.setCreateUserId(projectData.getCreateUserId());
        projectDTO.setStatus(projectData.isStatus());
        if(projectData.getAutomationToolData() != null){
            projectDTO.setAutomationToolData(projectData.getAutomationToolData());
        }
        return projectDTO;
    }

}
