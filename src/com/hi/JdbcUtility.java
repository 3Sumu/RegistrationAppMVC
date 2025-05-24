package com.hi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUtility {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("Driver loaded");
	}
	
	public static Connection getConnection() throws SQLException {
		
		String url = "jdbc:mysql://127.0.0.1:3306/jdbclearning";
		String user = "root";
		String pass = "Sumansql@3";
		
		System.out.println("Connection established!");
		System.out.println("Adding for feature1 branch");
		System.out.println("Adding for feature2 branch");

			return DriverManager.getConnection(url, user, pass);
		
	}
	
	public static void closeConnection(PreparedStatement pre, Connection con) throws SQLException {
		
		if(pre != null)
			pre.close();
		
		if(con != null)
			con.close();
		
		System.out.println("Connection closed");
		
	}

}
