	package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Employee;
import com.revature.service.EmployeeService;
import com.revature.service.ReimbursementService;


public class AjaxDispatcher {
	private AjaxDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		Employee emp = (Employee) request.getSession().getAttribute("Employee");
		switch(request.getRequestURI()) {
			case "/ERS/getMyReimbursement.ajax":
				return ReimbursementService.getMyReimbursements(emp);
			case "/ERS/FinancialManagerList.ajax":
				return ReimbursementService.getAllReimbursements(emp);
			case "/ERS/getEmployees.ajax":
				return EmployeeService.getEveryone(emp);
			case "/ERS/ManagerGetReimbursement.ajax":
				int id = Integer.parseInt(request.getParameter("get"));
				System.out.println(id);
				return ReimbursementService.getEmployeesReimbursement(id);
			default:
				return new String ("Not Implemented");
		}
	}
}
