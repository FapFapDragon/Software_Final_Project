package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.WakeUpTimer;
import java.util.Date;

class WakeUpTimer_Test {

	@Test
	void test() {
		WakeUpTimer test = new WakeUpTimer(0, new java.util.Date());
		
		assertEquals(new java.util.Date(), test.getDate());
		assertNotNull(test.setDate(new java.util.Date()));
		
		assertEquals(0, test.getID());
		assertNotNull(test.setID(0));
		
	}

}
