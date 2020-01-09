package com.creative.web.model;

public class JenkinsAPITokenData {
    private String status;
    private JenkinsStatusData data;

    public JenkinsAPITokenData() {
    }

    public JenkinsAPITokenData(String status, JenkinsStatusData data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JenkinsStatusData getData() {
        return data;
    }

    public void setData(JenkinsStatusData data) {
        this.data = data;
    }
}
