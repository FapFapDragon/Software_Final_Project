package com.company;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;  
import com.company.Enums.*;

//All functions to pull information from database,
public class HotelDB {
	private static String url = "jdbc:mysql://38.39.89.83:3306/hotel?useSSL=false";	//URL of database being connected to
	private static final String user = "access";	//username to connect to DB
	private static final String pass = "root";		//DB password

	private static Connection con;	//Variable which holds the connection
	
	//All functions are Static because this is a utility to connect to the DB rather than an actual object
	
	//----------------------------------Connection---------------------------------------------------//
	
	//Attempt to connect to the SQL SERVER 
	public static boolean createConnection() {
		
		// This will load the MySQL driver, each DB has its own driver 
		//Attempt to connect to MYSQL Database, if you cannot connect, throw error
		try {
			con = DriverManager.getConnection(url, user, pass); 
		}
		catch (Exception e) {
				//Return false and show error
				System.out.println("Oh No");
				e.printStackTrace();
				return false;
		}		
		return true;
	}
	//----------------------------------Room---------------------------------------------------//
	
	public static Room getRoom(int ID, Size size, View view, int floor, State state) {
		//Select * where ID is not null will return all results alone
		String query = "SELECT * FROM hotel.room WHERE id IS NOT NULL";
		
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ID != 0) {query = query + " AND id = " + String.valueOf(ID);}	
		if (size != null) {query = query + " AND size = " + size.name();}
		if (view != null) {query = query + " AND view = " + view.name();}
		if (floor != 0) {query = query + " AND floor = " + String.valueOf(floor);}
		if (state != null) {query = query + " AND state = " + state.name();}
		
		query = query +  ";";
		
		//If a connection cannot be created, let user know
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		
		//Attempt to retrieve class from database
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Room room = null;
            if (rs.next()) {	//If there was a result
                //Store DB variables in local variables
            	int roomID = rs.getInt(0);
                int beds = rs.getInt(1);
                Size s = Size.valueOf(rs.getString(2));
                View v = View.valueOf(rs.getString(3));
                State ste = State.valueOf(rs.getString(4));
                int fl = rs.getInt(5);
                int booking_id = rs.getInt(6);
                
                //Create and initalize Local Room object from DB Room table
                room = new Room(roomID, beds, s, v, fl);
                room.setState(ste);
                Booking b = getRoomBooking(booking_id);
                b.setRoom(room);
                room.setBooking(b);
                
                //Return the found Room as Java Room object
                return room;
            }
            else {
            	//If no results found Inform user and return nothing
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {	//On exceptions, print exception, return null
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}	
	
	public static ArrayList<Room> getRooms(int ID, Size size, View view, int floor, State state) {
		//Select * where ID is not null will return all results alone
		String query = "SELECT * FROM hotel.room WHERE id IS NOT NULL";
		
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ID != 0) {query = query + " AND id = " + String.valueOf(ID);}	
		if (size != null) {query = query + " AND size = " + size.name();}
		if (view != null) {query = query + " AND view = " + view.name();}
		if (floor != 0) {query = query + " AND floor = " + String.valueOf(floor);}
		if (state != null) {query = query + " AND state = " + state.name();}
		
		query = query +  ";";
		
		//If a connection cannot be created, let user know
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		//Attempt to retrieve class from database
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Room> rooms = new ArrayList<Room>();
            while (rs.next()) {		//Loop through all results
                //Store DB variables in local variables
                int roomID = rs.getInt(0);
                int beds = rs.getInt(1);
                Size s = Size.valueOf(rs.getString(2));
                View v = View.valueOf(rs.getString(3));
                State ste = State.valueOf(rs.getString(4));
                int fl = rs.getInt(5);
                int booking_id = rs.getInt(6);
                Room room = new Room(roomID, beds, s, v, fl);
                //Create and initalize Local Room object from DB Room table
                room.setState(ste);
                Booking b = getRoomBooking(booking_id);
                b.setRoom(room);
                room.setBooking(b);
                
                //Add room to list
                rooms.add(room);
            }
            return rooms;
		}
		catch (Exception e) {	//If exception occurs, print exception and return null
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}	
	
