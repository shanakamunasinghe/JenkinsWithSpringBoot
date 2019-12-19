package com.creative.web.dto;

public class UserDataDTO {
    private Integer id;

    private String name;
    private String role;
    private String jenkinsName;
    private String jenkinsPassword;


    public UserDataDTO() {
    }
    public UserDataDTO(String name, String role, String jenkinsName, String jenkinsPassword ){
        this.name = name;
        this.role = role;
        this.jenkinsName = jenkinsName;
        this.jenkinsPassword = jenkinsPassword;

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJenkinsName() {
        return jenkinsName;
    }

    public void setJenkinsName(String jenkinsName) {
        this.jenkinsName = jenkinsName;
    }

    public String getJenkinsPassword() {
        return jenkinsPassword;
    }

    public void setJenkinsPassword(String jenkinsPassword) {
        this.jenkinsPassword = jenkinsPassword;
    }

}
