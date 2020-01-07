package com.creative.web.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class ProjectData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Integer createUserId;
    private boolean status;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "automation_tool_data_id",
            unique = true,
            nullable = true)
    private AutomationToolData automationToolData;

    @OneToMany(mappedBy = "project")
    Set<JenkinsUsersProjectsData> jenkinsUsersProjectsData;

    public ProjectData() {
    }

    public ProjectData(String name, Integer createUserId, boolean status, AutomationToolData automationToolData) {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<JenkinsUsersProjectsData> getJenkinsUsersProjectsData() {
        return jenkinsUsersProjectsData;
    }

    public void setJenkinsUsersProjectsData(Set<JenkinsUsersProjectsData> jenkinsUsersProjectsData) {
        this.jenkinsUsersProjectsData = jenkinsUsersProjectsData;
    }

    public AutomationToolData getAutomationToolData() {
        return automationToolData;
    }

    public void setAutomationToolData(AutomationToolData automationToolData) {
        this.automationToolData = automationToolData;
    }
}
