package com.spring.hibernate.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate.dao.EmployeeDao;
import com.spring.hibernate.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;

	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	public void saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		Employee entity = employeeDao.findById(employee.getId());
		if(entity != null)
		{
			entity.setName(employee.getName());
			entity.setJoiningDate(employee.getJoiningDate());
			entity.setSalary(employee.getSalary());
			entity.setSsn(employee.getSsn());
		}
		
	}

	public void deleteEmployeeBySsn(String ssn) {
		employeeDao.deleteEmployeeBySsn(ssn);
	}

	public List<Employee> findAllEmployees() {
		return employeeDao.findAllEmployee();
	}

	public Employee findEmployeeBySsn(String ssn) {
		return employeeDao.findEmployeeBySsn(ssn);
	}

	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		Employee employee = employeeDao.findEmployeeBySsn(ssn);
		return (employee == null) || ((id != null ) && (employee.getId() == id));
	}

}
