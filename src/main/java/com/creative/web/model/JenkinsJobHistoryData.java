package com.creative.web.model;

import javax.persistence.*;

@Entity
@Table
public class JenkinsJobHistoryData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id")
    private JenkinsJobData jenkinsJob;
    private String phase;
    private String status;

    public JenkinsJobHistoryData() {

    }
    public JenkinsJobHistoryData(Integer id, JenkinsJobData jenkinsJob, String phase, String status) {
        this.id = id;
        this.jenkinsJob = jenkinsJob;
        this.phase = phase;
        this.status = status;
    }

    public JenkinsJobData getJenkinsJob() {
        return jenkinsJob;
    }

    public void setJenkinsJob(JenkinsJobData jenkinsJob) {
        this.jenkinsJob = jenkinsJob;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
