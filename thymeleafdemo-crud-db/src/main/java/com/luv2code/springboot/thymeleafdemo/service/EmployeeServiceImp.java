package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImp(EmployeeRepository theemployeeRepository) {
		employeeRepository = theemployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee findbyId(int id) {
		
		Optional<Employee> result = employeeRepository.findById(id);
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("did not found employee by id - " + id);
		}
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);;
	}

}
