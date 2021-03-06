package com.creative.web.model;

import javax.persistence.*;

@Entity
@Table
public class VersionControllerData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String valid;

    public VersionControllerData() {
    }

    public VersionControllerData(String name, String valid) {
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

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }
}
