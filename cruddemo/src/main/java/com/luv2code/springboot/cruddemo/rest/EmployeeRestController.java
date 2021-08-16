package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//inject employee dao
	
//	public EmployeeRestController(EmployeeDAO theemployeeDAO) { //ye argument spring khud add krti h
//		employeeDAO = theemployeeDAO;
//	}
	
	//expose '/employees" and return the list of employees
	@GetMapping("/employees")
	public List<Employee> findall(){
		return employeeService.findAll();
	}
	
    //add mapping for get /employees/{employeeid}
	
	@GetMapping("/employee/{employeeid}")
	public Employee getemployee(@PathVariable int employeeid ) {
		Employee emp = employeeService.findbyId(employeeid);
		
		if(emp == null) {
			throw new RuntimeException("Employee is not found - " + employeeid);
		}
		return emp;
	}
	
	//Add mapping for post /employees - add new employee
	
	@PostMapping("/employee")
	public Employee addemployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//Add mapping for put /employees - update employee
	
	@PutMapping("/employee")
	public Employee updateemployee(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//add mapping for delete
	@DeleteMapping("/employee/{employeeid}")
	public String deleteemployee(@PathVariable int employeeid) {
         Employee emp = employeeService.findbyId(employeeid);
		
		if(emp == null) {
			throw new RuntimeException("Employee is not found - " + employeeid);
		}
		
		employeeService.deleteEmployee(employeeid);
		return "Employee with id " + employeeid + " has been deleted.";
	}
}
