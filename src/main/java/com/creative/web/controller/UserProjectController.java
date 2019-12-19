package com.creative.web.controller;

import com.creative.web.dto.UsersProjectsDataDTO;
import com.creative.web.service.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserProjectController {
    @Autowired
    private UserProjectService userProjectService;

    @RequestMapping(value = "/usersProjectsData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsersProjectsDataDTO>> getAllUsersProjectsData() {
        return new ResponseEntity<List<UsersProjectsDataDTO>>(userProjectService.findALLUsersProjects(), HttpStatus.OK);
    }

    @RequestMapping(value = "/userProjectData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersProjectsDataDTO> getUserProjectData(@PathVariable("id") Integer id){
        return new ResponseEntity<UsersProjectsDataDTO>(userProjectService.findById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/userProjectData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createUserProject(@RequestBody UsersProjectsDataDTO usersProjectsDataDTO){
        userProjectService.createUserProject(usersProjectsDataDTO);
        return new ResponseEntity<Integer>(01,HttpStatus.OK);
    }

    @RequestMapping(value = "/userProjectData",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateUserProject(@RequestBody UsersProjectsDataDTO usersProjectsDataDTO){
        userProjectService.createUserProject(usersProjectsDataDTO);
        return new ResponseEntity<Integer>(usersProjectsDataDTO.getId(),HttpStatus.OK);
    }
    @RequestMapping(value = "/userProjectData",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteUserProject(@RequestBody UsersProjectsDataDTO usersProjectsDataDTO){
        userProjectService.deleteUserProject(usersProjectsDataDTO);
        return new ResponseEntity<Integer>(usersProjectsDataDTO.getId(),HttpStatus.OK);
    }
}