	public static int createRooms(int ID, int beds, Size size, View view, int floor, State state) {
		String query = "USE hotel;\n INSERT INTO room VALUES (";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		query = query + "'" + String.valueOf(ID) + "', ";
		query = query + "'" + String.valueOf(beds) + "', ";
		query = query + "'" + size.name() + "'";
		query = query + "'" + view.name() + "'";
		query = query + "'" + state.name() + "'";
		query = query + "'" + String.valueOf(floor) + "'";
		query = query + ");";
		
		//Attempt to create connection to DB, if fails inform user
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {	//Attempt to insert room
    		Statement st = con.createStatement();
    		System.out.println(query);
            st.executeUpdate(query);
		}
		catch (Exception e) {	//If issues occur print exception and return -1;
			   System.out.println("Oh No");
			   e.printStackTrace();
			   return -1;
		}
        return 0;	//return 0 on success
	}
	//----------------------------------Customer---------------------------------------------------//
	
	public static Customer getCustomer(int ID, String address, long phonenumber, int bookingID) {
		//Select * where ID is not null will return all results alone
		String query = "SELECT * FROM hotel.customer WHERE id IS NOT NULL";
		
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ID != 0) {query = query + " AND id = " + String.valueOf(ID);}	
		if (address != null) {query = query + " AND address = '" + address + "'";}
		if (phonenumber != 0) {query = query + " AND phone_number = " + String.valueOf(phonenumber);}
		if (bookingID != 0) {query = query + " AND booking_id = " + String.valueOf(bookingID);}
		query = query +  ";";
		
