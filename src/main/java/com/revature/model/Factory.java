package com.revature.model;

public class Factory {
	
	
	public static Employee confirm(Employee emp) {
		switch(emp.getTitle()) {
		case "Financial Manager":
			return new FinancialManager(emp.getId(),emp.getTitle(),emp.getUsername(),emp.getPassword());
		default:
			return new OtherEmployee(emp.getId(),emp.getTitle(),emp.getUsername(),emp.getPassword());
		}
	}

}
