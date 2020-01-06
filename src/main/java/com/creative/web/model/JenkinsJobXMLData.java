package com.creative.web.model;

public class JenkinsJobXMLData {
    private JenkinsJobXMLBuilderData jenkinsJobXMLBuilderData;
    private JenkinsJobXMLPropertiesData jenkinsJobXMLPropertiesData;
    private JenkinsJobXMLPublisherData jenkinsJobXMLPublisherData;
    private JenkinsJobXMLSCMData jenkinsJobXMLSCMData;
    private JenkinsJobXMLTiggersData jenkinsJobXMLTiggersData;
    private JenkinsJobXMLBuilderWrapperData jenkinsJobXMLBuilderWrapperData;

    public JenkinsJobXMLData() {
    }

    public JenkinsJobXMLData(JenkinsJobXMLBuilderWrapperData jenkinsJobXMLBuilderWrapperData,JenkinsJobXMLTiggersData jenkinsJobXMLTiggersData, JenkinsJobXMLBuilderData jenkinsJobXMLBuilderData, JenkinsJobXMLPropertiesData jenkinsJobXMLPropertiesData, JenkinsJobXMLPublisherData jenkinsJobXMLPublisherData, JenkinsJobXMLSCMData jenkinsJobXMLSCMData) {
        this.jenkinsJobXMLBuilderData = jenkinsJobXMLBuilderData;
        this.jenkinsJobXMLPropertiesData = jenkinsJobXMLPropertiesData;
        this.jenkinsJobXMLPublisherData = jenkinsJobXMLPublisherData;
        this.jenkinsJobXMLSCMData = jenkinsJobXMLSCMData;
        this.jenkinsJobXMLTiggersData = jenkinsJobXMLTiggersData;
        this.jenkinsJobXMLBuilderWrapperData = jenkinsJobXMLBuilderWrapperData;
    }

    public JenkinsJobXMLBuilderWrapperData getJenkinsJobXMLBuilderWrapperData() {
        return jenkinsJobXMLBuilderWrapperData;
    }

    public void setJenkinsJobXMLBuilderWrapperData(JenkinsJobXMLBuilderWrapperData jenkinsJobXMLBuilderWrapperData) {
        this.jenkinsJobXMLBuilderWrapperData = jenkinsJobXMLBuilderWrapperData;
    }

    public JenkinsJobXMLTiggersData getJenkinsJobXMLTiggersData() {
        return jenkinsJobXMLTiggersData;
    }

    public void setJenkinsJobXMLTiggersData(JenkinsJobXMLTiggersData jenkinsJobXMLTiggersData) {
        this.jenkinsJobXMLTiggersData = jenkinsJobXMLTiggersData;
    }

    public JenkinsJobXMLBuilderData getJenkinsJobXMLBuilderData() {
        return jenkinsJobXMLBuilderData;
    }

    public void setJenkinsJobXMLBuilderData(JenkinsJobXMLBuilderData jenkinsJobXMLBuilderData) {
        this.jenkinsJobXMLBuilderData = jenkinsJobXMLBuilderData;
    }

    public JenkinsJobXMLPropertiesData getJenkinsJobXMLPropertiesData() {
        return jenkinsJobXMLPropertiesData;
    }

    public void setJenkinsJobXMLPropertiesData(JenkinsJobXMLPropertiesData jenkinsJobXMLPropertiesData) {
        this.jenkinsJobXMLPropertiesData = jenkinsJobXMLPropertiesData;
    }

    public JenkinsJobXMLPublisherData getJenkinsJobXMLPublisherData() {
        return jenkinsJobXMLPublisherData;
    }

    public void setJenkinsJobXMLPublisherData(JenkinsJobXMLPublisherData jenkinsJobXMLPublisherData) {
        this.jenkinsJobXMLPublisherData = jenkinsJobXMLPublisherData;
    }

    public JenkinsJobXMLSCMData getJenkinsJobXMLSCMData() {
        return jenkinsJobXMLSCMData;
    }

    public void setJenkinsJobXMLSCMData(JenkinsJobXMLSCMData jenkinsJobXMLSCMData) {
        this.jenkinsJobXMLSCMData = jenkinsJobXMLSCMData;
    }
}
