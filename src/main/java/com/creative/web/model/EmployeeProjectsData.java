package com.creative.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeProjectsData {
    @Id
    private Integer id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectData project;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private EmployeeData user;

    private Integer assignedUserId;

    public EmployeeProjectsData() {
    }

    public EmployeeProjectsData(Integer id, ProjectData project, EmployeeData user, Integer assignedUserId) {
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

    public EmployeeData getUser() {
        return user;
    }

    public void setUser(EmployeeData user) {
        this.user = user;
    }

    public Integer getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(Integer assingedUserId) {
        this.assignedUserId = assingedUserId;
    }
}
