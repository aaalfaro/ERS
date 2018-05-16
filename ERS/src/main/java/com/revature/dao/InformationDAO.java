package com.revature.dao;

import com.revature.model.Employee;

public interface InformationDAO {
	Employee getInformation(Employee emp);
	boolean setInformation(Employee employee);
}
