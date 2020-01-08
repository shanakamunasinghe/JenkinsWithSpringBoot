package com.creative.web.service;
import com.creative.web.dto.EmployeeDataDTO;
import com.creative.web.model.EmployeeData;
import com.creative.web.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    public List<EmployeeDataDTO> findALLJenkinsUsers(){
        List<EmployeeData> employeeData = employeeRepository.findAll();
        List<EmployeeDataDTO> employeeDataDTOS = new ArrayList<>();
        for(EmployeeData eD : employeeData){
            EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
            employeeDataDTO.setId(eD.getId());
            employeeDataDTO.setName(eD.getName());
            employeeDataDTO.setRole(eD.getRole());
            employeeDataDTO.setStatus(eD.getStatus());
        }
        return employeeDataDTOS;
    }

    public EmployeeDataDTO findById(int id){
        EmployeeData employeeData = employeeRepository.getOne(id);
        EmployeeDataDTO employeeDataDTO = new EmployeeDataDTO();
        employeeDataDTO.setId(employeeData.getId());
        employeeDataDTO.setName(employeeData.getName());
        employeeDataDTO.setRole(employeeData.getRole());
        employeeDataDTO.setStatus(employeeData.getStatus());
        return employeeDataDTO;
    }

    public Integer createEmployee(EmployeeDataDTO employeeDataDTO){
        EmployeeData employeeData = new EmployeeData();
        employeeData.setName(employeeDataDTO.getName());
        employeeData.setRole(employeeDataDTO.getRole());
        employeeData.setStatus(employeeDataDTO.getStatus());
        employeeRepository.save(employeeData);
        return 1;
    }

    public Integer deleteEmployee(EmployeeDataDTO employeeDataDTO){
        EmployeeData employeeData = new EmployeeData();
        employeeData.setName(employeeDataDTO.getName());
        employeeData.setRole(employeeDataDTO.getRole());
        employeeData.setStatus(employeeDataDTO.getStatus());
        employeeRepository.delete(employeeData);
        return 1;
    }


}
