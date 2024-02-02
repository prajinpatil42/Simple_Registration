package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

	private static Connection conn;
	
	public static Connection getConnection(){
		
		try {
			
			if(conn == null) {
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage2","root","9860949212");
				return conn;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return conn;
	}
	
	
}
