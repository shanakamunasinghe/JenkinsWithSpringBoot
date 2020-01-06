package com.creative.web.model;

public class JenkinsJobXMLPublisherData {
    private String type;
    private String status;

    public JenkinsJobXMLPublisherData(String type, String status) {
        this.type = type;
        this.status = status;
    }

    public JenkinsJobXMLPublisherData() {
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
}
