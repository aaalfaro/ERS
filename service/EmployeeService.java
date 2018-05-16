package com.revature.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.EmployeeDAO;
import com.revature.daoImpl.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Factory;
import com.revature.utility.UrlFactory;

public class EmployeeService {
	private static final Logger logger = Logger.getLogger(EmployeeService.class);

	private static EmployeeDAO dao = new EmployeeDaoImpl();
	
	private EmployeeService() {}
	
	public static Employee getEmployee(String username) {
		return dao.getEmployee(username);
	}
	
	public static List<Employee> getEveryone(Employee emp){
		return dao.getAll(emp);
	}
	
	public static boolean check(Employee employee) {
		Employee temp = dao.getEmployee(employee.getUsername());
		if(temp == null)
			return false;
		if(temp.getPassword().equals(dao.getPasswordHash(employee))) {
			return true;
		}
		return false;
	}
	
	public static String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Employee temp = new Employee(username,password);
		if(check(temp)) {
			Employee user = Factory.confirm(getEmployee(username));
			user = InformationService.getInformation(user);
			request.getSession().setAttribute("Employee", user);
			logger.trace("Employee logged in");
			return UrlFactory.page(user);
		}
		logger.trace("Login failed");
		return "/HTML/GenericCorpIndex.html";
		
	}
	
	public static String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().removeAttribute("Employee");
		
		return "/HTML/GenericCorpIndex.html";
	}
	
}
