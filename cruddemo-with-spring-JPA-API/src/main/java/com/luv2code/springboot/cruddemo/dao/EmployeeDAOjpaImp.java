package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOjpaImp implements EmployeeDAO {

	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOjpaImp( EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	
	@Override
	public List<Employee> findAll() {
//		System.out.println("come in jpa API");
		Query thequery = entityManager.createQuery("from Employee");
		
		List<Employee> theEmployee = thequery.getResultList();
		
		return theEmployee;
	}

	@Override
	public Employee findbyId(int id) {
		// TODO Auto-generated method stub
		Employee employee = entityManager.find(Employee.class, id);
		
		return employee;
	}

	@Override
	public void save(Employee theemployee) {
		//save or update the employee
		Employee dbEmployee = entityManager.merge(theemployee);
		
		//update with id from dp....so we can get generated id from save/insert
		theemployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteEmployee(int id) {
       Query thequery = entityManager.createQuery("delete from Employee where id = :employeid");
       
       thequery.setParameter("employeid", id);
       
       thequery.executeUpdate();
	}

}
