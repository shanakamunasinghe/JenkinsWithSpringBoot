package com.creative.web.dto;

public class JenkinsRoleDetailsDTO {
    private String userName;
    private String roleName;
    private String type;

    public JenkinsRoleDetailsDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
