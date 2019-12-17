package com.creative.web.dto;

public class ProjectDataDTO {
    private Integer id;

    private String name;
    private String createUser;
    private boolean status;

    public ProjectDataDTO() {
    }

    public ProjectDataDTO(String name,String createUser,boolean status) {
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
}
