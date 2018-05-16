package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;
//DAO for the employee table
public interface EmployeeDAO {
	Employee getEmployee(String username);
	String getPasswordHash(Employee e);
	List<Employee> getAll(Employee emp);
}
