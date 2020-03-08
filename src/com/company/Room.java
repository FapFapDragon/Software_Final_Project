package com.company;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import com.company.Enums.*;

public class Room {
	private int ID;
	private int beds; // number of beds
	private Size size; // Size scaled from 0 to something or other
	private View view;
	private int floor;
	private State state; // May use this instead of booleans for reserved or occupied
	private Booking booking;
	private List<Booking> futureBookings;
	private RoomServiceTicket roomService;

	public Room(int ID, int beds, Size size, View view, int floor) {
		this.ID = ID;
		this.beds = beds;
		this.size = size;
		this.view = view;
		this.floor = floor;
		this.setState(State.CLEAN);
		this.setBooking(null);
		this.setFutureBookings(null);
		this.setRoomService(null);
	}

	public boolean checkIn(Booking booking) {
		if (this.getState() == State.CLEAN) {
			this.setBooking(booking);
			return true;
		} else
			return false;
	}

	public void reserve(Booking booking) {
		futureBookings.add(booking);
	}

	public List<Booking> checkListings() {
		return futureBookings;
	}

	public void cleanListings() {
		ListIterator<Booking> list = futureBookings.listIterator();
		Date currDate = new Date();
		List<Booking> cleanList = Collections.emptyList();
		while (list.hasNext()) {
			booking = list.next();
			if (booking.getCheckInDate().before(currDate))
				cleanList.add(booking);
		}
		this.setFutureBookings(cleanList);
	}

	public void checkout() {
		this.booking = null;
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

	public RoomServiceTicket getRoomService() {
		return roomService;
	}
	
	public void setRoomService(RoomServiceTicket roomService) {
		this.roomService = roomService;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<Booking> getFutureBookings() {
		return futureBookings;
	}

	public void setFutureBookings(List<Booking> bookings) {
		this.futureBookings = bookings;
	}
}
