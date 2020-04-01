package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.HotelDB;

class HotelDB_Test {

	@Test
	void test() {
		HotelDB test = new HotelDB();
		assertEquals(true, test.createConnection());
		assertNotNull(test.getCustomer(0, "test", 0));
		
	}

}
