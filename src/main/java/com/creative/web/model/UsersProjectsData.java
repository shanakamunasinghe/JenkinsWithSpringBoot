package com.creative.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UsersProjectsData {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectData project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserData user;

    private Integer assingedUserId;

    public UsersProjectsData() {
    }

    public UsersProjectsData(Integer id, ProjectData project, UserData user, Integer assingedUserId) {
        this.id = id;
        this.project = project;
        this.user = user;
        this.assingedUserId = assingedUserId;
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

    public UserData getUser() {
        return user;
    }

    public void setUser(UserData user) {
        this.user = user;
    }

    public Integer getAssingedUserId() {
        return assingedUserId;
    }

    public void setAssingedUserId(Integer assingedUserId) {
        this.assingedUserId = assingedUserId;
    }
}
