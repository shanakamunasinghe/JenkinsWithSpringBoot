package com.creative.web.dto;

import com.creative.web.model.ProjectData;

public class UsersProjectsDataDTO {

    private Integer id;
    private ProjectData project;
    private EmployeeDataDTO user;
    private Integer assignedUserId;

    public UsersProjectsDataDTO() {
    }

    public UsersProjectsDataDTO(Integer id, ProjectData project, EmployeeDataDTO user, Integer assignedUserId) {
        this.id = id;
        this.project = project;
        this.user = user;
        this.assignedUserId = assignedUserId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProjectData getProject() {
        return project;
    }

    public void setProject(ProjectData project) {
        this.project = project;
    }

    public EmployeeDataDTO getUser() {
        return user;
    }

    public void setUser(EmployeeDataDTO user) {
        this.user = user;
    }

    public Integer getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Integer assignedUserId) {
        this.assignedUserId = assignedUserId;
    }
}
