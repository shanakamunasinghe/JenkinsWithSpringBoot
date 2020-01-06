package com.creative.web.dto;

public class JenkinsJobHistoryDTO {
    private Integer id;
    private Integer jobId;
    private String jobName;
    private String phase;
    private String status;

    public JenkinsJobHistoryDTO() {
    }

    public JenkinsJobHistoryDTO(Integer id, Integer jobId, String jobName, String phase, String status) {
        this.id = id;
        this.jobId = jobId;
        this.jobName = jobName;
        this.phase = phase;
        this.status = status;
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
}
