package com.creative.web.dto;

import com.creative.web.model.JenkinsRolesOptionData;

public class JenkinsItemRoleDataDTO extends JenkinsRolesOptionData {

    private Integer id;
    private String name;
    private String pattern;
    private String status;
    private ProjectDataDTO projectDataDTO;

    public JenkinsItemRoleDataDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProjectDataDTO getProjectDataDTO() {
        return projectDataDTO;
    }

    public void setProjectDataDTO(ProjectDataDTO projectDataDTO) {
        this.projectDataDTO = projectDataDTO;
    }
}
