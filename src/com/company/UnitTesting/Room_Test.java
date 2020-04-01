package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.ArrayList;
import com.company.Booking;
import com.company.Customer;
import com.company.Date;
import com.company.Room;
import com.company.String;
import com.company.Enums.State;

class Room_Test {

	@Test
	void test() {
		Room test = new Room(0, 0, STANDARD, NONE, 0);
		
		assertEquals(true, test.checkIn(new Booking(new Customer(0, 0, "test"), new Room(0, 0, Size.STANDARD, View.NONE, 0), new java.util.Date(), new java.util.Date())));
		assertNotNull(test.reserve(new Booking(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date(), new java.util.Date())));
		assertNotNull(test.cancelReservation(new Booking(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date(), new java.util.Date())));
		assertEquals(new ArrayList<Booking>(), test.checkListings());
		assertNotNull(test.reservationHandler());
		assertEquals(true, test.checkout());
		assertNotNull(test.changeState(State.CLEAN));
		assertEquals(State.CLEAN, test.getState());
		assertNotNull(test.setState(State.CLEAN));
		assertEquals(new RoomServiceTicket(0, new Room(0, 0, STANDARD, NONE, 0), new java.util.Date(), new java.util.Date(), "test", "test"), test.getRoomService());
		assertNotNull(test.setRoomService(new RoomServiceTicket(0, new Room(0, 0, STANDARD, NONE, 0), new java.util.Date(), new java.util.Date(), "test", "test")));
		assertEquals(new Booking(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date(), new java.util.Date()), test.getBooking(new Booking(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date(), new java.util.Date())));
		assertNotNull(test.setBooking(new Booking(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date(), new java.util.Date())));
		assertEquals(new ArrayList<Booking>(), test.getFutureBookings());
		assertNotNull(test.setFutureBookings(new ArrayList<Booking>());
		
	}

}
