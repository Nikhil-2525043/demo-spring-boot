package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Employee;
import com.example.demo.exception.EmployeeException;
import com.example.demo.service.EmployeeService;

@RestController  //class level annotation
@RequestMapping(value = "/v1")  //class level annotation
public class EmployeeController {  //request handler-mapper
	
	@Autowired
	private EmployeeService employeeService; //Dependency Injection
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")  //this is equivalent to the above mapping
	public String greet() {  //handler method 
		return "Hello GL India";
	}
	
//	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@GetMapping("/employee")
	public Employee getEmployee() {
		return new Employee(1, "nikhil", 10000.0);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		Employee isEmployeeFetched = null;
		try {
			isEmployeeFetched = this.employeeService.getEmployeeById(id);
		} catch (EmployeeException e) {
			System.out.println(e.getLocalizedMessage());
		}
		return isEmployeeFetched;
	}
	
//	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	@PostMapping("/employee")
	public Boolean createEmployee(@RequestBody Employee employee) {
//		System.out.println("Post new Employee: " + employee);
		Boolean isNewEmployeeCreated = false;
		try {
			isNewEmployeeCreated = this.employeeService.addEmployee(employee);
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}
		return isNewEmployeeCreated;
	}
	
//	@RequestMapping(value = "/employee", method = RequestMethod.PUT)
//	@PutMapping("/employee")
//	public void updateEmployee(@RequestBody Employee employee) {
//		System.out.println("Update Employee : " + employee);
//		return employee;
//	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee employee) throws EmployeeException  {
		return this.employeeService.updateEmployee(employee);
	}
	
//	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.DELETE)
	@DeleteMapping("/employee/{empId}")
	public Boolean deleteEmployee(@PathVariable("empId") Integer employeeId) throws EmployeeException {
//		System.out.println("Delete Employee id : " + employeeId);
		this.employeeService.deleteEmployee(employeeId);
		return true;
	}

}
