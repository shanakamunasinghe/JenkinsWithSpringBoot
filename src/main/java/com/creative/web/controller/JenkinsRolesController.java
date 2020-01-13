package com.creative.web.controller;

import com.creative.web.dto.JenkinsGlobalRoleDataDTO;
import com.creative.web.dto.JenkinsItemRoleDataDTO;
import com.creative.web.dto.JenkinsRoleDetailsDTO;
import com.creative.web.model.JenkinsItemRoleData;
import com.creative.web.service.JenkinsGlobalRoleService;
import com.creative.web.service.JenkinsItemRoleService;
import com.creative.web.service.JenkinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class JenkinsRolesController {

    @Autowired
    public JenkinsService jenkinsService;

    @Autowired
    public JenkinsGlobalRoleService jenkinsGlobalRoleService;

    @Autowired
    public JenkinsItemRoleService jenkinsItemRoleService;

    @RequestMapping(value = "/getJenkinsGlobalRoles",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JenkinsGlobalRoleDataDTO>> getAllJenkinsGlobalRoles(){
        return new ResponseEntity<List<JenkinsGlobalRoleDataDTO>>(jenkinsGlobalRoleService.getAllGlobalRoleData(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getJenkinsGlobalRole/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JenkinsGlobalRoleDataDTO> getJenkinsGlobalRoleById(@PathVariable int id){
        return new ResponseEntity<JenkinsGlobalRoleDataDTO>(jenkinsGlobalRoleService.getJenkinsGlobalRoleDataById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/getJenkinsItemRoles",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<JenkinsItemRoleDataDTO>> getAllJenkinsItemRoles(){
        return new ResponseEntity<List<JenkinsItemRoleDataDTO>>(jenkinsItemRoleService.getAllItemRoleData(), HttpStatus.OK);
    }

    @RequestMapping(value = "/getJenkinsItemRole/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JenkinsItemRoleDataDTO> getJenkinsItemRoleById(@PathVariable int id){
        return new ResponseEntity<JenkinsItemRoleDataDTO>(jenkinsItemRoleService.getItemRoleById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/createJenkinsGlobalRole",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createJenkinsGlobalRole(@RequestBody JenkinsGlobalRoleDataDTO jenkinsGlobalRoleDataDTO) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.createJenkinsGlobalRole(jenkinsGlobalRoleDataDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/createJenkinsItemRole",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createJenkinsItemRole(@RequestBody JenkinsItemRoleDataDTO jenkinsItemRoleDataDTO) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.createJenkinsItemRole(jenkinsItemRoleDataDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteJenkinsRoles",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteJenkinsRoles(@RequestBody JenkinsRoleDetailsDTO jenkinsRoleDetailsDTO) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.deleteJenkinsRoles(jenkinsRoleDetailsDTO.getRoleName(),jenkinsRoleDetailsDTO.getType()),HttpStatus.OK);
    }

    @RequestMapping(value = "/assignRoleToJenkinsUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> assignRoleToJenkinsUser(@RequestBody JenkinsRoleDetailsDTO jenkinsRoleDetailsDTO) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.assignRoleToJenkinsUser(jenkinsRoleDetailsDTO.getRoleName(),jenkinsRoleDetailsDTO.getType(),jenkinsRoleDetailsDTO.getUserName()),HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteUserFromAllRoles",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteUserFromAllRoles(@RequestBody JenkinsRoleDetailsDTO jenkinsRoleDetailsDTO) throws IOException {
        return new ResponseEntity<Integer>(jenkinsService.deleteUserFromAllRoles(jenkinsRoleDetailsDTO.getType(),jenkinsRoleDetailsDTO.getUserName()),HttpStatus.OK);
    }


}
