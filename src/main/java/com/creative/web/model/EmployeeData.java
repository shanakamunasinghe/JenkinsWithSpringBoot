package com.creative.web.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class EmployeeData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String Status;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date modified;

    public EmployeeData() {
    }

    public EmployeeData(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        Status = status;
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
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
