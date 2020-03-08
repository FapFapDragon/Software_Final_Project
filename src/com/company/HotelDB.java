package com.company;
import java.sql.*;  

//All functions to pull information from database,
public class HotelDB {
	String url = "jdbc:mysql://216.26.210.157:3306/hotel?useSSL=false";
	private final String user = "access";
	private final String pass = "root";
	private final int port = 3306;
	
	private Connection con;
	
	public void createConnection() {
		
	
	}
	
	public void getCustomer(int ID, String address, int phonenumber) {
		// This will load the MySQL driver, each DB has its own driver
		con = null;
		try {
		    con = DriverManager.getConnection("jdbc:mysql://216.26.210.157/hotel?", user, pass);
		    
		    // Do something with the Connection

		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	
}
