package com.creative.web.model;

public class JenkinsSCMData {
    private String userRemoteConfigUrl;
    private String name;
    private String[] branches;
    private boolean doGenerateSubmoduleConfigurations;

    public JenkinsSCMData() {
    }

    public JenkinsSCMData(String userRemoteConfigUrl, String name, String[] branches, boolean doGenerateSubmoduleConfigurations) {
        this.userRemoteConfigUrl = userRemoteConfigUrl;
        this.name = name;
        this.branches = branches;
        this.doGenerateSubmoduleConfigurations = doGenerateSubmoduleConfigurations;
    }

    public String getUserRemoteConfigUrl() {
        return userRemoteConfigUrl;
    }

    public void setUserRemoteConfigUrl(String userRemoteConfigUrl) {
        this.userRemoteConfigUrl = userRemoteConfigUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getBranches() {
        return branches;
    }

    public void setBranches(String[] branches) {
        this.branches = branches;
    }

    public boolean isDoGenerateSubmoduleConfigurations() {
        return doGenerateSubmoduleConfigurations;
    }

    public void setDoGenerateSubmoduleConfigurations(boolean doGenerateSubmoduleConfigurations) {
        this.doGenerateSubmoduleConfigurations = doGenerateSubmoduleConfigurations;
    }
}
