package com.revature.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.dao.R_InformationDAO;
import com.revature.model.Reimbursement;
import com.revature.utility.ConnectionUtility;

public class R_InformationDaoImpl implements R_InformationDAO {
	private static final Logger logger = Logger.getLogger(R_InformationDaoImpl.class);

	//Add file input stream and size of file to method signature here and update stored procedure to take in a blob datatype
	@Override
	public boolean setInformation(Reimbursement reimbursement,File file) {
		ConnectionUtility.getInstance();
		String sql = "{CALL insert_r_info(?,?,?)}";
		int index = 0;
		int len = (int)file.length();
		try(Connection conn = ConnectionUtility.getConnection()){
			FileInputStream image = new FileInputStream(file);
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(++index, reimbursement.getCategory());
			cs.setFloat(++index, reimbursement.getAmount());
			cs.setBinaryStream(++index, image,len);
			int success = cs.executeUpdate();
			return success > 0;
		}catch(FileNotFoundException fnfe) {
			fnfe.getMessage();
			logger.warn("File does not exist");
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Reimbursement getInformation(Reimbursement reimbursement) {
		ConnectionUtility.getInstance();
		String sql = "SELECT category,status FROM reimbursement_info WHERE r_id =?";
		int index = 0;
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(++index, reimbursement.getId());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				reimbursement.setCategory(rs.getString("category"));
				reimbursement.setStatus(rs.getString("status"));
			}
			return reimbursement;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
		return null;
	}
	
	public boolean UpdateInformation(String status,int id) {
		ConnectionUtility.getInstance();
		String sql = "UPDATE reimbursement_info SET status = ? WHERE r_id = ?";
		int index = 0;
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(++index, status);
			stmt.setInt(++index, id);
			int success = stmt.executeUpdate();
			logger.trace("Status updated");
			return success > 0;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}return false;
	}


}
