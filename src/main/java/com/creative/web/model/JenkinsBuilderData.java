package com.creative.web.model;

public class JenkinsBuilderData {
    private String targets;
    private String mavenName;
    private String pom;
    private boolean usePrivateRepository;

    public JenkinsBuilderData() {
    }

    public JenkinsBuilderData(String targets, String mavenName, String pom, boolean usePrivateRepository) {
        this.targets = targets;
        this.mavenName = mavenName;
        this.pom = pom;
        this.usePrivateRepository = usePrivateRepository;
    }

    public String getTargets() {
        return targets;
    }

    public void setTargets(String targets) {
        this.targets = targets;
    }

    public String getMavenName() {
        return mavenName;
    }

    public void setMavenName(String mavenName) {
        this.mavenName = mavenName;
    }

    public String getPom() {
        return pom;
    }

    public void setPom(String pom) {
        this.pom = pom;
    }

    public boolean isUsePrivateRepository() {
        return usePrivateRepository;
    }

    public void setUsePrivateRepository(boolean usePrivateRepository) {
        this.usePrivateRepository = usePrivateRepository;
    }
}
