package com.creative.web.controller;

import com.creative.web.dto.VersionControllerDataDTO;
import com.creative.web.service.VersionControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VersionConController {

    @Autowired
    public VersionControllerService versionControllerService;

    @RequestMapping(value = "/versionControllersData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<VersionControllerDataDTO>> getAllVersionControllerData(){
        return new ResponseEntity<List<VersionControllerDataDTO>>(versionControllerService.getAllVersionControllerData(), HttpStatus.OK);
    }

    @RequestMapping(value = "/versionControllerData/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VersionControllerDataDTO> getVersionControllerById(@PathVariable int id){
        return new ResponseEntity<VersionControllerDataDTO>(versionControllerService.getById(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/createVersionControllerData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createVersionController(@RequestBody VersionControllerDataDTO versionControllerDataDTO){
        return new ResponseEntity<>(versionControllerService.createVersionController(versionControllerDataDTO),HttpStatus.OK);
    }

    @RequestMapping(value = "/updateVersionControllerData",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateVersionController(@RequestBody VersionControllerDataDTO versionControllerDataDTO){
        return new ResponseEntity<>(versionControllerService.updateVersionController(versionControllerDataDTO),HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteVersionControllerData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteVersionController(@RequestBody VersionControllerDataDTO versionControllerDataDTO){
        return new ResponseEntity<>(versionControllerService.deleteVersionController(versionControllerDataDTO),HttpStatus.OK);
    }
}
