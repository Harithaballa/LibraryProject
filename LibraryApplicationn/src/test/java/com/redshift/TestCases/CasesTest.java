package com.redshift.TestCases;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CasesTest {

	@Test
	void test() {
		Cases case1=new Cases();
		//int actual=case1.add(2, 3);
		int expected=5;
		assertEquals(expected,case1.increment(2));
	}
	
	

}
