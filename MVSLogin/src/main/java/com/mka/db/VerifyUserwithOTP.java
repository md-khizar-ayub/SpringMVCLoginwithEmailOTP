package com.mka.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class VerifyUserwithOTP {
	private static final String GET_USERS = "select * from userlogin where otp = ";

	public static boolean verifyUser(String otp) throws ClassNotFoundException{
		// Step 1: Establishing a Connection
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Springmvc", "root", "root");
			java.sql.Statement stmt =  conn.createStatement();
			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(GET_USERS+Integer.parseInt(otp));
			int dbOtp =000000;
			while (rs.next()) {
				dbOtp = rs.getInt("otp");
				}
		 if(dbOtp != 000000) {
			 return otp.equals(String.valueOf(dbOtp));
		 }else {
			 return false;
		 }
		} catch (SQLException e) {
		 e.printStackTrace();
		}
		return false;
	}
}
