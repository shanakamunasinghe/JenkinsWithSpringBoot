package com.creative.web.model;

public class JenkinsPublisherData {
    private String artifacts;
    private boolean allowEmptyArchive;
    private boolean onlyIfSuccessful;
    private boolean fingerprint;
    private boolean defaultExcludes;
    private boolean caseSensitive;
    private boolean latestOnly;

    public JenkinsPublisherData() {
    }

    public JenkinsPublisherData(String artifacts, boolean allowEmptyArchive, boolean onlyIfSuccessful, boolean fingerprint, boolean defaultExcludes, boolean caseSensitive, boolean latestOnly) {
        this.artifacts = artifacts;
        this.allowEmptyArchive = allowEmptyArchive;
        this.onlyIfSuccessful = onlyIfSuccessful;
        this.fingerprint = fingerprint;
        this.defaultExcludes = defaultExcludes;
        this.caseSensitive = caseSensitive;
        this.latestOnly = latestOnly;
    }

    public String getArtifacts() {
        return artifacts;
    }

    public void setArtifacts(String artifacts) {
        this.artifacts = artifacts;
    }

    public boolean isAllowEmptyArchive() {
        return allowEmptyArchive;
    }

    public void setAllowEmptyArchive(boolean allowEmptyArchive) {
        this.allowEmptyArchive = allowEmptyArchive;
    }

    public boolean isOnlyIfSuccessful() {
        return onlyIfSuccessful;
    }

    public void setOnlyIfSuccessful(boolean onlyIfSuccessful) {
        this.onlyIfSuccessful = onlyIfSuccessful;
    }

    public boolean isFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(boolean fingerprint) {
        this.fingerprint = fingerprint;
    }

    public boolean isDefaultExcludes() {
        return defaultExcludes;
    }

    public void setDefaultExcludes(boolean defaultExcludes) {
        this.defaultExcludes = defaultExcludes;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public void setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
    }

    public boolean isLatestOnly() {
        return latestOnly;
    }

    public void setLatestOnly(boolean latestOnly) {
        this.latestOnly = latestOnly;
    }
}
