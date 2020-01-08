package com.creative.web.controller;

import com.creative.web.dto.EmployeeDataDTO;
import com.creative.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
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
        return new ResponseEntity<List<EmployeeDataDTO>>(employeeService.findALLJenkinsUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/employeeData",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDataDTO> getEmployeeData(@RequestBody Integer id){
        return new ResponseEntity<EmployeeDataDTO> (employeeService.findById(id),HttpStatus.OK);
    }
}
