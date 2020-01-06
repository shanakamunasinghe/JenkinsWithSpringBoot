package com.creative.web.model;

public class JenkinsJobXMLTiggersData {
    private String scmTriggerSpec;
    private String status;

    public JenkinsJobXMLTiggersData(String scmTriggerSpec, String status) {
        this.scmTriggerSpec = scmTriggerSpec;
        this.status = status;
    }

    public JenkinsJobXMLTiggersData() {
    }

    public String getScmTriggerSpec() {
        return scmTriggerSpec;
    }

    public void setScmTriggerSpec(String scmTriggerSpec) {
        this.scmTriggerSpec = scmTriggerSpec;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
