package com.TestDBs1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBasetDAO {
	public static Connection con;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testSerStudent",
	    			"root",
	    			"Password@123");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static Connection getCon() {
		return con;
	}

}
