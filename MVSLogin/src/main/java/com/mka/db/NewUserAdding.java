package com.mka.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class NewUserAdding {
	
	

	private static final String INSERT_USERS_SQL = "insert into userlogin (username, password, email, otp) values(?,?,?,?)";

	public void userDetails(Map<String, String> map) throws ClassNotFoundException{
		// Step 1: Establishing a Connection
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Springmvc", "root", "root");
			 PreparedStatement preparedStatement = conn.prepareStatement(INSERT_USERS_SQL);
			 preparedStatement.setString(1, map.get("user-name"));
			 preparedStatement.setString(2, map.get("user-credentials"));
			 preparedStatement.setString(3, map.get("user-email"));
			 preparedStatement.setString(4, map.get("otp"));

		 System.out.println(preparedStatement);
		 // Step 3: Execute the query or update query
		 preparedStatement.executeUpdate();
		} catch (SQLException e) {
		 e.printStackTrace();
		}
	}

}
