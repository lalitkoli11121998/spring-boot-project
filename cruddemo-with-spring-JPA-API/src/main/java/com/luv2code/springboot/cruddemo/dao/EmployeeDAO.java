package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee>findAll();
	
	public Employee findbyId(int id);
	
    public void save(Employee employee);
    
    public void deleteEmployee(int id);
	
}
