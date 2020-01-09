package com.creative.web.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table
public class JenkinsRolesData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "jenkins_global_role_id",
            nullable = true)
    private JenkinsGlobalRoleData jenkinsGlobalRoleData;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "jenkins_item_role_id",
            nullable = true)
    private JenkinsItemRoleData jenkinsItemRoleData;

    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "jenkins_user_id",
            nullable = true)
    private JenkinsUserData jenkinsUserData;
    private String type;
    private String status;

    public JenkinsRolesData() {
    }

    public JenkinsRolesData(Integer id, String type, String status) {
        this.id = id;

        this.type = type;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public JenkinsGlobalRoleData getJenkinsGlobalRoleData() {
        return jenkinsGlobalRoleData;
    }

    public void setJenkinsGlobalRoleData(JenkinsGlobalRoleData jenkinsGlobalRoleData) {
        this.jenkinsGlobalRoleData = jenkinsGlobalRoleData;
    }

    public JenkinsItemRoleData getJenkinsItemRoleData() {
        return jenkinsItemRoleData;
    }

    public void setJenkinsItemRoleData(JenkinsItemRoleData jenkinsItemRoleData) {
        this.jenkinsItemRoleData = jenkinsItemRoleData;
    }

    public JenkinsUserData getJenkinsUserData() {
        return jenkinsUserData;
    }

    public void setJenkinsUserData(JenkinsUserData jenkinsUserData) {
        this.jenkinsUserData = jenkinsUserData;
    }
}
