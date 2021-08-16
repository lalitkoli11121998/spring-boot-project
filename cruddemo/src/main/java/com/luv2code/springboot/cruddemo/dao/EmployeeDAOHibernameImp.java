package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernameImp implements EmployeeDAO {

	//defien the entitymanager object
	private EntityManager entitymanger;
	
	//inject the entitymanger using contructor method
	@Autowired
	public EmployeeDAOHibernameImp(EntityManager theentitymanger ) { //this argument is pass by spring automatically
		entitymanger = theentitymanger;
	}
	
	
	@Override
	public List<Employee> findAll() {
		//get the current session
		Session currentsession = entitymanger.unwrap(Session.class);
		
		//create the query
		 Query<Employee>thequery = currentsession.createQuery("from Employee", Employee.class);
		 
		 List<Employee> employees = thequery.getResultList();
		 
		return employees;
	}


	@Override
	public Employee findbyId(int id) {
		Session session = entitymanger.unwrap(Session.class);
		Employee employ = session.get(Employee.class, id);
		
		return employ;
	}


	@Override
	public void save(Employee employee) {
		Session session = entitymanger.unwrap(Session.class);
		session.saveOrUpdate(employee);	
	}


	@Override
	public void deleteEmployee(int id) {
		Session session = entitymanger.unwrap(Session.class);
		Query<Employee>query = session.createQuery("delete from Employee where id = :employeid");
		query.setParameter("employeid", id);
		query.executeUpdate();
	}

}
