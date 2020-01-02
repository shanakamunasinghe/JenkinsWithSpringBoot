package com.creative.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JenkinsUsersProjectsData {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private JenkinsProjectData project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private JenkinsUserData user;

    private Integer assignedUserId;

    public JenkinsUsersProjectsData() {
    }

    public JenkinsUsersProjectsData(Integer id, JenkinsProjectData project, JenkinsUserData user, Integer assignedUserId) {
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

    public void setAssignedUserId(Integer assingedUserId) {
        this.assignedUserId = assingedUserId;
    }
}
