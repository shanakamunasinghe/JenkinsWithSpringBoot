package com.creative.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table
public class ProjectData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer createUserId;
    private String status;


    // item role
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "automation_tool_data_id",
            nullable = true)
    private AutomationToolData automationToolData;

    @JsonManagedReference
    @OneToMany(mappedBy = "project")
    private  Set<EmployeeProjectsData> employeeProjectsData;

    @JsonManagedReference
    @OneToMany(mappedBy = "projectData")
    private Collection<JenkinsItemRoleData> jenkinsItemRoles;

    public ProjectData() {
    }

    public ProjectData(String name, Integer createUserId, String status, AutomationToolData automationToolData) {
        this.name = name;
        this.createUserId = createUserId;
        this.status = status;
        this.automationToolData = automationToolData;
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

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUser) {
        this.createUserId = createUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<EmployeeProjectsData> getEmployeeProjectsData() {
        return employeeProjectsData;
    }

    public void setEmployeeProjectsData(Set<EmployeeProjectsData> employeeProjectsData) {
        this.employeeProjectsData = employeeProjectsData;
    }

    public Collection<JenkinsItemRoleData> getJenkinsItemRoles() {
        return jenkinsItemRoles;
    }

    public void setJenkinsItemRoles(Collection<JenkinsItemRoleData> jenkinsItemRoles) {
        this.jenkinsItemRoles = jenkinsItemRoles;
    }

    public AutomationToolData getAutomationToolData() {
        return automationToolData;
    }

    public void setAutomationToolData(AutomationToolData automationToolData) {
        this.automationToolData = automationToolData;
    }

}
