package com.example.demo.service;

import com.example.demo.dto.Employee;
import com.example.demo.exception.EmployeeException;

public interface EmployeeService {
	
	Employee getEmployeeById(Integer employeeId) throws EmployeeException;
	Boolean addEmployee(Employee employee) throws EmployeeException;
	Employee updateEmployee(Employee employee) throws EmployeeException;
	Boolean deleteEmployee(Integer employeeId) throws EmployeeException;

}
