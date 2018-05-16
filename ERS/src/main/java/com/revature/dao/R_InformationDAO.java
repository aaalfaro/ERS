package com.revature.dao;

import java.io.File;

import com.revature.model.Reimbursement;
public interface R_InformationDAO {
	boolean setInformation(Reimbursement reimbursement, File image);
	Reimbursement getInformation(Reimbursement r);
	boolean UpdateInformation(String status, int id);
}
