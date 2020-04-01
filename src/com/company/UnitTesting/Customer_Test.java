package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.ArrayList;
import com.company.Booking;
import com.company.Customer;
import com.company.Room;
import com.company.WakeUpTimer;

class Customer_Test {

	@Test
	void test() {
		Customer test = new Customer(0, 0, "test");
		Membership membership = new Membership("test", testArray, 0, new java.util.Date());
		Booking booking = new Booking(test, room, checkInDate, checkoutDate);
		
		assertNotNull(test.addMembership(membership));
		assertEquals(true, test.checkIn(booking));
		assertEquals(true, test.checkOut());
		assertNotNull(test.modifyCheckIn());
		assertNotNull(test.addNote(true, "test"));
		assertNotNull(test.generateComplaint("test", 0, new java.util.Date(), true));
		assertNotNull(test.removeComplaint());
		assertEquals(true, test.isMembershipActive());
		assertNotNull(test.setMembershipActive(true));
		assertEquals(booking, test.getBooking());
		assertNotNull(test.setBooking(booking));
		assertEquals(true, test.isCheckedIn());
		assertNotNull(test.setCheckedIn(true));
		assertNotNull(test.setCheckInDate(new java.util.Date()));
		assertEquals(checkInDate, test.getCheckInDate());
		assertEquals(new Room(0, 0, STANDARD, NONE, 0), test.getRoom());
		assertEquals(new WakeUpTimer(0, new java.util.Date()), test.getWakeUpTimer());
		assertNotNull(test.setWakeUpTimer(new WakeUpTimer(0, new java.util.Date())));
		assertEquals(new ArrayList<Booking>(), test.getPreviousBooking());
		assertNotNull(test.setPreviousBooking(new ArrayList<Booking>()));
	}

}
