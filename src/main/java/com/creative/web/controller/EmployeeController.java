package com.creative.web.controller;

import com.creative.web.dto.EmployeeDataDTO;
import com.creative.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @RequestMapping(value = "/employeesData",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDataDTO>> getAllEmployeeData(){
        return new ResponseEntity<>(employeeService.findALLJenkinsUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeData/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDataDTO> getEmployeeData(@PathVariable int id){
        return new ResponseEntity<EmployeeDataDTO> (employeeService.findById(id),HttpStatus.OK);
    }
    @RequestMapping(value = "/createEmployeeData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> createEmployee(@RequestBody EmployeeDataDTO employeeDataDTO){
        return new ResponseEntity<Integer>(employeeService.createEmployee(employeeDataDTO),HttpStatus.OK);
    }
    @RequestMapping(value = "/updateEmployeeData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> updateEmployee(@RequestBody EmployeeDataDTO employeeDataDTO){
        return new ResponseEntity<Integer>(employeeService.updateEmployee(employeeDataDTO),HttpStatus.OK);
    }

    // have to inactive the jenkins user
    @RequestMapping(value = "/deleteEmployeeData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> deleteEmployee(@RequestBody EmployeeDataDTO employeeDataDTO){
        return new ResponseEntity<Integer>(employeeService.deleteEmployee(employeeDataDTO),HttpStatus.OK);
    }
}
