package com.example.demo.dao;

import com.example.demo.dto.Employee;
import com.example.demo.exception.EmployeeException;

public interface EmployeeRepository {

	Boolean addEmployee(Employee employee) throws EmployeeException;
	
	Employee getEmployeeById(Integer employeeId) throws EmployeeException;
	
	Employee updateEmployee(Employee employee) ;

	Boolean deleteEmployee(Employee employee);
}
