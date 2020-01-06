package com.creative.web.model;

public class JenkinsJobXMLBuilderData {
    private String type;
    private String targets;
    private String status;
    private String pom;
    private String usePrivateRepository;

    public JenkinsJobXMLBuilderData() {
    }

    public JenkinsJobXMLBuilderData(String type, String targets, String status, String pom, String usePrivateRepository) {
        this.type = type;
        this.targets = targets;
        this.status = status;
        this.pom = pom;
        this.usePrivateRepository = usePrivateRepository;
    }

    public String getTargets() {
        return targets;
    }

    public void setTargets(String targets) {
        this.targets = targets;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPom() {
        return pom;
    }

    public void setPom(String pom) {
        this.pom = pom;
    }

    public String getUsePrivateRepository() {
        return usePrivateRepository;
    }

    public void setUsePrivateRepository(String usePrivateRepository) {
        this.usePrivateRepository = usePrivateRepository;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
