package com.creative.web.controller;
import com.creative.web.dto.JenkinsJobDataDTO;
import com.creative.web.service.JenkinsJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JenkinsJobController {

    @Autowired
    public JenkinsJobService jenkinsJobService;

    @RequestMapping(value = "/getAllJenkinsJobs",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JenkinsJobDataDTO>> getAllJenkinsJobs(){
        return new ResponseEntity<List<JenkinsJobDataDTO>>(jenkinsJobService.getAllJenkinsJobs(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getJenkinsJob/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JenkinsJobDataDTO> getJenkinsJobById(@PathVariable int id){
        return new ResponseEntity<JenkinsJobDataDTO>(jenkinsJobService.getJenkinsJobById(id), HttpStatus.OK);
    }
}
