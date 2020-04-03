package com.company;

import java.util.ArrayList;
import com.company.Enums.*;
import java.util.Date;

public class DeskAttendant extends Employee{
    private static ArrayList<ComplaintTicket> complaints;

    public DeskAttendant(PermissionType permissionLevel, String name, String role, float wage) {
    	super(permissionLevel, name, role, wage);
    }
    
    //check a client into a room
	public Boolean checkIn(Customer client, Room room, Date checkout) {
		Booking booking = new Booking(client, room, new Date(), checkout);
		if (room.checkIn(booking))
			return client.checkIn(booking);
		return false;
	}

	//check a client out of a room
	public boolean checkOut(Customer client) {
		Room checkoutRoom = client.getRoom();
		if (checkoutRoom == null)
			return false;
		checkoutRoom.checkout();
		client.checkOut();
		return true;
	}

	//changes your room
    public void upgradeRoom(Customer client, Room room, Date checkout)
    {
    	this.checkOut(client);
    	this.checkIn(client, room, checkout);
    }
    
    //creates a reservation, essentially adds the room to future bookings if its available
    public boolean createReservation(Customer client, Room room, Date checkout) {
    	Booking booking = new Booking(client, room, new Date(), checkout);
    	ArrayList<Booking> futureReservations = room.getFutureBookings();
    	boolean available = true;
    	Date currDate = new Date();
    	//check every future booking
    	for (Booking reservation : futureReservations) {
    		//for date overlap
    		if ((reservation.getCheckInDate().before(currDate) && reservation.getCheckOutDate().after(currDate)) || 
    				(reservation.getCheckInDate().before(checkout) && reservation.getCheckOutDate().after(checkout)) ||
    				reservation.getCheckInDate().equals(currDate) || reservation.getCheckOutDate().equals(checkout))
    			available = false;
    	}
    	//if theres no overlap reserve it
    	if (available) {
    		room.reserve(booking);
    		client.setBooking(booking);
    		return true;
		}
    	return false;
	}

	public boolean cancelReservation(Customer client) {
		Room checkoutRoom = client.getRoom();
		if (checkoutRoom == null)
			return false;
		client.getRoom().cancelReservation(client.getBooking());
		client.setBooking(null);
		return true;
	}

	public void checkRooms() {
		// TODO
	}

	//hypothetical way payment would be processed, we are NOT implementing payment
	public void processPayment() {
		System.out.println("paying...");
	}

	public void viewTickets() {
		// TODO
	}

	public WakeUpTimer viewWakeupTime(Customer client) {	
		return client.getWakeUpTimer();
    }

	public void setWakeupTime(Customer client, WakeUpTimer wakeup) {
		client.setWakeUpTimer(wakeup);
	}

	// generate request for supplies
	public void generateOrderRequest() {
		// TODO
	}
	

}
