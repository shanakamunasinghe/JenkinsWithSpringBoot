package com.creative.web.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class EmployeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String status;
    private String role;

    // the property has to change
    @OneToOne(cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    private JenkinsUserData jenkinsUserData;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<EmployeeProjectsData> employeeProjectsData;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    public EmployeeData() {
    }

    public EmployeeData(Integer id, String name, String status, String role) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.role = role;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public JenkinsUserData getJenkinsUserData() {
        return jenkinsUserData;
    }

    public void setJenkinsUserData(JenkinsUserData jenkinsUserData) {
        this.jenkinsUserData = jenkinsUserData;
    }

    public Set<EmployeeProjectsData> getEmployeeProjectsData() {
        return employeeProjectsData;
    }

    public void setEmployeeProjectsData(Set<EmployeeProjectsData> employeeProjectsData) {
        this.employeeProjectsData = employeeProjectsData;
    }
}
