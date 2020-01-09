package com.creative.web.dto;


public class JenkinsRolesDataDTO {
    private Integer id;
    private JenkinsGlobalRoleDataDTO jenkinsGlobalRoleDataDTO;
    private JenkinsItemRoleDataDTO jenkinsItemRoleDataDTO;
    private JenkinsUserDataDTO jenkinsUserDataDTO;
    private String type;
    private String status;

    public JenkinsRolesDataDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public JenkinsGlobalRoleDataDTO getJenkinsGlobalRoleDataDTO() {
        return jenkinsGlobalRoleDataDTO;
    }

    public void setJenkinsGlobalRoleDataDTO(JenkinsGlobalRoleDataDTO jenkinsGlobalRoleDataDTO) {
        this.jenkinsGlobalRoleDataDTO = jenkinsGlobalRoleDataDTO;
    }

    public JenkinsItemRoleDataDTO getJenkinsItemRoleDataDTO() {
        return jenkinsItemRoleDataDTO;
    }

    public void setJenkinsItemRoleDataDTO(JenkinsItemRoleDataDTO jenkinsItemRoleDataDTO) {
        this.jenkinsItemRoleDataDTO = jenkinsItemRoleDataDTO;
    }

    public JenkinsUserDataDTO getJenkinsUserDataDTO() {
        return jenkinsUserDataDTO;
    }

    public void setJenkinsUserDataDTO(JenkinsUserDataDTO jenkinsUserDataDTO) {
        this.jenkinsUserDataDTO = jenkinsUserDataDTO;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
