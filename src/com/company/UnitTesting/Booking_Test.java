package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.Booking;
import com.company.Customer;
import com.company.Room;

public class Booking_Test {

	@Test
	void test() {
		Booking test = new Booking(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date(), new java.util.Date());
		Customer client = new Customer(0, 0, "test");
		
		assertEquals(new java.util.Date(), test.getCheckOutDate());
		assertNotNull(test.setCheckOutDate(new java.util.Date()));
		assertEquals(new java.util.Date(), test.getCheckInDate());
		assertNotNull(test.setCheckInDate(new java.util.Date()));
		assertEquals(new Room(0, 0, STANDARD, NONE, 0), test.getRoom());
		assertNotNull(test.setRoom(new Room(0, 0, STANDARD, NONE, 0)));
		assertEquals(new Customer(0, 0, "test"), test.getClient());
		assertNotNull(test.setClient(new Customer(0, 0, "test")));
	}

}
