package com.company.UnitTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.company.Access;

class Access_Test {

	@Test
	void test() {
		Access test = new Access();
		
		assertNotNull(true, test.setTestInt(0));
	}

}
