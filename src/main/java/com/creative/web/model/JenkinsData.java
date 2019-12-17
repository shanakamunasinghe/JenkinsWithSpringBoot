package com.creative.web.model;

public class JenkinsData {
    private JenkinsBuilderData jenkinsBuilderData;
    private JenkinsPropertiesData jenkinsPropertiesData;
    private JenkinsPublisherData jenkinsPublisherData;
    private JenkinsSCMData jenkinsSCMData;

    public JenkinsData() {
    }

    public JenkinsData(JenkinsBuilderData jenkinsBuilderData, JenkinsPropertiesData jenkinsPropertiesData, JenkinsPublisherData jenkinsPublisherData, JenkinsSCMData jenkinsSCMData) {
        this.jenkinsBuilderData = jenkinsBuilderData;
        this.jenkinsPropertiesData = jenkinsPropertiesData;
        this.jenkinsPublisherData = jenkinsPublisherData;
        this.jenkinsSCMData = jenkinsSCMData;
    }

    public JenkinsBuilderData getJenkinsBuilderData() {
        return jenkinsBuilderData;
    }

    public void setJenkinsBuilderData(JenkinsBuilderData jenkinsBuilderData) {
        this.jenkinsBuilderData = jenkinsBuilderData;
    }

    public JenkinsPropertiesData getJenkinsPropertiesData() {
        return jenkinsPropertiesData;
    }

    public void setJenkinsPropertiesData(JenkinsPropertiesData jenkinsPropertiesData) {
        this.jenkinsPropertiesData = jenkinsPropertiesData;
    }

    public JenkinsPublisherData getJenkinsPublisherData() {
        return jenkinsPublisherData;
    }

    public void setJenkinsPublisherData(JenkinsPublisherData jenkinsPublisherData) {
        this.jenkinsPublisherData = jenkinsPublisherData;
    }

    public JenkinsSCMData getJenkinsSCMData() {
        return jenkinsSCMData;
    }

    public void setJenkinsSCMData(JenkinsSCMData jenkinsSCMData) {
        this.jenkinsSCMData = jenkinsSCMData;
    }
}
