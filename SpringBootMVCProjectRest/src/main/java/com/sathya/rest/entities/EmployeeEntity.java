package com.sathya.rest.entities;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 
 public Long getEmpId() {
	return empId;
}
public void setEmpId(Long empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public double getBasicSalary() {
	return basicSalary;
}
public void setBasicSalary(double basicSalary) {
	this.basicSalary = basicSalary;
}
public double getHra() {
	return hra;
}
public void setHra(double hra) {
	this.hra = hra;
}
public double getDa() {
	return da;
}
public void setDa(double da) {
	this.da = da;
}
public double getPf() {
	return pf;
}
public void setPf(double pf) {
	this.pf = pf;
}
public double getTotalSalary() {
	return totalSalary;
}
public void setTotalSalary(double totalSalary) {
	this.totalSalary = totalSalary;
}
public String getEmpDept() {
	return empDept;
}
public void setEmpDept(String empDept) {
	this.empDept = empDept;
}
public String getEmpEmail() {
	return empEmail;
}
public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}
public String getEmpMobile() {
	return empMobile;
}
public void setEmpMobile(String empMobile) {
	this.empMobile = empMobile;
}
public LocalDate getJoiningDate() {
	return joiningDate;
}
public void setJoiningDate(LocalDate joiningDate) {
	this.joiningDate = joiningDate;
}
 private Long empId;
 private String empName;
 private double basicSalary;
 private double hra;
 private double da;
 private double pf;
 private double totalSalary;
 private String empDept;
 private String empEmail;
 private String empMobile;
 private LocalDate joiningDate;
 
 
}
