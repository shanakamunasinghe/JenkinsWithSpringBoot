package com.creative.web.dto;

public class JenkinsNotificationDTO {
    private String name;
    private String url;
    private JenkinsBuildDTO build;

    public JenkinsNotificationDTO() {
    }

    public JenkinsNotificationDTO(String name, String url, JenkinsBuildDTO build) {
        this.name = name;
        this.url = url;
        this.build = build;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JenkinsBuildDTO getBuild() {
        return build;
    }

    public void setBuild(JenkinsBuildDTO build) {
        this.build = build;
    }
}
