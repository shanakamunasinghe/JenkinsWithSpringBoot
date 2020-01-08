package com.creative.web.dto;

public class EmployeeDataDTO {
    private Integer id;
    private String name;
    private String status;
    private String role;

    public EmployeeDataDTO() {
    }

    public EmployeeDataDTO(Integer id, String name, String status, String role) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.role = role;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
