package com.czt.mytxt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	
	public static Connection getConnection(){
		
		Connection con =null;
		
		String url="jdbc:mysql://localhost:3306/crenative?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
		String user="root";
		String password="123456";
		try {
			con=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
