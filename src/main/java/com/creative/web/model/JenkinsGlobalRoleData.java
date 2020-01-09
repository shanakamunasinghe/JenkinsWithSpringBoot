package com.creative.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class JenkinsGlobalRoleData extends JenkinsRolesOptionData{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    private String name;
    private String status;

    // overall
    private boolean overallAdminister;
    private boolean overallRead;

    // agent
    private boolean agentBuild = false;
    private boolean agentConfigure= false;
    private boolean agentConnect= false;
    private boolean agentCreate= false;
    private boolean agentDelete= false;
    private boolean agentDisconnect= false;
    private boolean agentProvision= false;

    // view
    private boolean viewConfigure;
    private boolean viewCreate;
    private boolean viewDelete;
    private boolean viewRead;

    @OneToMany(mappedBy = "jenkinsGlobalRoleData")
    @JsonIgnore
    private Set<JenkinsRolesData> jenkinsRolesDataSet;

    public JenkinsGlobalRoleData() {
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

    public boolean isOverallAdminister() {
        return overallAdminister;
    }

    public void setOverallAdminister(boolean overallAdminister) {
        this.overallAdminister = overallAdminister;
    }

    public boolean isOverallRead() {
        return overallRead;
    }

    public void setOverallRead(boolean overallRead) {
        this.overallRead = overallRead;
    }

    public boolean isAgentBuild() {
        return agentBuild;
    }

    public void setAgentBuild(boolean agentBuild) {
        this.agentBuild = agentBuild;
    }

    public boolean isAgentConfigure() {
        return agentConfigure;
    }

    public void setAgentConfigure(boolean agentConfigure) {
        this.agentConfigure = agentConfigure;
    }

    public boolean isAgentConnect() {
        return agentConnect;
    }

    public void setAgentConnect(boolean agentConnect) {
        this.agentConnect = agentConnect;
    }

    public boolean isAgentCreate() {
        return agentCreate;
    }

    public void setAgentCreate(boolean agentCreate) {
        this.agentCreate = agentCreate;
    }

    public boolean isAgentDelete() {
        return agentDelete;
    }

    public void setAgentDelete(boolean agentDelete) {
        this.agentDelete = agentDelete;
    }

    public boolean isAgentDisconnect() {
        return agentDisconnect;
    }

    public void setAgentDisconnect(boolean agentDisconnect) {
        this.agentDisconnect = agentDisconnect;
    }

    public boolean isAgentProvision() {
        return agentProvision;
    }

    public void setAgentProvision(boolean agentProvision) {
        this.agentProvision = agentProvision;
    }

    public boolean isViewConfigure() {
        return viewConfigure;
    }

    public void setViewConfigure(boolean viewConfigure) {
        this.viewConfigure = viewConfigure;
    }

    public boolean isViewCreate() {
        return viewCreate;
    }

    public void setViewCreate(boolean viewCreate) {
        this.viewCreate = viewCreate;
    }

    public boolean isViewDelete() {
        return viewDelete;
    }

    public void setViewDelete(boolean viewDelete) {
        this.viewDelete = viewDelete;
    }

    public boolean isViewRead() {
        return viewRead;
    }

    public void setViewRead(boolean viewRead) {
        this.viewRead = viewRead;
    }

    public Set<JenkinsRolesData> getJenkinsRolesDataSet() {
        return jenkinsRolesDataSet;
    }

    public void setJenkinsRolesDataSet(Set<JenkinsRolesData> jenkinsRolesDataSet) {
        this.jenkinsRolesDataSet = jenkinsRolesDataSet;
    }
}
