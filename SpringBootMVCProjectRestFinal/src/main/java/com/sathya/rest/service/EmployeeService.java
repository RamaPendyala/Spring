package com.sathya.rest.service;
import java.util.Map;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sathya.rest.models.Employee;
import com.sathya.rest.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		Employee saveEmp = employeeRepository.save(employee);
        return saveEmp;
    }
	
	public List<Employee> saveAllEmployees(List<Employee> employees) {
       List<Employee> emps = employeeRepository.saveAll(employees); 
        return (emps);
    }

	public List<Employee> getAllEmployees() {
		 List<Employee> emps = employeeRepository.findAll();
		return emps;
	}

	public Optional<Employee>getById(Long id) {
		Optional<Employee> optionalemp = employeeRepository.findById(id);
		return optionalemp;
	}

	 public Optional<Employee> getByEmail(String email) {
		 Optional<Employee> optionalemp = employeeRepository.findByEmail(email);
		return optionalemp;
	    }


	public boolean deleteEmployeeById(Long id) {
		boolean status=employeeRepository.existsById(id);
		if(status)
		{
			employeeRepository.deleteById(id);
			return true;
		}
		else
		{
			return false;
		}
	}	
	
	public boolean deleteEmployeeByEmail (String email) {
		boolean status = employeeRepository.existsByEmail(email);
		if(status)
		{
			employeeRepository.deleteByEmail(email);
			return true;
		}
		else
		{
			
			return false;
		}
	}
	
	
	public Optional<Employee>updateById(Long id ,Employee newemployee)
	{
		Optional<Employee> optionalemp=employeeRepository.findById(id);
		if(optionalemp.isPresent())
		{
			Employee existingEmployee =optionalemp.get();
			existingEmployee.setName(newemployee.getName());
			existingEmployee.setSalary(newemployee.getSalary());
			existingEmployee.setDepartment(newemployee.getDepartment());
			existingEmployee.setEmail(newemployee.getEmail());
			Employee updatedEmployee=employeeRepository.save(existingEmployee);
			return Optional.of(updatedEmployee);
		}
		else
		{
			return Optional.empty(); 
		}
	}
	
	public Optional<Employee> updatePartialData(Long id, Map<String, Object> updates){

	    Optional<Employee> optionalEmp = employeeRepository.findById(id);
	    if (optionalEmp.isPresent()) {
	        Employee existingEmployee = optionalEmp.get();

	        updates.forEach((key, value) -> {
	            switch (key) {
	                case "name":
	                    existingEmployee.setName((String) value);
	                    break;
	                case "salary":
	                    if (value instanceof Number) {
	                        existingEmployee.setSalary(((Number) value).doubleValue());
	                    }
	                    break;
	                case "department":
	                    existingEmployee.setDepartment((String) value);
	                    break;
	                case "email":
	                    existingEmployee.setEmail((String) value);
	                    break;
	                // Add more cases as necessary
	                default:
	                    // Optional: log or handle unknown keys if needed
	                    break;
	            }
	        });

	        Employee updatedEmp = employeeRepository.save(existingEmployee);
	        return Optional.of(updatedEmp);
	    } else {
	        return Optional.empty();
	    }
	}

	
}

	

	 
	 
	

	


