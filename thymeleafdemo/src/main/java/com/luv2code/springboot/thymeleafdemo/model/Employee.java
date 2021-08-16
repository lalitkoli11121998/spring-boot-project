package com.luv2code.springboot.thymeleafdemo.model;

public class Employee {

	
	private int id;
	private String Email;
	private String firstname;
	private String lastname;
	
	
	public Employee(String firstname, String lastname,String email,int id) {
		this.id = id;
		Email = email;
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getFirstname() {
		return firstname;
	}

	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", Email=" + Email + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}

