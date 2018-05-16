package com.revature.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtility {
	//Connection Singleton
	
	private static ConnectionUtility instance;
	private static Connection connection;
	
	private ConnectionUtility()  {
		InputStream in = null;
		Properties p = new Properties();
		try {
			in = ConnectionUtility.class.getClassLoader().getResourceAsStream("db.properties");
			p.load(in);
			Class.forName("oracle.jdbc.OracleDriver");
			ConnectionUtility.connection = DriverManager.getConnection(p.getProperty("jdbc.url"),p.getProperty("jdbc.username"),p.getProperty("jdbc.secret"));
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: "+ sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
		
	public static ConnectionUtility getInstance() {
		try {
			if(instance == null) {
				instance = new ConnectionUtility();
			}
			else if (ConnectionUtility.getConnection().isClosed()) {
				instance = new ConnectionUtility();
			}
		}catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: "+ sqle.getSQLState());
			System.err.println("Error Code: "+sqle.getErrorCode());
		}
			return instance;
	}
	
	public static Connection getConnection(){
		return connection;
	}
	
}
