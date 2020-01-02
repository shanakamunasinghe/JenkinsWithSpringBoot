package com.creative.web.dto;

import com.creative.web.model.JenkinsProjectData;
import com.creative.web.model.JenkinsUserData;


public class UsersProjectsDataDTO {

    private Integer id;
    private JenkinsProjectData project;
    private JenkinsUserData user;
    private Integer assignedUserId;

    public UsersProjectsDataDTO() {
    }

    public UsersProjectsDataDTO(Integer id, JenkinsProjectData project, JenkinsUserData user, Integer assignedUserId) {
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

    public JenkinsProjectData getProject() {
        return project;
    }

    public void setProject(JenkinsProjectData project) {
        this.project = project;
    }

    public JenkinsUserData getUser() {
        return user;
    }

    public void setUser(JenkinsUserData user) {
        this.user = user;
    }

    public Integer getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Integer assignedUserId) {
        this.assignedUserId = assignedUserId;
    }
}
