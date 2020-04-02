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

	private static Connection con;
	
	//----------------------------------Connection---------------------------------------------------//
	
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
	//----------------------------------Room---------------------------------------------------//
	
	public static Room getRoom(int ID, Size size, View view, int floor, State state) {
		String query = "SELECT * FROM hotel.customer WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ID != 0) {query = query + " AND id = " + String.valueOf(ID);}	
		if (size != null) {query = query + " AND size = " + size.name();}
		if (view != null) {query = query + " AND view = " + size.name();}
		if (floor != 0) {query = query + " AND floor = " + String.valueOf(floor);}
		if (state != null) {query = query + " AND state = " + String.valueOf(state);}
		
		query = query +  ";";
		
		System.out.println(query);
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
            Room room = null;
            if (rs.next()) {
                //System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
                int roomID = rs.getInt(0);
                int beds = rs.getInt(1);
                Size s = Size.valueOf(rs.getString(2));
                View v = View.valueOf(rs.getString(3));
                State ste = State.valueOf(rs.getString(4));
                int fl = rs.getInt(5);
                int booking_id = rs.getInt(6);
                room = new Room(roomID, beds, s, v, fl);
                room.setState(ste);
                Booking b = getRoomBooking(booking_id);
                b.setRoom(room);
                room.setBooking(b);
                return room;
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
	
	//----------------------------------Customer---------------------------------------------------//
	
	public static Customer getCustomer(int ID, String address, long phonenumber, int bookingID) {
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
		/*
		  	USE hotel;
			INSERT INTO customer (membership_id, checked_in, phone_number, address, notes, important_notes)
			VALUES ('54321', '0', '123-456-7890', '1234 fake st', 'allergic to soy', 'does not like armidillos');
		 */
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Customer cx = null;
            if (rs.next()) {
                System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
                cx = new Customer(rs.getInt(1), rs.getLong(5), rs.getString(6));
                cx.addMembership(null);// If memberships are added in the future, this will be changed to retrieve a membership
                Booking b = getCustomerBooking(rs.getInt(1));
                b.setClient(cx);
                cx.setBooking(b);//get the booking information
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
	
	private static Customer getBookingCustomer(int ID) {
		String query = "SELECT * FROM hotel.customer WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ID != 0) {query = query + " AND id = " + String.valueOf(ID);}	
		query = query +  ";";
		
		System.out.println(query);
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

	//----------------------------------Bookings---------------------------------------------------//
	static public Booking getBooking(int clientID, int roomID, Date checkInDate, Date checkOutDate) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		
		
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Booking book = null;
            if (rs.next()) {
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
	
	static private Booking getCustomerBooking(int clientID) {
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
		/*
		  	USE hotel;
			INSERT INTO customer (membership_id, checked_in, phone_number, address, notes, important_notes)
			VALUES ('54321', '0', '123-456-7890', '1234 fake st', 'allergic to soy', 'does not like armidillos');
		 */
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            RoomServiceTicket tckt = null;
            if (rs.next()) {
                //System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
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
		
		System.out.println(query);
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
            MaintenanceTicket tckt = null;
            if (rs.next()) {
                //System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
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
		
		System.out.println(query);
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
            CleaningTicket tckt = null;
            if (rs.next()) {
                //System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
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
		
		System.out.println(query);
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
            ComplaintTicket tckt = null;
            if (rs.next()) {
                //System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
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
	public static Employee getDeskAttendant(String ID, PermissionType permission) {
		String query = "SELECT * FROM hotel.complaint_ticket WHERE id IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		if (ID != null) {query = query + " AND id = '" + ID +"'";}
		if (permission != null) {query = query + " AND permission_level = " + permission.name();}
		query = query +  ";";
		
		System.out.println(query);
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
		/*
		  	USE hotel;
			INSERT INTO customer (membership_id, checked_in, phone_number, address, notes, important_notes)
			VALUES ('54321', '0', '1234567890', '1234 fake st', 'allergic to soy', 'does not like armidillos');
		 */
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Employee emp = null;
            if (rs.next()) {
                //System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
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
	
	//----------------------------------Get Login---------------------------------------------------//
	public static int Login(String username, String password) {
		String query = "SELECT * FROM hotel.order_request WHERE type IS NOT NULL";
		//Build query based on passed information, if none are passed the query will just return the first customer which matches the description
		query = query + " AND user = " + username +"'";
		query = query +  ";";
		
		System.out.println(query);
		if (!createConnection()) {
			System.out.println("Could not connect to Database");
		}
        try {
    		Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (!rs.next()) {
            	return -1;
            }
            while (rs.next()) {
                //System.out.println("ID: " + rs.getInt(1) + " memID: " + rs.getString(2) + " Checked In: " + rs.getInt(3) + " bookingID: " + rs.getInt(4) + " phone number: " + rs.getLong(5) + " address: " + rs.getString(6));
            	//Store from DB in local variables
            	String user = rs.getString(0);
            	String pass = rs.getString(1);
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
	
}
