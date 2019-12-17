package com.creative.web.model;

public class LogRotator {
    private int daysToKeep;
    private int numToKeep;
    private int artifactDaysToKeep;
    private int artifactNumToKeep;

    public LogRotator() {
    }

    public LogRotator(int daysToKeep, int numToKeep, int artifactDaysToKeep, int artifactNumToKeep) {
        this.daysToKeep = daysToKeep;
        this.numToKeep = numToKeep;
        this.artifactDaysToKeep = artifactDaysToKeep;
        this.artifactNumToKeep = artifactNumToKeep;
    }

    public int getDaysToKeep() {
        return daysToKeep;
    }

    public void setDaysToKeep(int daysToKeep) {
        this.daysToKeep = daysToKeep;
    }

    public int getNumToKeep() {
        return numToKeep;
    }

    public void setNumToKeep(int numToKeep) {
        this.numToKeep = numToKeep;
    }

    public int getArtifactDaysToKeep() {
        return artifactDaysToKeep;
    }

    public void setArtifactDaysToKeep(int artifactDaysToKeep) {
        this.artifactDaysToKeep = artifactDaysToKeep;
    }

    public int getArtifactNumToKeep() {
        return artifactNumToKeep;
    }

    public void setArtifactNumToKeep(int artifactNumToKeep) {
        this.artifactNumToKeep = artifactNumToKeep;
    }
}
