package com.nav;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringAdditionTest {

	@Test
	void testAddEmptyString() {
		StringAddition calculate = new StringAddition();
		assertEquals(0, calculate.Add(""), "Add() for empty string should return 0");
	}
	
	@Test
	void testAddStringWithOneNumber() {
		StringAddition calculate = new StringAddition();
		assertEquals(1, calculate.Add("1"), "Add() for String having 1 number should return the sum same as the number");
	}
	
	@Test
	void testAddStringWithMultipleNumber() {
		StringAddition calculate = new StringAddition();
		assertEquals(10, calculate.Add("1,2,3,4"), "Add() must return the sum of two numbers passed as input in the String");
	}
}
