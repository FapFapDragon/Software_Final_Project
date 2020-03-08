package com.company;
import java.sql.*;  

//All functions to pull information from database,
public class HotelDB {
	String url = "jdbc:mysql://216.26.210.157:3306/hotel?useSSL=false";
	private final String ID = "access";
	private final String pass = "root";
	private final int port = 3306;
	
	private Connection con;
	
	public void createConnection() {
		
		try (con = DriverManager.getConnection(url, user, password);
	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(query)) {

	            if (rs.next()) {
	                
	                System.out.println(rs.getString(1));
	            }

	        } catch (SQLException ex) {
	            
	            Logger lgr = Logger.getLogger(JdbcMySQLVersion.class.getName());
	            lgr.log(Level.SEVERE, ex.getMessage(), ex);
	        } 
	 
	}
	
	public void getCustomer(int ID, String address, int phonenumber) {
		// This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?" + "user=sqluser&password=sqluserpw");
	}
	
}
