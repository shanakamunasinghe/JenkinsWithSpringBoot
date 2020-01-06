package com.creative.web.dto;

public class JenkinsBuildDTO {
    private String full_url;
    private int number;
    private String phase;
    private String status;
    private String url;
    private JenkinsNotificationSCMDTO scm;

    public JenkinsBuildDTO() {
    }

    public JenkinsBuildDTO(String full_url, int number, String phase, String status, String url, JenkinsNotificationSCMDTO scm) {
        this.full_url = full_url;
        this.number = number;
        this.phase = phase;
        this.status = status;
        this.url = url;
        this.scm = scm;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JenkinsNotificationSCMDTO getScm() {
        return scm;
    }

    public void setScm(JenkinsNotificationSCMDTO scm) {
        this.scm = scm;
    }
}
