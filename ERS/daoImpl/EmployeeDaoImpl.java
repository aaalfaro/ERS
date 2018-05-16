package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDAO;
import com.revature.model.Employee;
import com.revature.utility.ConnectionUtility;

public class EmployeeDaoImpl implements EmployeeDAO {

	@Override
	public Employee getEmployee(String username) {
		ConnectionUtility.getInstance();
		String sql = "SELECT * FROM employee WHERE username = ?";
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return new Employee(rs.getInt("e_id"),rs.getString("title"),rs.getString("username"),rs.getString("password"));
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public String getPasswordHash(Employee e) {
		ConnectionUtility.getInstance();
		int index = 0;
		String sql = "SELECT get_employee_hash(?,?) AS HASH FROM dual";
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(++index, e.getUsername());
			stmt.setString(++index, e.getPassword());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getString("HASH");
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Employee> getAll(Employee emp) {
		ConnectionUtility.getInstance();
		String sql = "SELECT employee.e_id,employee.title,information.f_name,information.l_name, information.telephone,information.address"
				+ " FROM employee INNER JOIN information ON employee.e_id = information.e_id WHERE employee.e_id != ?";
		int index = 0;
		List<Employee> list = new ArrayList<>();
		try(Connection conn = ConnectionUtility.getConnection()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(++index, emp.getId());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getInt("e_id"),rs.getString("title"),rs.getString("f_name"),rs.getString("l_name"),rs.getString("telephone"),rs.getString("address")));
			}return list;
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE: "+sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
		return null;
	}

}
