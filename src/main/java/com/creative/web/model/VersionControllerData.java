package com.creative.web.model;

import javax.persistence.*;

@Entity
@Table
public class VersionControllerData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private boolean valid;

    public VersionControllerData() {
    }

    public VersionControllerData(String name,boolean valid) {
        this.name = name;
        this.valid = valid;
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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
