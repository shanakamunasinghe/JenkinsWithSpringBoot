package com.creative.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
public class JenkinsJobData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String jobName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JenkinsProjectData jenkinsProjectData;

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

    public JenkinsProjectData getJenkinsProjectData() {
        return jenkinsProjectData;
    }

    public void setJenkinsProjectData(JenkinsProjectData jenkinsProjectData) {
        this.jenkinsProjectData = jenkinsProjectData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
