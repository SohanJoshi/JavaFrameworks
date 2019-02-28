package com.spring.hibernate.dao;

import java.util.List;

import com.spring.hibernate.model.Employee;

public interface EmployeeDao {

	Employee findById(int id);
	
	void saveEmployee(Employee employee) ;
	
	void deleteEmployeeBySsn(String ssn);
	
	List<Employee> findAllEmployee();
	
	Employee findEmployeeBySsn(String ssn);
}
