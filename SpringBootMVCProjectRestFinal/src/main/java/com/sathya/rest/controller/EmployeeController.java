package com.sathya.rest.controller;


import java.util.List; 
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sathya.rest.exception.EmployeeNotFoundException;
import com.sathya.rest.models.Employee;
import com.sathya.rest.service.EmployeeService;

import jakarta.validation.Valid;
@RequestMapping("/api/v1")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@PostMapping("/saveEmp")
	public ResponseEntity <Employee>saveEmployee(@Valid @RequestBody Employee employee) {
		Employee saveEmp = employeeService.saveEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("employeeStatus", "employee saved Successfully")
				             .body(saveEmp);
		
	}
	@PostMapping("/saveAll")
	public ResponseEntity<List<Employee>> saveAllEmployees(@RequestBody List<Employee>employees){
		List<Employee> emps=
				employeeService.saveAllEmployees(employees);
		return ResponseEntity.status(HttpStatus.CREATED)
				             .header("success", "AllemployeesSaved")   
				             .body(emps);
		
	}
	@GetMapping("getAll")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> emps = 
				employeeService.getAllEmployees();
		return ResponseEntity.status(HttpStatus.OK)
				             .header("status","Data reading is Successfully")
				             .body(emps);

	}
	@GetMapping("getbyid/{id}")
	public ResponseEntity<?>getById(@PathVariable Long id)
	{
		Optional<Employee>optionalEmp = employeeService.getById(id);
		if(optionalEmp.isPresent())
		{	
			Employee employee = optionalEmp.get();
			 // Create an EntityModel for the user
	        EntityModel<Employee> entityModel = EntityModel.of(employee);

	        // Add self link
	        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getById(id)).withSelfRel());

	        // Add link to update the user
	        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).updateEmployeeById(id, employee)).withRel("update"));

	        // Add link to delete the user
	        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).deleteEmployeeById(id)).withRel("delete"));

	        // Add link to get all users
	        entityModel.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EmployeeController.class).getAllEmployees()).withRel("all-users"));
			
			return ResponseEntity.status(HttpStatus.OK)
								 .body(entityModel);
		}
		else
		{	//return ResponseEntity.status(HttpStatus.NOT_FOUND)
				//				 .body("Emp is not found with Id.."+id);	
			throw new EmployeeNotFoundException("Employee not found with id "+id);
		}
	@GetMapping("getbyid/{email}")
	public ResponseEntity<?>getByEmail(@PathVariable String email)
	{
		Optional<Employee>optionalEmp = employeeService.getByEmail(email);
	   if(optionalEmp.isPresent())
	   {
		   return ResponseEntity.status(HttpStatus.OK)
				                .body(optionalEmp);
				   
	   }
	   else
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                                  .body("emp is not found"+email);
	   }
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id)
	{
	boolean status = employeeService.deleteEmployeeById(id);
			if(status)
			{
				return ResponseEntity.noContent().build();
				
			}
			else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						             .body("data is not found"+id);
			}
	}


	@DeleteMapping("/deleteByEmail/{email}")
	public ResponseEntity<?> deleteEmployeeByEmail(@PathVariable String email)
	{
		boolean status = employeeService.deleteEmployeeByEmail(email);
		if(status)
		{
			return ResponseEntity.noContent().build();
			
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					             .body("data is not found"+email);
		}
		
	}
	
	@PutMapping("updateById/{id}")
	public ResponseEntity<?>updateById (@PathVariable Long id, @RequestBody Employee newemployee)
	{Optional<Employee> updatedemployee=employeeService.updateById(id, newemployee);
	if(updatedemployee.isPresent())
	{
		 return  ResponseEntity.status(HttpStatus.OK)
	             .body(updatedemployee);
	}
	else
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				 .body("data not found by id..."+id);
	}
	}
	@PatchMapping("/updatePartial/{id}")
	public ResponseEntity<?> updatePartial(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
	    Optional<Employee> updatedEmployee = employeeService.updatePartialData(id, updates);
	    if (updatedEmployee.isPresent()) {
	        return ResponseEntity.ok(updatedEmployee.get());
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Employee not found with ID: " + id);
	    }
	}

}