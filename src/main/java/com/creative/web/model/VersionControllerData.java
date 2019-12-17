package com.creative.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VersionControllerData {

    @Id
    private int id;
    
    private String name;

}
