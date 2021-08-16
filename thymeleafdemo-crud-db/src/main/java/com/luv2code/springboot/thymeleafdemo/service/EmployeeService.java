package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

    public List<Employee>findAll();
	
	public Employee findbyId(int id);
	
    public void save(Employee employee);
    
    public void deleteEmployee(int id);
}
