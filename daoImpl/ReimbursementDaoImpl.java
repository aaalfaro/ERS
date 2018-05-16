package com.revature.daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDAO;
import com.revature.model.Employee;
import com.revature.model.Reimbursement;
import com.revature.utility.ConnectionUtility;

public class ReimbursementDaoImpl implements ReimbursementDAO {

	@Override
	public boolean setReimbursement(Employee emp) {
		ConnectionUtility.getInstance();
		String sql = "{CALL insert_reimbursement(?)}";
		int index = 0;
		try(Connection conn = ConnectionUtility.getConnection()){
			CallableStatement cs = conn.prepareCall(sql);
			cs.setInt(++index, emp.getId());
			int success = cs.executeUpdate();
			return success >0;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}return false;

	}

	
	
	public boolean UpdateReimbursement(int id, Employee emp) {
		ConnectionUtility.getInstance();
		String sql = "UPDATE reimbursement SET manager_id = ?, resolved = ? WHERE r_id = ?";
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
		int index = 0;
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(++index, emp.getId());
			stmt.setTimestamp(++index, date);
			stmt.setInt(++index, id);
			int success = stmt.executeUpdate();
			return success > 0;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}return false;
	}
	
	//Gets all reimbursements that belong to the employee including the reimbursement information by using an inner join and putting the results
	//in a list of reimbursement objects
	public List<Reimbursement> getEmployeeReimbursement(Employee emp){
		ConnectionUtility.getInstance();
		String sql = "SELECT reimbursement.r_id,reimbursement.recieved,reimbursement.resolved,reimbursement_info.amount, "
				+ "reimbursement_info.category,reimbursement_info.status FROM reimbursement INNER JOIN reimbursement_info"
				+ " ON reimbursement.r_id = reimbursement_info.r_id WHERE reimbursement.request_id =?";
		int index = 0;
		List<Reimbursement> reimbursements = new ArrayList<>();
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(++index, emp.getId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_id"),rs.getString("recieved"),rs.getString("resolved"),rs.getFloat("amount"),rs.getString("category")
						,rs.getString("status")));
			}
			return reimbursements;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}return null;
	}

	//Get all reimbursements except their own. Used by financial managers
	public List<Reimbursement> ManagerFetch(Employee emp) {
		ConnectionUtility.getInstance();
		List<Reimbursement> list = new ArrayList<>();
		String sql = "SELECT reimbursement.r_id,reimbursement.request_id,reimbursement.manager_id,reimbursement_info.amount,"
				+ "reimbursement_info.category,reimbursement.recieved,reimbursement.resolved,reimbursement_info.status, reimbursement_info.image FROM reimbursement INNER JOIN reimbursement_info"
				+ " ON reimbursement.r_id = reimbursement_info.r_id WHERE reimbursement.request_id != ?";
		int index = 0;
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(++index, emp.getId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Reimbursement(rs.getInt("r_id"),rs.getInt("request_id"),rs.getInt("manager_id"),rs.getFloat("amount"),
						rs.getString("recieved"),rs.getString("resolved"),rs.getString("category"),rs.getString("status"),rs.getBytes("image")));
			}
			return list;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
		return null;
	}


	//Manager gets a specific employees reimbursement requests
	@Override
	public List<Reimbursement> ManagerGetEmployee(int id) {
		ConnectionUtility.getInstance();
		List<Reimbursement> list = new ArrayList<>();
		String sql = "SELECT reimbursement.r_id,reimbursement.request_id,reimbursement.manager_id,reimbursement_info.amount,"
				+ "reimbursement_info.category,reimbursement.recieved,reimbursement.resolved,reimbursement_info.status, reimbursement_info.image FROM reimbursement INNER JOIN reimbursement_info"
				+ " ON reimbursement.r_id = reimbursement_info.r_id WHERE reimbursement.request_id = ?";
		int index = 0;
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(++index, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Reimbursement(rs.getInt("r_id"),rs.getInt("request_id"),rs.getInt("manager_id"),rs.getFloat("amount"),
						rs.getString("recieved"),rs.getString("resolved"),rs.getString("category"),rs.getString("status"),rs.getBytes("image")));
			}
			return list;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
		return null;
	}
}
