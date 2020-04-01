package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.Maintenance;
import com.company.Ticket;

class Maintenance_Test {

	@Test
	void test() {
		Maintenance test = new Maintenance();
		
		assertNotNull(test.CompleteTicket(new Ticket("test", 0, new java.util.Date(), false)));
		assertNotNull(test.generateOrderRequest());
	}

}
