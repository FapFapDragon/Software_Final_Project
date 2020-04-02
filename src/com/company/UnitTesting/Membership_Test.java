package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.Membership;

class Membership_Test {

	@Test
	void test() {
		Membership test = new Membership("test", testArray, 0, new java.util.Date());
		
		assertNotNull(test.upgradeMembership());
		assertNotNull(test.cancelMembership());
		assertEquals(testArray, test.getPerks());
		assertNotNull(test.setPerks(testArray));
		assertEquals(0, test.getLevel());
		assertNotNull(test.setLevel(0));
	}

}
