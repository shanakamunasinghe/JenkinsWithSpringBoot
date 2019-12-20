package com.creative.web.controller;
import com.creative.web.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@CrossOrigin
public class JenkinsController {
    @Autowired
    public JenkinsService jenkinsService;

    @RequestMapping(value = "/createJenkinsUser",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createJenkinsUser() throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.createJenkinsUser(), HttpStatus.OK);
    }
    @RequestMapping(value = "/deleteJenkinsUser",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteJenkinsUser() throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.deleteJenkinsUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "/runJenkinsJob",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> runJenkinsJob() throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.runJenkinsJob(), HttpStatus.OK);
    }
    @RequestMapping(value = "/getJenkinsStatus",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> getJenkinsStatus() throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.getJenkinsStatus(), HttpStatus.OK);
    }
}
