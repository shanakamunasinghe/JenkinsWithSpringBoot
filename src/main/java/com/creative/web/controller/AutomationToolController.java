package com.creative.web.controller;

import com.creative.web.dto.AutomationToolDataDTO;
import com.creative.web.service.AutomationToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AutomationToolController {

   @Autowired
    public AutomationToolService automationToolService;

    @RequestMapping(value = "/automationToolsData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<List<AutomationToolDataDTO>> getAllAutomationTools(){
       return new ResponseEntity<>(automationToolService.findAllAutomationTools(), HttpStatus.OK);
   }

    @RequestMapping(value = "/automationToolData/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<AutomationToolDataDTO> getAutomationTool(@PathVariable int id){
        return new ResponseEntity<>(automationToolService.finById(id), HttpStatus.OK);
   }
    @RequestMapping(value = "/automationToolsData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
   public ResponseEntity<Integer> createAutomationTool(@RequestBody AutomationToolDataDTO automationToolDataDTO){
        return new ResponseEntity<>(automationToolService.createAutomationToolData(automationToolDataDTO), HttpStatus.OK);
   }

    @RequestMapping(value = "/automationToolsData",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateAutomationTool(@RequestBody AutomationToolDataDTO automationToolDataDTO){
        return new ResponseEntity<>(automationToolService.updateAutomationToolData(automationToolDataDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteAutomationToolsData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteAutomationTool(@RequestBody AutomationToolDataDTO automationToolDataDTO){
        return new ResponseEntity<>(automationToolService.deleteAutomationToolData(automationToolDataDTO), HttpStatus.OK);
    }
}
