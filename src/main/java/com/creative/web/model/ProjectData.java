package com.creative.web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProjectData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String createUser;
    private boolean status;
    @OneToMany(mappedBy = "project")
    Set<UsersProjectsData> usersProjectsData;

    public ProjectData() {
    }

    public ProjectData(String name,String createUser,boolean status) {
        this.name = name;
        this.createUser = createUser;
        this.status = status;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<UsersProjectsData> getUsersProjectsData() {
        return usersProjectsData;
    }

    public void setUsersProjectsData(Set<UsersProjectsData> usersProjectsData) {
        this.usersProjectsData = usersProjectsData;
    }
}
