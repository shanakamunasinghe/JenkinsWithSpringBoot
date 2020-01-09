package com.creative.web.controller;

import com.creative.web.dto.JenkinsGlobalRoleDataDTO;
import com.creative.web.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JenkinsRolesController {

    @Autowired
    public JenkinsService jenkinsService;

//    public RequestEntity<List<JenkinsGlobalRoleDataDTO>> getAllJenkinsGlobalRoles(){
//        return RequestEntity<JenkinsGlobalRoleDataDTO>();
//    }


}
