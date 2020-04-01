package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.Manager;

class Manager_Test {

	@Test
	void test() {
		Manager test = new Manager();
		
		assertNotNull(test.BuildTickets());
		assertNotNull(test.GetDiscounts());
		assertNotNull(test.AddShift());
		assertNotNull(test.RemoveShifts());
		assertNotNull(test.PlaceOrder());
		assertNotNull(test.ChangeWage());
		assertNotNull(test.generateOrderRequest());
	}

}
