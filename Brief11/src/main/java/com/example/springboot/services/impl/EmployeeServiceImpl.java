package com.example.springboot.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	EmployeeRepository employeeRepository;
	

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id)); 
		
		existingEmployee.setFirstname(employee.getFirstname());
		existingEmployee.setLastname(employee.getLastname());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setRole(employee.getRole());
		// save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}


	@Override
	public void deleteEmployee(long id) {
		// check whether a employee exist in a DB or not
		employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);		
	}



}
