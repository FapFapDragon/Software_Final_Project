package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.Ticket;

class Ticket_Test {

	@Test
	void test() {
		Ticket test = new Ticket("test", 0, new java.util.Date(), false);
		
		assertNotNull(test.closeTicket());
		assertEquals(0, test.getRoomID());
		assertNotNull(test.setRoomID(0));
		assertEquals(false, test.isComplete());
		assertEquals("test", test.getDescription());
		assertNotNull(test.setDescription("test"));
		
	}

}
