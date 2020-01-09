package com.creative.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class JenkinsJobData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String jobName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectData projectData;

    @OneToMany(mappedBy = "jenkinsJob")
    @JsonIgnore
    Set<JenkinsJobHistoryData> jenkinsJobHistoryData;


    private String description;
    private String status;

    public JenkinsJobData() {
    }

    public JenkinsJobData(String jobName, String status, String description) {
        this.jobName = jobName;
        this.status = status;
        this.description = description;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProjectData getProjectData() {
        return projectData;
    }

    public void setProjectData(ProjectData projectData) {
        this.projectData = projectData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<JenkinsJobHistoryData> getJenkinsJobHistoryData() {
        return jenkinsJobHistoryData;
    }

    public void setJenkinsJobHistoryData(Set<JenkinsJobHistoryData> jenkinsJobHistoryData) {
        this.jenkinsJobHistoryData = jenkinsJobHistoryData;
    }
}
