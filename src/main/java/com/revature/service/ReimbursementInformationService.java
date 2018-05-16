package com.revature.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.dao.R_InformationDAO;
import com.revature.daoImpl.R_InformationDaoImpl;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;

public class ReimbursementInformationService {
	private static final Logger logger = Logger.getLogger(ReimbursementInformationService.class);

	private static R_InformationDAO dao = new R_InformationDaoImpl();
	
	private ReimbursementInformationService() {}
	
	public static Reimbursement getInformation(Reimbursement rbmt) {
		return dao.getInformation(rbmt);
	}
	
	public static boolean newInformation(Reimbursement rbmt, File file ) {
		return dao.setInformation(rbmt, file);
	}
	
	public static boolean UpdateInformation(String status, int id) {
		return dao.UpdateInformation(status,id);
	}
	
	public static String Resolve(HttpServletRequest request,HttpServletResponse response) {
		String approve = request.getParameter("approve");
		String reject = request.getParameter("reject");
		int id = Integer.parseInt(request.getParameter("reimbursement"));
		Employee manager = (Employee) request.getSession().getAttribute("Employee");
		ReimbursementService.UpdateReimbursement(id, manager);
		String decision = (approve == null) ? reject : approve;
		ReimbursementInformationService.UpdateInformation(decision, id);
		logger.trace("Reimbursement resolved");
		if(request.getParameter("get") != null)
			return "/HTML/ViewEmployees.jsp";
		return "/HTML/FinancialManagerHome.jsp";
	}
}
