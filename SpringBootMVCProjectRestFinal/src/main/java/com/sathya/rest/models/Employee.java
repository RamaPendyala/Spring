package com.sathya.rest.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
@Id @GeneratedValue(strategy = GenerationType.AUTO)
private long Id;
@NotBlank(message = "Name is mandatory")
@Size(min = 2, max = 50, message = "Name should be between 2 and 50 characters")
private String name;
@NotNull(message = "Salary is mandatory")
@Min(value = 1000, message = "Salary should not be less than 1000")
@Max(value = 1000000, message = "Salary should not exceed 1,000,000")
private double salary;
@NotBlank(message = "Department is mandatory")
@Size(max = 100, message = "Department name should not exceed 100 characters")
private String department;
@NotBlank(message = "Address is mandatory.")
@Size(max = 200, message = "Address should not exceed 200 characters.")
private String addrees;
@NotBlank(message = "Email is mandatory")
@Email(message = "Email should be valid")
private String email;


public long getId() {
	return Id;
}

public void setId(long id) {
	Id = id;
}
public String getName() { 
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getAddrees() {
	return addrees;
}
public void setAddrees(String addrees) {
	this.addrees = addrees;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}


}
