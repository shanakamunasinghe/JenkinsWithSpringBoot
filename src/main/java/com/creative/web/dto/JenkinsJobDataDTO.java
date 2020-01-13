package com.creative.web.dto;

import com.creative.web.model.JenkinsJobHistoryData;
import com.creative.web.model.ProjectData;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

public class JenkinsJobDataDTO {
    private Integer id;
    private String jobName;
    private ProjectDataDTO projectDataDTO;
    private String description;
    private String status;

    public JenkinsJobDataDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public ProjectDataDTO getProjectDataDTO() {
        return projectDataDTO;
    }

    public void setProjectDataDTO(ProjectDataDTO projectDataDTO) {
        this.projectDataDTO = projectDataDTO;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
