package com.creative.web.controller;
import com.creative.web.dto.UserDataDTO;
import com.creative.web.model.JenkinsJobData;
import com.creative.web.service.JenkinsService;
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
    public JenkinsService jenkinsService;

    @RequestMapping(value = "/createJenkinsUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createJenkinsUser(@RequestBody UserDataDTO user) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.createJenkinsUser(user), HttpStatus.OK);
    }
    @RequestMapping(value = "/deleteJenkinsUser",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteJenkinsUser() throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.deleteJenkinsUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "/runJenkinsJob",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> runJenkinsJob() throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.runJenkinsJob(), HttpStatus.OK);
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
    public ResponseEntity<Integer> createJenkinsJob(@RequestBody JenkinsJobData jobName) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.createJenkinsJob(jobName.getJobName()), HttpStatus.OK);
    }



}
