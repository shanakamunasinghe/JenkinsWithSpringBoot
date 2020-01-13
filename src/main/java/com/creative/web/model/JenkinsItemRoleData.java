package com.creative.web.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class JenkinsItemRoleData extends JenkinsRolesOptionData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String pattern;
    private String status;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ProjectData projectData;

    @JsonBackReference
    @OneToMany(mappedBy = "jenkinsItemRoleData")
    private Set<JenkinsRolesData> jenkinsRolesDataSet;

    public JenkinsItemRoleData() {
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

    public ProjectData getProjectData() {
        return projectData;
    }

    public void setProjectData(ProjectData projectData) {
        this.projectData = projectData;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Set<JenkinsRolesData> getJenkinsRolesDataSet() {
        return jenkinsRolesDataSet;
    }

    public void setJenkinsRolesDataSet(Set<JenkinsRolesData> jenkinsRolesDataSet) {
        this.jenkinsRolesDataSet = jenkinsRolesDataSet;
    }
}
