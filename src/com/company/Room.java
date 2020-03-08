package com.company;

import java.util.Date;
import java.util.List;

import com.company.Enums.*;

public class Room {
	private int ID;
	private int beds; // number of beds
	private Size size; // Size scaled from 0 to something or other
	private View view;
	private int floor;
	private State state; // May use this instead of booleans for reserved or occupied
	private Customer client;
	private Date checkoutDate;
	private List<Date> futureBookings;
	private RoomServiceTicket roomService;

	public Room(int ID, int beds, Size size, View view, int floor)
    {
    	this.ID = ID;
    	this.beds = beds;
    	this.size = size;
    	this.view = view;
    	this.floor = floor;
    	this.state = State.CLEAN;
    	this.client = null;
    	this.checkoutDate = null;
    	this.futureBookings = null;
    	this.roomService = null;
    }
	
	public void checkIn(Customer client) {
		this.client = client;
	}

	public void reserve() {

	}

	public List<Date> checkListings() {
		return futureBookings;
	}

	public Customer checkClient() {
		return client;
	}

	public void checkout() {

	}

}
