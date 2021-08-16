package com.luv2code.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository2 extends JpaRepository<Employee, Integer> {

	//tht's all khtm yahi ... sare crud operation jpareposrity provide krvayegi
}
