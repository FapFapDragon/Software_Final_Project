package com.company;

import java.sql.Date;

public class Booking {
	private Customer client;
	private Room room;
	private Date checkInDate;
	private Date checkOutDate;
	
	public Booking(Customer client, Room room, Date checkInDate, Date checkOutDate) {
		this.setClient(client);
		this.setRoom(room);
		this.setCheckInDate(checkInDate);
		this.setCheckOutDate(checkOutDate);
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Customer getClient() {
		return client;
	}

	public void setClient(Customer client) {
		this.client = client;
	}
}
