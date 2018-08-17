package com.img.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

	static Connection con=null;
	public static Connection createConnection() throws ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
		try {
		
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imgcomp","root","root");
			
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		return con;
		
	}
}
