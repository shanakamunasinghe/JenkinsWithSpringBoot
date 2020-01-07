package com.creative.web.dto;

import com.creative.web.model.AutomationToolData;

public class ProjectDataDTO {
    private Integer id;

    private String name;
    private Integer createUserId;
    private boolean status;
    private AutomationToolData automationToolData;

    public ProjectDataDTO() {
    }

    public ProjectDataDTO(String name, Integer createUserId, boolean status, AutomationToolData automationToolId) {
        this.name = name;
        this.createUserId = createUserId;
        this.status = status;
        this.automationToolData = automationToolId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public AutomationToolData getAutomationToolData() {
        return automationToolData;
    }

    public void setAutomationToolData(AutomationToolData automationToolData) {
        this.automationToolData = automationToolData;
    }
}
