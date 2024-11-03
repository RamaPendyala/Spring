package com.sathya.rest.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sathya.rest.entities.EmployeeEntity;
import com.sathya.rest.models.EmployeeModel;
import com.sathya.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
	public EmployeeEntity saveEmployee(EmployeeModel employeeModel) {
		 double basicSalary = employeeModel.getBasicSalary();
	        double hra = 0.20 * basicSalary;
	        double da = 0.10 * basicSalary;
	        double pf = 0.12 * basicSalary;  double totalSalary = basicSalary + hra + da - pf;

	        EmployeeEntity employeeEntity = new EmployeeEntity();
	        employeeEntity.setEmpName(employeeModel.getEmpName());
	        employeeEntity.setBasicSalary(basicSalary);
	        employeeEntity.setHra(hra);
	        employeeEntity.setDa(da);
	        employeeEntity.setPf(pf);
	        employeeEntity.setTotalSalary(totalSalary);
	        employeeEntity.setEmpDept(employeeModel.getEmpDept());
	        employeeEntity.setEmpEmail(employeeModel.getEmpEmail());
	        employeeEntity.setEmpMobile(employeeModel.getEmpMobile());
	        employeeEntity.setJoiningDate(LocalDate.now());

	        return employeeRepository.save(employeeEntity);
	    }

	
}
