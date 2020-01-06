package com.creative.web.dto;

import java.util.Date;

public class JenkinsJobHistoryDTO {
    private Integer id;
    private Integer jobId;
    private String jobName;
    private String phase;
    private String status;
    private Date created;

    public JenkinsJobHistoryDTO() {
    }

    public JenkinsJobHistoryDTO(Integer id, Integer jobId, String jobName, String phase, String status, Date created) {
        this.id = id;
        this.jobId = jobId;
        this.jobName = jobName;
        this.phase = phase;
        this.status = status;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
