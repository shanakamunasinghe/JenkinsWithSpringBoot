package com.creative.web.controller;
import com.creative.web.dto.JenkinsUserDTO;
import com.creative.web.service.JenkinsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class JenkinsUserController {
    @Autowired
    private JenkinsUserService jenkinsUserService;

    @RequestMapping(value = "/jenkinsUsersData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JenkinsUserDTO>> getAllUserData() throws IOException {
        return new ResponseEntity<List<JenkinsUserDTO>>(jenkinsUserService.findALLJenkinsUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/jenkinsUserData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JenkinsUserDTO> getUserData(@PathVariable("id") Integer id) {
        return new ResponseEntity<JenkinsUserDTO>(jenkinsUserService.getJenkinsUserById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/jenkinsUserData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createUser(@RequestBody JenkinsUserDTO user) throws IOException {
        jenkinsUserService.createJenkinsUser(user);
        return new ResponseEntity<Integer>(01, HttpStatus.OK);
    }

    @RequestMapping(value = "/jenkinsUserData",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateUserData(@RequestBody JenkinsUserDTO user){
        jenkinsUserService.updateJenkinsUser(user);
        return new ResponseEntity<Integer>(user.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/userData",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteUserData(@RequestBody JenkinsUserDTO user) throws IOException {
        jenkinsUserService.deleteJenkinsUser(user);
        return new ResponseEntity<Integer>(user.getId(), HttpStatus.OK);
    }
}
