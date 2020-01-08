package com.creative.web.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class JenkinsUserData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String jenkinsName;
    private String jenkinsPassword;
    private String jenkinsAPIToken;

    @OneToMany(mappedBy = "user")
    private Set<JenkinsUsersProjectsData> jenkinsUsersProjectsData;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",
            unique = true,
            nullable = true)
    private EmployeeData employeeData;

    private String status;


    public JenkinsUserData() {
    }

    public JenkinsUserData(String name, String jenkinsName, String jenkinsPassword, String jenkinsAPIToken, String status) {
        this.name = name;
        this.jenkinsName = jenkinsName;
        this.jenkinsPassword = jenkinsPassword;
        this.jenkinsAPIToken = jenkinsAPIToken;
        this.status = status;
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

    public String getJenkinsName() {
        return jenkinsName;
    }

    public void setJenkinsName(String jenkinsName) {
        this.jenkinsName = jenkinsName;
    }

    public String getJenkinsPassword() {
        return jenkinsPassword;
    }

    public void setJenkinsPassword(String jenkinsPassword) {
        this.jenkinsPassword = jenkinsPassword;
    }

    public Set<JenkinsUsersProjectsData> getJenkinsUsersProjectsData() {
        return jenkinsUsersProjectsData;
    }

    public void setJenkinsUsersProjectsData(Set<JenkinsUsersProjectsData> jenkinsUsersProjectsData) {
        this.jenkinsUsersProjectsData = jenkinsUsersProjectsData;
    }

    public EmployeeData getEmployeeData() {
        return employeeData;
    }

    public void setEmployeeData(EmployeeData employeeData) {
        this.employeeData = employeeData;
    }

    public String getJenkinsAPIToken() {
        return jenkinsAPIToken;
    }

    public void setJenkinsAPIToken(String jenkinsAPIToken) {
        this.jenkinsAPIToken = jenkinsAPIToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
