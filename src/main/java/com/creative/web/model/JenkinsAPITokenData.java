package com.creative.web.model;

public class JenkinsAPITokenData {
    private String status;
    private Data data;

    public JenkinsAPITokenData() {
    }

    public JenkinsAPITokenData(String status, Data data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
