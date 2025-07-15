package com.tap.dd;
import java.sql.*;

public class DBconnect {
	
	 static Connection con;

	public static Connection dbCon() {
		String url = "jdbc:mysql://localhost:3306/food";
		String user = "root";
		String pwd = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,user,pwd);

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
		
	}
}
