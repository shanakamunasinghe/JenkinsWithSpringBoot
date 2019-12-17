package com.creative.web.model;

public class JenkinsPropertiesData {
    private LogRotator logRotator;
    private String projectUrl;
    private String displayName;

    public JenkinsPropertiesData() {
    }

    public JenkinsPropertiesData(LogRotator logRotator, String projectUrl, String displayName) {
        this.logRotator = logRotator;
        this.projectUrl = projectUrl;
        this.displayName = displayName;
    }

    public LogRotator getLogRotator() {
        return logRotator;
    }

    public void setLogRotator(LogRotator logRotator) {
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
}
