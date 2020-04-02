package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.Customer;
import com.company.DeskAttendant;
import com.company.Room;

class DeskAttendant_Test {

	@Test
	void test() {
		DeskAttendant test = new DeskAttendant();
		Customer client = new Customer(0, 0, "test");
		
		assertEquals(true, test.checkIn(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date()));
		assertEquals(true, test.checkOut(new Customer(0, 0, "test")));
		assertNotNull(test.upgradeRoom(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date()));
		assertEquals(true, test.createReservation(new Customer(0, 0, "test"), new Room(0, 0, STANDARD, NONE, 0), new java.util.Date()));
		assertEquals(true, test.cancelReservation(new Customer(0, 0, "test")));
		assertNotNull(test.CheckRooms());
		assertNotNull(test.ProcessPayment());
		assertNotNull(test.ViewTickets());
		assertEquals(client.getWakeUpTimer(), test.ViewWakeupTime(client));
		assertNotNull(test.SetWakeupTime(client, client.getWakeUpTimer()));
		assertNotNull(test.generateOrderRequest());
		
	}

}
