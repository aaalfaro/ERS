package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.EmployeeService;
import com.revature.service.InformationService;
import com.revature.service.ReimbursementInformationService;
import com.revature.service.ReimbursementService;

public class Dispatcher {
	
	private Dispatcher() {}
	
	
	public static String process(HttpServletRequest request,HttpServletResponse response) {
		switch(request.getRequestURI()) {
			case "/ERS/HTML/login.do":
				return EmployeeService.login(request, response);
			case "/ERS/HTML/update.do":
				return InformationService.update(request, response);
			case "/ERS/HTML/logout.do":
				return EmployeeService.logout(request, response);
			case "/ERS/HTML/new.do":
				return ReimbursementService.NewReimbursement(request, response);
			case "/ERS/HTML/resolve.do":
				return ReimbursementInformationService.Resolve(request, response);
			//I was assigning a value to a button and couldn't get its value without setting it as an attribute
			case "/ERS/HTML/getReim.do":
				response.setHeader("Cache-Control","no-cache, no-store, must-revalidate"); 
				response.addHeader("Cache-Control", "post-check=0, pre-check=0");
				response.setHeader("Pragma","no-cache"); 
				response.setDateHeader ("Expires", 0);
				
				request.getSession().setAttribute("get", request.getParameter("get"));
				return "/HTML/ViewEmployeeReimbursements.jsp";
			default:
				return "404.jsp";
		}
	}
}