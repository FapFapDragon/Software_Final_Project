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
	private Date checkInDate;
	private Date checkOutDate;
	private List<Date> futureBookings;
	private RoomServiceTicket roomService;

	public Room(int ID, int beds, Size size, View view, int floor) {
		this.ID = ID;
		this.beds = beds;
		this.size = size;
		this.view = view;
		this.floor = floor;
		this.setState(State.CLEAN);
		this.setClient(null);
		this.setCheckOutDate(null);
		this.futureBookings = null;
		this.setRoomService(null);
	}

	public boolean checkIn(Customer client, Date checkOutDate) {
		if (this.getState() == State.CLEAN) {
			this.setClient(client);
			this.setCheckInDate(new Date());
			this.setCheckOutDate(checkOutDate);
			return true;
		} else
			return false;
	}

	public void reserve(Date checkInDate) {
		futureBookings.add(checkInDate);
	}

	public List<Date> checkListings() {
		return futureBookings;
	}

	public void checkout() {
		this.setClient(null);
		this.setCheckInDate(null);
		this.setCheckOutDate(null);
		this.setState(State.PICKUP);
	}

	public void changeState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public RoomServiceTicket getRoomService() {
		return roomService;
	}

	public void setRoomService(RoomServiceTicket roomService) {
		this.roomService = roomService;
	}
}
