
package com.company;
import java.sql.*;  

//All functions to pull information from database,
public class HotelDB {
	private static String url = "jdbc:mysql://216.26.210.157:3306/hotel?useSSL=false";
	private static final String user = "access";
	private static final String pass = "root";
	private static final int port = 3306;

	private static Connection con;
	
	public static boolean createConnection() {
		
		// This will load the MySQL driver, each DB has its own driver
		try {
			con = DriverManager.getConnection(url, user, pass);
            
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return false;
		}		
		return true;
	}
	
	public static void getCustomer(int ID, String address, long phonenumber) {
		String query = "SELECT VERSION()";
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                
                System.out.println(rs.getString(1));
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
		}
	}
	
}
