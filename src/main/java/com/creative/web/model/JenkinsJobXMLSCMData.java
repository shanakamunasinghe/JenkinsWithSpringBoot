package com.creative.web.model;

public class JenkinsJobXMLSCMData {
    private String userRemoteConfigUrl;
    private String status;
    private String branches;
    private String doGenerateSubmoduleConfigurations;

    public JenkinsJobXMLSCMData() {
    }

    public JenkinsJobXMLSCMData(String userRemoteConfigUrl, String status, String branches, String doGenerateSubmoduleConfigurations) {
        this.userRemoteConfigUrl = userRemoteConfigUrl;
        this.status = status;
        this.branches = branches;
        this.doGenerateSubmoduleConfigurations = doGenerateSubmoduleConfigurations;
    }

    public String getUserRemoteConfigUrl() {
        return userRemoteConfigUrl;
    }

    public void setUserRemoteConfigUrl(String userRemoteConfigUrl) {
        this.userRemoteConfigUrl = userRemoteConfigUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getDoGenerateSubmoduleConfigurations() {
        return doGenerateSubmoduleConfigurations;
    }

    public void setDoGenerateSubmoduleConfigurations(String doGenerateSubmoduleConfigurations) {
        this.doGenerateSubmoduleConfigurations = doGenerateSubmoduleConfigurations;
    }
}
