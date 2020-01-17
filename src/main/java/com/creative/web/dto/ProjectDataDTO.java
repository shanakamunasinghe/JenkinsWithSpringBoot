package com.creative.web.dto;

import com.creative.web.model.AutomationToolData;

public class ProjectDataDTO {
    private Integer id;
    private String name;
    private Integer createUserId;
    private String status;
    private AutomationToolDataDTO automationToolData;

    public ProjectDataDTO() {
    }

    public ProjectDataDTO(String name, Integer createUserId, String status, AutomationToolDataDTO automationToolData) {
        this.name = name;
        this.createUserId = createUserId;
        this.status = status;
        this.automationToolData = automationToolData;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AutomationToolDataDTO getAutomationToolDataDTO() {
        return automationToolData;
    }

    public void setAutomationToolDataDTO(AutomationToolDataDTO automationToolData) {
        this.automationToolData = automationToolData;
    }
}
