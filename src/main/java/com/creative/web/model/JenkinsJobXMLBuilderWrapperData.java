package com.creative.web.model;

public class JenkinsJobXMLBuilderWrapperData {
    private String option;
    private String status;

    public JenkinsJobXMLBuilderWrapperData() {
    }

    public JenkinsJobXMLBuilderWrapperData(String option, String status) {
        this.option = option;
        this.status = status;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
