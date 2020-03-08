package com.company;

import java.util.ArrayList;
import java.util.Date;

public class DeskAttendant extends Employee{
    private static ArrayList<ComplaintTicket> complaints;

	public Boolean checkIn(Customer client, Room room, Date checkout) {
		Booking booking = new Booking(client, room, new Date(), checkout);
		if (room.checkIn(booking))
			return client.checkIn(booking);
		return false;
	}

	public boolean checkOut(Customer client) {
		Room checkoutRoom = client.getRoom();
		if (checkoutRoom == null)
			return false;
		checkoutRoom.checkout();
		client.checkOut();
		return true;
	}

    public void upgradeRoom(Customer client, Room room, Date checkout)
    {
    	this.checkOut(client);
    	this.checkIn(client, room, checkout);
    }
    
    public boolean createReservation(Customer client, Room room, Date checkout) {
    	Booking booking = new Booking(client, room, new Date(), checkout);
    	ArrayList<Booking> futureReservations = room.getFutureBookings();
    	boolean available = true;
    	Date currDate = new Date();
    	for (Booking reservation : futureReservations) {
    		if (reservation.getCheckInDate().before(currDate) && reservation.getCheckOutDate().after(currDate) || 
    			reservation.getCheckInDate().before(checkout) && reservation.getCheckOutDate().after(checkout))
    			available = false;
    	}
    	if (available) {
    		room.reserve(booking);
    		client.setBooking(booking);
		}
		return true;
	}

	public boolean CancelReservation(Customer client) {
		client.getRoom().cancelReservation(client.getBooking());
		client.setBooking(null);
		return true;
	}

	public void CheckRooms() {
		// TODO
	}

	public void ProcessPayment() {
		System.out.println("paying...");
	}

	public void ViewTickets() {
		// TODO
	}

	public WakeUpTimer ViewWakeupTime(Customer client) {	
		return client.getWakeUpTimer();
    }

	public void SetWakeupTime(Customer client, WakeUpTimer wakeup) {
		client.setWakeUpTimer(wakeup);
	}

	public void GenerateMaintenanceTicket() {
		// TODO
	}

	// generate request for supplies
	public void generateOrderRequest() {
		// TODO
	}

}
