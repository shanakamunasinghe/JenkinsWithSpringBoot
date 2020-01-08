package com.creative.web.controller;
import com.creative.web.dto.UserDataDTO;
import com.creative.web.model.JenkinsJobData;
import com.creative.web.service.JenkinsService;
import com.creative.web.service.JenkinsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@CrossOrigin
public class JenkinsController {
    @Autowired
    public final JenkinsService jenkinsService;

    @Autowired
    public JenkinsUserService jenkinsUserService;

    public JenkinsController(JenkinsService jenkinsService) {
        this.jenkinsService = jenkinsService;
    }


    @RequestMapping(value = "/runJenkinsJob",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> runJenkinsJob(@RequestBody String jobName) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.runJenkinsJob(jobName), HttpStatus.OK);
    }
    @RequestMapping(value = "/getJenkinsStatus",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getJenkinsStatus() throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.getJenkinsStatus(), HttpStatus.OK);
    }

    @RequestMapping(value = "/createJenkinsJob",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createJenkinsJob(@RequestBody JenkinsJobData jenkinsJobData) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.createJenkinsJob(jenkinsJobData.getJobName()), HttpStatus.OK);
    }





}
