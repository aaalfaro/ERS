package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.dao.InformationDAO;
import com.revature.model.Employee;
import com.revature.utility.ConnectionUtility;

public class InformationDaoImpl implements InformationDAO {
	
	@Override
	public Employee getInformation(Employee emp) {
		ConnectionUtility.getInstance();
		String sql = "SELECT * FROM information WHERE e_id = ?";
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, emp.getId());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				emp.setFname(rs.getString("f_name"));
				emp.setLname(rs.getString("l_name"));
				emp.setPhone(rs.getString("telephone"));
				emp.setAddress(rs.getString("address"));
			}
			return emp;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean setInformation(Employee employee) {
		ConnectionUtility.getInstance();
		String sql = "UPDATE information SET f_name=? , l_name=? , telephone=?, address=? WHERE e_id=?";
		int index = 0;
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(++index, employee.getFname());
			stmt.setString(++index, employee.getLname());
			stmt.setString(++index, employee.getPhone());
			stmt.setString(++index, employee.getAddress());
			stmt.setInt(++index, employee.getId());
			int success = stmt.executeUpdate();
			return success > 0;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}return false;
	}

}
