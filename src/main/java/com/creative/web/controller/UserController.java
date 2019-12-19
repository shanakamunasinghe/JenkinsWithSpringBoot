package com.creative.web.controller;
import com.creative.web.dto.UserDataDTO;
import com.creative.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/usersData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDataDTO>> getAllUserData() throws IOException {
        return new ResponseEntity<List<UserDataDTO>>(userService.findALLUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/userData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDataDTO> getUserData(@PathVariable("id") Integer id) {
        return new ResponseEntity<UserDataDTO>(userService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/userData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createUser(@RequestBody UserDataDTO user) {
        userService.createUser(user);
        return new ResponseEntity<Integer>(01, HttpStatus.OK);
    }

    @RequestMapping(value = "/userData",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateUserData(@RequestBody UserDataDTO user) {
        userService.createUser(user);
        return new ResponseEntity<Integer>(user.getId(), HttpStatus.OK);
    }

    @RequestMapping(value = "/userData",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteUserData(@RequestBody UserDataDTO user) {
        userService.deleteUser(user);
        return new ResponseEntity<Integer>(user.getId(), HttpStatus.OK);
    }
}
