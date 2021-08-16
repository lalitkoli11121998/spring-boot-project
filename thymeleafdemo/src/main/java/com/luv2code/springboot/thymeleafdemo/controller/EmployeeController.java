package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	
	
	//load employee data
	private List<Employee> employeelist;
	
	@PostConstruct
	private void loadData() {
		//create employees
		Employee emp1 = new Employee("lesslie", "kumar", "kesli@gmail.com", 1);
		Employee emp2 = new Employee("alish", "khurana", "alisha@gmail.com", 1);
		Employee emp3 = new Employee("nitisha", "rathore", "nithisha@gmail.com", 1);
		
		//create the list
		employeelist = new ArrayList<>();
		employeelist.add(emp3);
		employeelist.add(emp1);
		employeelist.add(emp2);
	}
	
	@GetMapping("/list")
	public String listEmployee(Model thmodel) {
		thmodel.addAttribute("employees",employeelist );
		return "list-employees";
	}
}
