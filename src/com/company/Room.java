package com.company;

import java.util.ArrayList;
import java.util.Date;
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
	private ArrayList<Booking> futureBookings;
	private RoomServiceTicket roomService;

	public Room(int ID, int beds, Size size, View view, int floor) {
		this.ID = ID;
		this.beds = beds;
		this.size = size;
		this.view = view;
		this.floor = floor;
		this.setState(State.CLEAN);
		this.setBooking(null);
		this.setFutureBookings(new ArrayList<Booking>());
		this.setRoomService(null);
	}

	public boolean checkIn(Booking booking) {
		if (this.getState() == State.CLEAN) {
			this.setBooking(booking);
			this.setState(State.DIRTY);
			return true;
		} else
			return false;
	}

	public void reserve(Booking booking) {
		futureBookings.add(booking);
	}
	
	public void cancelReservation(Booking booking) {
		ListIterator<Booking> list = futureBookings.listIterator();
		ArrayList<Booking> cleanList = new ArrayList<Booking>();
		while (list.hasNext()) {
			if (!list.next().equals(booking)) {
				cleanList.add(booking);
			}
		}
		this.setFutureBookings(cleanList);
	}

	public ArrayList<Booking> checkListings() {
		return futureBookings;
	}

	public void reservationHandler() {
		ListIterator<Booking> list = futureBookings.listIterator();
		Date currDate = new Date();
		ArrayList<Booking> cleanList = new ArrayList<Booking>();
		while (list.hasNext()) {
			booking = list.next();
			if (booking.getCheckInDate().equals(currDate) && this.getState() == State.CLEAN) {
				this.setBooking(booking);
				this.setState(State.DIRTY);
			}
			if (booking.getCheckInDate().before(currDate))
				cleanList.add(booking);
		}
		this.setFutureBookings(cleanList);
	}

	public boolean checkout() {
		this.booking = null;
		this.setState(State.PICKUP);
		return true;
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

	public ArrayList<Booking> getFutureBookings() {
		return futureBookings;
	}

	public void setFutureBookings(ArrayList<Booking> bookings) {
		this.futureBookings = bookings;
	}
}
