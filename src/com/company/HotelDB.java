
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
		String query = "SELECT * FROM customer;";
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		/*
		  	USE hotel;
			INSERT INTO customer (membership_id, checked_in, phone_number, address, notes, important_notes)
			VALUES ('54321', '0', '123-456-7890', '1234 fake st', 'allergic to soy', 'does not like armidillos');
		 */
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Customer cx;
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
		}
	}
	
}
