package com.creative.web.model;

public class JenkinsJobXMLPropertiesData {
    private JenkinsLogRotator logRotator;
    // uses for github properties
    private String status;
    private String projectUrl;
    private String displayName;

    // notification make as auto config

    public JenkinsJobXMLPropertiesData() {
    }

    public JenkinsJobXMLPropertiesData(JenkinsLogRotator logRotator, String projectUrl, String displayName, String status) {
        this.logRotator = logRotator;
        this.projectUrl = projectUrl;
        this.displayName = displayName;
        this.status = status;
    }

    public JenkinsLogRotator getLogRotator() {
        return logRotator;
    }

    public void setLogRotator(JenkinsLogRotator logRotator) {
        this.logRotator = logRotator;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
