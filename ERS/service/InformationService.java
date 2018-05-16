package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.InformationDAO;
import com.revature.daoImpl.InformationDaoImpl;
import com.revature.model.Employee;

public class InformationService {
	private static final Logger logger = Logger.getLogger(InformationService.class);

	private static InformationDAO dao = new InformationDaoImpl();
	
	private InformationService() {}
	
	public static Employee getInformation(Employee emp) {
		return dao.getInformation(emp);
	}
	
	public static boolean UpdateInformation(Employee emp) {
		return dao.setInformation(emp);
	}
	
	public static String update(HttpServletRequest request,HttpServletResponse response) {
		Employee user = (Employee) request.getSession().getAttribute("Employee");
		String first = request.getParameter("firstname");
		String last = request.getParameter("lastname");
		String telephone = request.getParameter("telephone");
		String address = request.getParameter("address");
		
		user.setFname((first == "") ? user.getFname() : first);
		user.setLname((last == "") ? user.getLname() : last);
		user.setPhone((telephone == "") ? user.getPhone() : telephone);
		user.setAddress((address == "") ? user.getAddress() : address);
		if(UpdateInformation(user)) {
			logger.trace("Information updated");
			request.getSession().setAttribute("Employee", user);
		}
		String page = (user.getTitle().equals("Financial Manager")) ? 
				"/HTML/ManagerInformation.jsp" : "/HTML/EmployeeInformation.jsp";
		return page;
	}
}
