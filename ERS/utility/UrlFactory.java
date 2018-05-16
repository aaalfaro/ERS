package com.revature.utility;

import com.revature.model.Employee;

public class UrlFactory {

	
	public static String page(Employee employee) {
		switch(employee.getTitle()) {
			case "Financial Manager":
				return "/HTML/FinancialManagerHome.jsp";
			default:
				return "/HTML/GenericEmployeeHomePage.jsp";
		}
		
	}
	
}
