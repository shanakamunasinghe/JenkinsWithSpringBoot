package com.creative.web.service;

import com.creative.web.dto.AutomationToolDataDTO;
import com.creative.web.dto.ProjectDataDTO;
import com.creative.web.model.AutomationToolData;
import com.creative.web.model.ProjectData;
import com.creative.web.repository.ProjectRepository;
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
        project.setStatus(projectDTO.getStatus());
        if(projectDTO.getAutomationToolDataDTO() != null){
            AutomationToolData automationToolData = new AutomationToolData();
            automationToolData.setId(projectDTO.getAutomationToolDataDTO().getId());
            automationToolData.setName(projectDTO.getAutomationToolDataDTO().getName());
            automationToolData.setDescription(projectDTO.getAutomationToolDataDTO().getDescription());
            automationToolData.setDescription(projectDTO.getAutomationToolDataDTO().getDescription());
            project.setAutomationToolData(automationToolData);
        }
        projectRepository.save(project);
    }

    public void updateProject(ProjectDataDTO projectDTO){
        ProjectData project = new ProjectData();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setCreateUserId(projectDTO.getCreateUserId());
        project.setStatus(projectDTO.getStatus());
        if(projectDTO.getAutomationToolDataDTO() != null){
            AutomationToolData automationToolData = new AutomationToolData();
            automationToolData.setId(projectDTO.getAutomationToolDataDTO().getId());
            automationToolData.setName(projectDTO.getAutomationToolDataDTO().getName());
            automationToolData.setDescription(projectDTO.getAutomationToolDataDTO().getDescription());
            automationToolData.setDescription(projectDTO.getAutomationToolDataDTO().getDescription());
            project.setAutomationToolData(automationToolData);
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
        projectDTO.setStatus(projectData.getStatus());
        if(projectData.getAutomationToolData() != null){
            AutomationToolDataDTO automationToolDataDTO = new AutomationToolDataDTO();
            automationToolDataDTO.setId(projectData.getAutomationToolData().getId());
            automationToolDataDTO.setStatus(projectData.getAutomationToolData().getStatus());
            automationToolDataDTO.setDescription(projectData.getAutomationToolData().getDescription());
            automationToolDataDTO.setName(projectData.getAutomationToolData().getName());
            projectDTO.setAutomationToolDataDTO(automationToolDataDTO);
        }
        return projectDTO;
    }

}
