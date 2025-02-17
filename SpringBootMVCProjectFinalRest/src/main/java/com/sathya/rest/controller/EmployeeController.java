package com.sathya.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sathya.rest.entities.EmployeeEntity;
import com.sathya.rest.models.EmployeeModel;
import com.sathya.rest.service.EmployeeService;
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("saveemp")
    public EmployeeEntity saveEmployee(@RequestBody EmployeeModel employeeModel) {
        // Pass the employeeModel to the service method
        EmployeeEntity employeeEntity = employeeService.saveEmployee(employeeModel);
        return employeeEntity;
    }
}

