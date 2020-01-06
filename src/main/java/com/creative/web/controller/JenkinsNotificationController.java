package com.creative.web.controller;

import com.creative.web.dto.JenkinsNotificationDTO;
import com.creative.web.model.JenkinsJobHistoryData;
import com.creative.web.service.JenkinsNotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class JenkinsNotificationController {
    private final JenkinsNotificationService jenkinsNotificationService;

    public JenkinsNotificationController(JenkinsNotificationService jenkinsNotificationService) {
        this.jenkinsNotificationService = jenkinsNotificationService;
    }

    @RequestMapping(value = "/jobNotification",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> SaveJenkinsJobHistory(@RequestBody JenkinsNotificationDTO notification) throws IOException {
        System.out.println(notification.getName());
        System.out.println(notification.getBuild().getPhase());
        System.out.println("this works");
        jenkinsNotificationService.SaveJenkinsJobHistory(notification);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getJenkinsJobHistory",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JenkinsJobHistoryData>> getJenkinsJobHistory(@RequestBody String jobName) throws IOException {
        return new ResponseEntity<List<JenkinsJobHistoryData>>(jenkinsNotificationService.getJenkinsJobHistory(jobName), HttpStatus.OK);
    }

    @RequestMapping(value = "/getAllJenkinsJobHistory",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JenkinsJobHistoryData>> getAllJenkinsJobHistory() throws IOException {
        return new ResponseEntity<List<JenkinsJobHistoryData>>(jenkinsNotificationService.getAllJenkinsJobHistory(), HttpStatus.OK);
    }
}
