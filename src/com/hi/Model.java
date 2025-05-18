package com.hi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Model {

	private String uname;
	private String uemail;
	private String upassword;
	private String ucity;
	private Connection con;
	private PreparedStatement state;
	
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUcity() {
		return ucity;
	}
	public void setUcity(String ucity) {
		this.ucity = ucity;
	}
	
	public int connect() {
		
		int status = 0;
		
		try {
			
			con = JdbcUtility.getConnection();
			String sql = "insert into jdbclearning.registrationapp values (?,?,?,?)";
			state = con.prepareStatement(sql);
			
			state.setString(1, getUname());
			state.setString(2, getUemail());
			state.setString(3, getUpassword());
			state.setString(4, getUcity());
			
			status = state.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtility.closeConnection(state, con);
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}
	
}
