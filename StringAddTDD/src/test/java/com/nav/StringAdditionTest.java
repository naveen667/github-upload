package com.nav;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringAdditionTest {

	@Test
	void testAddEmptyString() throws NegativesNotAllowedException {
		StringAddition calculate = new StringAddition();
		assertEquals(0, calculate.Add(""), "Add() for empty string should return 0");
	}
	
	@Test
	void testAddStringWithOneNumber() throws NegativesNotAllowedException {
		StringAddition calculate = new StringAddition();
		assertEquals(1, calculate.Add("1"), "Add() for String having 1 number should return the sum same as the number");
	}
	
	@Test
	void testAddStringWithMultipleNumber() throws NegativesNotAllowedException {
		StringAddition calculate = new StringAddition();
		assertEquals(10, calculate.Add("1,2,3,4"), "Add() must return the sum of two numbers passed as input in the String");
	}
	
	@Test
	void testAddContainingNewLine() throws NegativesNotAllowedException {
		StringAddition calculate = new StringAddition();
		assertEquals(10, calculate.Add("1,2\n3,4"), "Add() must return the sum of two numbers passed as input in the String");
	}
	
	@Test
	void testAddContainingCustomDelimiter() throws NegativesNotAllowedException {
		StringAddition calculate = new StringAddition();
		assertEquals(10, calculate.Add("//;\n1,2\n3;4"), "Add() must return the sum of two numbers passed as input in the String");
	}
	
	@Test
	void testAddNegativeNumberCheck() throws NegativesNotAllowedException {
		StringAddition calculate = new StringAddition();
		assertThrows(NegativesNotAllowedException.class, () -> calculate.Add("//;\n1,-2\n3;-4"), "Should throw negatives not allowed if any negative number is present in the string");
	}
}
