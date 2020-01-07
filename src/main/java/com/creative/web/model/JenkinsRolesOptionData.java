package com.creative.web.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class JenkinsRolesOptionData {
    // for credentials
    private boolean credentialsCreate;
    private boolean credentialsDelete;
    private boolean credentialsManageDomains;
    private boolean credentialsUpdate;
    private boolean credentialsView;

    // for job
    private boolean jobBuild;
    private boolean jobCancel;
    private boolean jobConfigure;
    private boolean jobCreate;
    private boolean jobDelete;
    private boolean jobDiscover;
    private boolean jobMove;
    private boolean jobRead;
    private boolean jobWorkSpace;

    // for run
    private boolean runDelete;
    private boolean runReplay;
    private boolean runUpdate;

    //scm
    private boolean scmTag;

    //for lockable resources
    private boolean lockResReserve;
    private boolean lockResUnlock;
    private boolean lockResView;

    public JenkinsRolesOptionData() {
    }

    public boolean isCredentialsCreate() {
        return credentialsCreate;
    }

    public void setCredentialsCreate(boolean credentialsCreate) {
        this.credentialsCreate = credentialsCreate;
    }

    public boolean isCredentialsDelete() {
        return credentialsDelete;
    }

    public void setCredentialsDelete(boolean credentialsDelete) {
        this.credentialsDelete = credentialsDelete;
    }

    public boolean isCredentialsManageDomains() {
        return credentialsManageDomains;
    }

    public void setCredentialsManageDomains(boolean credentialsManageDomains) {
        this.credentialsManageDomains = credentialsManageDomains;
    }

    public boolean isCredentialsUpdate() {
        return credentialsUpdate;
    }

    public void setCredentialsUpdate(boolean credentialsUpdate) {
        this.credentialsUpdate = credentialsUpdate;
    }

    public boolean isCredentialsView() {
        return credentialsView;
    }

    public void setCredentialsView(boolean credentialsView) {
        this.credentialsView = credentialsView;
    }

    public boolean isJobBuild() {
        return jobBuild;
    }

    public void setJobBuild(boolean jobBuild) {
        this.jobBuild = jobBuild;
    }

    public boolean isJobCancel() {
        return jobCancel;
    }

    public void setJobCancel(boolean jobCancel) {
        this.jobCancel = jobCancel;
    }

    public boolean isJobConfigure() {
        return jobConfigure;
    }

    public void setJobConfigure(boolean jobConfigure) {
        this.jobConfigure = jobConfigure;
    }

    public boolean isJobCreate() {
        return jobCreate;
    }

    public void setJobCreate(boolean jobCreate) {
        this.jobCreate = jobCreate;
    }

    public boolean isJobDelete() {
        return jobDelete;
    }

    public void setJobDelete(boolean jobDelete) {
        this.jobDelete = jobDelete;
    }

    public boolean isJobDiscover() {
        return jobDiscover;
    }

    public void setJobDiscover(boolean jobDiscover) {
        this.jobDiscover = jobDiscover;
    }

    public boolean isJobMove() {
        return jobMove;
    }

    public void setJobMove(boolean jobMove) {
        this.jobMove = jobMove;
    }

    public boolean isJobRead() {
        return jobRead;
    }

    public void setJobRead(boolean jobRead) {
        this.jobRead = jobRead;
    }

    public boolean isJobWorkSpace() {
        return jobWorkSpace;
    }

    public void setJobWorkSpace(boolean jobWorkSpace) {
        this.jobWorkSpace = jobWorkSpace;
    }

    public boolean isRunDelete() {
        return runDelete;
    }

    public void setRunDelete(boolean runDelete) {
        this.runDelete = runDelete;
    }

    public boolean isRunReplay() {
        return runReplay;
    }

    public void setRunReplay(boolean runReplay) {
        this.runReplay = runReplay;
    }

    public boolean isRunUpdate() {
        return runUpdate;
    }

    public void setRunUpdate(boolean runUpdate) {
        this.runUpdate = runUpdate;
    }

    public boolean isScmTag() {
        return scmTag;
    }

    public void setScmTag(boolean scmTag) {
        this.scmTag = scmTag;
    }

    public boolean isLockResReserve() {
        return lockResReserve;
    }

    public void setLockResReserve(boolean lockResReserve) {
        this.lockResReserve = lockResReserve;
    }

    public boolean isLockResUnlock() {
        return lockResUnlock;
    }

    public void setLockResUnlock(boolean lockResUnlock) {
        this.lockResUnlock = lockResUnlock;
    }

    public boolean isLockResView() {
        return lockResView;
    }

    public void setLockResView(boolean lockResView) {
        this.lockResView = lockResView;
    }
}
