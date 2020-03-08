package com.company;

import java.util.Date;
import java.util.List;

public class DeskAttendant extends Employee{
    private static List<ComplaintTicket> complaints;

    public Boolean checkIn(Customer client, Room room, Date checkout)
    {
    	Booking booking = new Booking(client, room, new Date(), checkout);
    	if (room.checkIn(booking)) 
    		return client.checkIn(booking);
    	return false;
    }

    public boolean checkOut(Customer client)
    {
    	client.getRoom().checkout();
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
    	List<Booking> futureReservations = room.getFutureBookings();
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

    public void CancelReservation(Customer client)
    {
    	client.getRoom().cancelReservation(client.getBooking());
    	client.setBooking(null);
    }

    public void CheckRooms()
    {

    }

    public void ProcessPayment()
    {

    }

    public void ViewTickets()
    {

    }

    public void ViewWakeupTime()
    {

    }

    public void SetWakeupTime()
    {

    }

    public void GenerateMaintenanceTicket()
    {

    }

    //generate request for supplies
    public void generateOrderRequest()
    {

    }

}
