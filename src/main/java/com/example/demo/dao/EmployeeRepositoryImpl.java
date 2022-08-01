package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.example.demo.dto.Employee;
import com.example.demo.exception.EmployeeException;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Boolean addEmployee(Employee employee) throws EmployeeException {
		
		this.entityManager.persist(employee);
		return true;
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) throws EmployeeException {
		
		return this.entityManager.find(Employee.class, employeeId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		return this.entityManager.merge(employee);
	}

	@Override
	public Boolean deleteEmployee(Employee employee) {
		this.entityManager.remove(employee);
		return true;
	}

}
