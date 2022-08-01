package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.dto.Employee;
import com.example.demo.exception.EmployeeException;

@Component
//@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getEmployeeById(Integer employeeId) throws EmployeeException {
		
		return this.employeeRepository.getEmployeeById(employeeId);
	}

	@Override
	@Transactional
	public Boolean addEmployee(Employee employee) throws EmployeeException {
		
		return this.employeeRepository.addEmployee(employee);
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) throws EmployeeException {
		Employee foundEmployee = null;
		try {
			foundEmployee = this.employeeRepository.getEmployeeById(employee.getId());
			if(foundEmployee == null) {
				throw new EmployeeException("Employee id not found:"+employee.getId());}
		} catch (EmployeeException e) {
			throw e;
		}
		return this.employeeRepository.updateEmployee(employee);
	}

	@Override
	@Transactional
	public Boolean deleteEmployee(Integer employeeId) throws EmployeeException  {
		Employee foundEmployee = null;
		try {
			foundEmployee = this.employeeRepository.getEmployeeById(employeeId);
			if(foundEmployee == null) {
				throw new EmployeeException("Employee id not found: "+employeeId);
			}
		} catch (EmployeeException e) {
			throw e;
		}
		this.employeeRepository.deleteEmployee(foundEmployee);
		return true;
	}

}