		//Attempt to create Connection to DB, notify user if connection fails
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		
		//Attempt to retrieve results based on query
        try {
        	//use connection to execute the SQL Query
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            Customer cx = null;
            if (rs.next()) {	//If results exist 
            	//Create and initialize Customer using retrieved information from DB
                cx = new Customer(rs.getInt(1), rs.getLong(5), rs.getString(6));
                cx.addMembership(null);// If memberships are added in the future, this will be changed to retrieve a membership
                Booking b = getCustomerBooking(rs.getInt(1));
                
                if (b != null) {
                	b.setClient(cx);
                }
                cx.setBooking(b);//get the booking information
                
                			
                return cx;	//return the client
            }
            else {	//If no results returned, inform user and return Null;
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	public static  ArrayList<Customer> getCustomers(int ID, String address, long phonenumber, int bookingID) {
		String query = "SELECT * FROM hotel.customer WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ID != 0) {query = query + " AND id = " + String.valueOf(ID);}	
		if (address != null) {query = query + " AND address = '" + address + "'";}
		if (phonenumber != 0) {query = query + " AND phone_number = " + String.valueOf(phonenumber);}
		if (bookingID != 0) {query = query + " AND booking_id = " + String.valueOf(bookingID);}
		query = query +  ";";
		
		System.out.println(query);
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Customer> customers = new ArrayList<Customer>();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
                Customer cx = new Customer(rs.getInt(1), rs.getLong(5), rs.getString(6));
                cx.addMembership(null);// If memberships are added in the future, this will be changed to retrieve a membership
                Booking b = getCustomerBooking(rs.getInt(1));
                
                if (b != null) {
                	b.setClient(cx);
                }
                cx.setBooking(b);//get the booking information
                customers.add(cx);
            }
            return customers;
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	private static Customer getBookingCustomer(int ID) {
		//Same as regular customer however only used locally to retrieve customer from DB
		
		String query = "SELECT * FROM hotel.customer WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ID != 0) {query = query + " AND id = " + String.valueOf(ID);}	
		query = query +  ";";
		
		System.out.println(query);
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
	
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Customer cx = null;
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
                cx = new Customer(rs.getInt(1), rs.getLong(5), rs.getString(6));
                cx.addMembership(null);// If memberships are added in the future, this will be changed to retrieve a membership
                return cx;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	public static int createCustomer(int ID, int checkedIn, int booking_id, long phone , String address, String notes, String important_notes, int ticketID) {
		//Insert or Update customer in SQL customer
		String query = "USE hotel;\n INSERT INTO customer VALUES (";
		
		//Build query based on passed information
		query = query + "'" + String.valueOf(ID) + "', ";
		query = query + "'" + String.valueOf(0) + "', ";
		query = query + "'" + String.valueOf(checkedIn) + "'";
		query = query + "'" + String.valueOf(booking_id) + "'";
		query = query + "'" + String.valueOf(phone) + "'";
		query = query + "'" + address + "'";
		query = query + "'" + notes + "'";
		query = query + "'" + important_notes + "'";
		query = query + "'" + String.valueOf(ticketID) + "'";
		query = query + ");";
		
		//If connection is not created Notify user
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		//Attempt to insert into DB
        try {
    		Statement st = con.createStatement();
    		System.out.println(query);
            st.executeUpdate(query);
		}
		catch (Exception e) {	//If user cannot be inserted in DB print error and return -1
			   System.out.println("Oh No");	
			   e.printStackTrace();
			   return -1;
		}
        return 0; //return 0 on success
	}

	//----------------------------------Bookings---------------------------------------------------//
	static public Booking getBooking(int clientID, int roomID, Date checkInDate, Date checkOutDate) {
		
		//Add date format to convert to sql date
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		
		//Build Query
		String query = "SELECT * FROM hotel.booking WHERE customer_id IS NOT NULL";	
		if (clientID != 0) {query = query + " AND customer_id = " + String.valueOf(clientID);}	
		if (roomID != 0) {query = query + " AND room_id = " + String.valueOf(roomID);}
		//Convert date to sql date format and add to query
		if (checkInDate != null) {
			String currentTime = sdf.format(checkInDate);
			query = query + " AND checkin_date = '" + String.valueOf(currentTime) + "'";
		}
		//Convert date to sql date format and add to query
		if (checkOutDate != null) {
			String currentTime = sdf.format(checkOutDate);
			query = query + " AND checkout_date = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");	//If connection cannot be created, will throw error
		}
		try {
			//use connection to execute query
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Booking book = null;
            
            if (rs.next()) { //If results are found
            	//Store DB variables in local variables
            	int CID = rs.getInt(1);
            	int RID = rs.getInt(2);
            	String CIDate = rs.getString(3);
            	Date in = sdf.parse(CIDate);
            	String CODate = rs.getString(4);
            	Date out = sdf.parse(CODate);
            	
            	//Get Customer, Get Room then Return complete Booking
            	Customer c = getBookingCustomer(CID);
            	Room r = getRoom(RID, null, null, 0, null);
            	book = new Booking(c, r, in, out);
            	c.setBooking(book);
            	book.setClient(c);
                return book;
            }
            else {	//If no results found, inform user and return null
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	static public ArrayList<Booking> getBookings(int clientID, int roomID, Date checkInDate, Date checkOutDate) {
		//Same as Bookings however returns all results not just first result
		//Add date format to convert to sql date
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//Build query 
		String query = "SELECT * FROM hotel.booking WHERE customer_id IS NOT NULL";
		if (clientID != 0) {query = query + " AND customer_id = " + String.valueOf(clientID);}	
		if (roomID != 0) {query = query + " AND room_id = " + String.valueOf(roomID);}
		if (checkInDate != null) {
			
			String currentTime = sdf.format(checkInDate);
			query = query + " AND checkin_date = '" + String.valueOf(currentTime) + "'";
		}
		if (checkOutDate != null) {
			String currentTime = sdf.format(checkOutDate);
			query = query + " AND checkout_date = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		//inform user if connection cannot be created
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		try {
			//Attempt to execute query using connection
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Booking> bookings= new ArrayList<Booking>();
            
            //loop through all results
            while (rs.next()) {
            	//Store DB variables in local Variables
            	int CID = rs.getInt(1);
            	int RID = rs.getInt(2);
            	String CIDate = rs.getString(3);
            	Date in = sdf.parse(CIDate);
            	String CODate = rs.getString(4);
            	Date out = sdf.parse(CODate);
            	
            	//Get Customer, Get Room then Return complete Booking
            	Customer c = getBookingCustomer(CID);
            	Room r = getRoom(RID, null, null, 0, null);
            	Booking book = new Booking(c, r, in, out);
            	c.setBooking(book);
            	book.setClient(c);
                bookings.add(book);
            }
            return bookings;	//Return array list of bookings
		}
		catch (Exception e) {	//If exception occurs, return false
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	static private Booking getCustomerBooking(int clientID) {
		//Special case of get booking, only used locally
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.booking WHERE customer_id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (clientID != 0) {query = query + " AND customer_id = " + String.valueOf(clientID);}	
		query = query +  ";";
		
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Booking book = null;
            if (rs.next()) {
            	int RID = rs.getInt(2);
            	String CIDate = rs.getString(3);
            	Date in = sdf.parse(CIDate);
            	String CODate = rs.getString(4);
            	Date out = sdf.parse(CODate);
            	//Since it's a customer booking set customer to null, get room and return
            	Customer c = null;
            	Room r = getRoom(RID, null, null, 0, null);
            	book = new Booking(c, r, in, out);
                return book;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	static private Booking getRoomBooking(int booking_id) {
		//Special case of booking only used locally
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.booking WHERE customer_id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (booking_id != 0) {query = query + " AND booking_id = " + String.valueOf(booking_id);}	
		query = query +  ";";
		
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Booking book = null;
            if (rs.next()) {
            	String CIDate = rs.getString(3);
            	Date in = sdf.parse(CIDate);
            	String CODate = rs.getString(4);
            	Date out = sdf.parse(CODate);
            	//Since it's a customer booking set customer to null, get room and return
            	Customer c = null;
            	Room r = null;						//REMEMBER TO CHANGE THIS TO GET ROOM
            	book = new Booking(c, r, in, out);
                return book;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	public static int createBooking(int ID, int customerID, int roomID, Date in, Date out) {
		//Add date parser to convert java Date into MySQL date format
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//Insert into hotel booking table
		String query = "USE hotel;\n INSERT INTO booking VALUES (";
		
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		query = query + "'" + String.valueOf(ID) + "', ";
		query = query + "'" + String.valueOf(customerID) + "', ";
		query = query + "'" + String.valueOf(roomID) + "'";
		String inDate = sdf.format(in);
		query = query + "'" + String.valueOf(inDate) + "'";
		String outDate = sdf.format(out);
		query = query + "'" + String.valueOf(outDate) + "'";
		query = query + ");";
		
		//If connection cannot be created inform user
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
        	//Attempt to execute insert statement
    		Statement st = con.createStatement();
    		System.out.println(query);
            st.executeUpdate(query);
		}
		catch (Exception e) {	//If error occurs, print exception and return -1
			   System.out.println("Oh No");
			   e.printStackTrace();
			   return -1;
		}
        return 0;	//return 0 on success
	}

	//----------------------------------Shift---------------------------------------------------//
	static public Shift getShift(String employeeID, Date day, float time) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.shift WHERE employee_id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (employeeID != null) {query = query + " AND employee_id = '" + employeeID + "'";}	
		if (time != 0) {query = query + " AND time = " + String.valueOf(time);}
		if (day != null) {	
			String currentTime = sdf.format(day);
			query = query + " AND date = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Shift shift = null;
            if (rs.next()) {
             	String UID = rs.getString(0);
            	String CIDate = rs.getString(1);
            	float thyme = rs.getInt(2);
            	Date SHDate = sdf.parse(CIDate);
            	shift = new Shift( UID, SHDate, thyme);
                return shift;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	static public ArrayList<Shift> getShifts(String employeeID, Date day, float time) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.shift WHERE employee_id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (employeeID != null) {query = query + " AND employee_id = '" + employeeID + "'";}	
		if (time != 0) {query = query + " AND time = " + String.valueOf(time);}
		if (day != null) {	
			String currentTime = sdf.format(day);
			query = query + " AND date = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Shift> shifts = new  ArrayList<Shift>();
            while (rs.next()) {
             	String UID = rs.getString(0);
            	String CIDate = rs.getString(1);
            	float thyme = rs.getInt(2);
            	Date SHDate = sdf.parse(CIDate);
            	Shift shift = new Shift( UID, SHDate, thyme);
                shifts.add(shift);
            }
            return shifts;
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	public static int createBooking(int ID, Date day, float time, int changed) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "USE hotel;\n INSERT INTO booking VALUES (";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		query = query + "'" + String.valueOf(ID) + "', ";
		String inDate = sdf.format(time);
		query = query + "'" + String.valueOf(inDate) + "'";
		query = query + "'" + String.valueOf(changed) + "', ";
		query = query + ");";
		System.out.println(query);
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
    		Statement st = con.createStatement();
    		System.out.println(query);
            st.executeUpdate(query);
		}
		catch (Exception e) {
			   System.out.println("Oh No");
			   e.printStackTrace();
			   return -1;
		}
        return -1;
	}
	
	//----------------------------------Wake_up---------------------------------------------------//
	static public WakeUpTimer getWakeUp(int id, Date time) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.wake_up WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (id != 0) {query = query + " AND id = " + String.valueOf(id);}
		if (time != null) {	
			String currentTime = sdf.format(time);
			query = query + " AND date = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            WakeUpTimer timer = null;
            if (rs.next()) {
             
            	int ID = rs.getInt(0);
            	String CIDate = rs.getString(1);
            	Date SHDate = sdf.parse(CIDate);
            	timer = new WakeUpTimer( ID, SHDate);
                return timer;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	//----------------------------------Get RoomService Ticket---------------------------------------------------//
	public static RoomServiceTicket getRoomServiceTicket(int ticketID, int roomID, Date openTime) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.room_service_ticket WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ticketID != 0) {query = query + " AND id = " + String.valueOf(ticketID);}	
		if (roomID != 0) {query = query + " AND room_id = " + String.valueOf(roomID);}	
		if (openTime != null) {	
			String currentTime = sdf.format(openTime);
			query = query + " AND open_time = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		System.out.println(query);
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            RoomServiceTicket tckt = null;
            if (rs.next()) {
                //Store from DB in local variables
            	int RID = rs.getInt(1);
            	
            	String openT = rs.getString(1);
            	Date dateOpen = sdf.parse(openT);
            	
            	String reqT = rs.getString(5);
            	Date dateReq = sdf.parse(reqT);
            	
            	String desc = rs.getString(6);
            	String specReq = rs.getString(7);
            	
            	tckt = new RoomServiceTicket(RID, dateOpen, dateReq, desc, specReq);
                return tckt;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	//----------------------------------Get Maintenance Ticket---------------------------------------------------//
	public static MaintenanceTicket getMaintenanceTicket(int ticketID, int roomID, Date openTime) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.maintenance_ticket WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ticketID != 0) {query = query + " AND id = " + String.valueOf(ticketID);}	
		if (roomID != 0) {query = query + " AND room_id = " + String.valueOf(roomID);}	
		if (openTime != null) {	
			String currentTime = sdf.format(openTime);
			query = query + " AND open_time = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            MaintenanceTicket tckt = null;
            if (rs.next()) {
                //Store from DB in local variables
            	int RID = rs.getInt(1);
            	String openT = rs.getString(2);
            	Date dateOpen = sdf.parse(openT);
            	int comp = rs.getInt(3);
            	String desc = rs.getString(4);
            	
            	tckt = new MaintenanceTicket(desc, RID, dateOpen, (comp != 0) );
                return tckt;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	//----------------------------------Get cleaning Ticket---------------------------------------------------//
	public static CleaningTicket getCleaningTicket(int ticketID, int roomID, Date openTime) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.cleaning_ticket WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ticketID != 0) {query = query + " AND id = " + String.valueOf(ticketID);}	
		if (roomID != 0) {query = query + " AND room_id = " + String.valueOf(roomID);}	
		if (openTime != null) {	
			String currentTime = sdf.format(openTime);
			query = query + " AND open_time = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            CleaningTicket tckt = null;
            if (rs.next()) {
                //Store from DB in local variables
            	int RID = rs.getInt(1);
            	String openT = rs.getString(2);
            	Date dateOpen = sdf.parse(openT);
            	int comp = rs.getInt(3);
            	String desc = rs.getString(4);
            	
            	tckt = new CleaningTicket(desc, RID, dateOpen, (comp != 0) );
                return tckt;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	//----------------------------------Get complaint Ticket---------------------------------------------------//
	public static ComplaintTicket getComplaintTicket(int ticketID, int roomID, Date openTime) {
		//Add date parser to convert java Date into MySQL date format
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.complaint_ticket WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ticketID != 0) {query = query + " AND id = " + String.valueOf(ticketID);}	
		if (roomID != 0) {query = query + " AND room_id = " + String.valueOf(roomID);}	
		if (openTime != null) {	
			String currentTime = sdf.format(openTime);
			query = query + " AND open_time = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ComplaintTicket tckt = null;
            if (rs.next()) {
                //Store from DB in local variables
            	int RID = rs.getInt(1);
            	String openT = rs.getString(2);
            	Date dateOpen = sdf.parse(openT);
            	int comp = rs.getInt(3);
            	String desc = rs.getString(4);
            	
            	tckt = new ComplaintTicket(desc, RID, dateOpen, (comp != 0) );
                return tckt;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	//----------------------------------Get Order Request---------------------------------------------------//
	public static ArrayList<OrderRequest> getOrderRequest(String reqID, int complete, int denied, Date openTime) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String query = "SELECT * FROM hotel.order_request WHERE requester_id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (reqID != null) {query = query + " AND requester_id = '" + reqID + "'";}	
		if (complete != -1) {query = query + " AND complete = " + String.valueOf(complete);}	
		if (denied != -1) {query = query + " AND denied = " + String.valueOf(denied);}	
		if (openTime != null) {	
			String currentTime = sdf.format(openTime);
			query = query + " AND open_time = '" + String.valueOf(currentTime) + "'";
		}
		query = query +  ";";
		
		System.out.println(query);
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		ArrayList<OrderRequest> orders = new ArrayList<OrderRequest>();
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while (rs.next()) {
                //System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
            	//Store from DB in local variables
            	String RID = rs.getString(0);
            	String item = rs.getString(1);
            	int quan = rs.getInt(2);
            	
            	String openT = rs.getString(2);
            	Date dateOpen = sdf.parse(openT);
            	int comp = rs.getInt(3);
            	int den = rs.getInt(4);
            	
            	
            	orders.add(new OrderRequest(RID, item, quan, dateOpen, (comp != 0),  (den != 0) ));
            }
            return orders;
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	//----------------------------------Get Employee---------------------------------------------------//
	public static Employee getEmployee(String ID, PermissionType permission) {
		//Using hotelDB employee 
		String query = "SELECT * FROM hotel.employee WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first Employee which matches the description
		if (ID != null) {query = query + " AND id = '" + ID +"'";}
		if (permission != null) {query = query + " AND permission_level = " + permission.name();}
		query = query +  ";";
		
		//If connection cannot be created, will throw error
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
        	//Attempt to execute statement using connection
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Employee emp = null;
            
            if (rs.next()) {
                //Store from DB in local variables
            	String name	 = rs.getString(2);
            	String role	 = rs.getString(4);
            	PermissionType perm = PermissionType.valueOf(rs.getString(1));
            	Float wage = rs.getFloat(3);
            	
            	emp = new DeskAttendant(perm, name, role, wage );
                return emp;
            }
            else {
            	System.out.println("No results found matching query");
            	return null;
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return null;
		}
	}
	
	//----------------------------------Accounts---------------------------------------------------//
	public static int Login(String username, String password) {
		//Using hotel accounts table
		String query = "SELECT * FROM hotel.accounts WHERE type IS NOT NULL";
		
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		query = query + " AND user = " + username + "'";
		query = query +  ";";
		
		//If connection cannot be created, will throw error
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
        	//attempt to use connection to execute Query
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            //If no user found return -1
            if (!rs.next()) {
            	return -1;
            }
            if (rs.next()) {	
                //Store from DB in local variables
            	String user = rs.getString(0);
            	String pass = rs.getString(1);
            	//Compare username and password provided with DB username and password
            	if (user == username && pass == password) {
            		return rs.getInt(2);	//type of account 0 is normal, 1 is employee
            	}
            }
		}
		catch (Exception e) {
				System.out.println("Oh No");
			   e.printStackTrace();
			   return -1;
		}
        return -1;
	}
	
	public static int createAccount(String username, String password, int type) {
		//Insert into hotel table accounts
		String query = "USE hotel;\n INSERT INTO accounts VALUES (";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		query = query + "'" + username + "', ";
		query = query + "'" + password + "', ";
		query = query + "'" + String.valueOf(type) + "'";
		query = query + ");";
		
		//Attempt to create Connection
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
        	//attempt to execute insert statement
    		Statement st = con.createStatement();
    		System.out.println(query);
            st.executeUpdate(query);
		}
		catch (Exception e) {	
			//If account is not inserted print error and return -1
			System.out.println("Oh No");
			e.printStackTrace();
			return -1;
		}
        return 0;
	}
}
