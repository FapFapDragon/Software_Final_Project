package com.company;

import java.util.Collections;
import java.util.Date;
import java.util.ArrayList;
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
	
	public void cancelReservation(Booking booking) {
		ArrayListIterator<Booking> ArrayList = futureBookings.ListIterator();
		ArrayList<Booking> cleanArrayList = Collections.emptyArrayList();
		while (ArrayList.hasNext()) {
			if (!ArrayList.next().equals(booking)) {
				cleanArrayList.add(booking);
			}
		}
		this.setFutureBookings(cleanArrayList);
	}

	public ArrayList<Booking> checkArrayListings() {
		return futureBookings;
	}

	public void reservationHandler() {
		ArrayListIterator<Booking> ArrayList = futureBookings.ArrayListIterator();
		Date currDate = new Date();
		ArrayList<Booking> cleanArrayList = Collections.emptyArrayList();
		while (ArrayList.hasNext()) {
			booking = ArrayList.next();
			if (booking.getCheckInDate().equals(currDate) && this.getState() == State.CLEAN) {
				this.setBooking(booking);
				this.setState(State.DIRTY);
			}
			if (booking.getCheckInDate().before(currDate))
				cleanArrayList.add(booking);
		}
		this.setFutureBookings(cleanArrayList);
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
