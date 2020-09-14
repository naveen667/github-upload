package com.nav;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringAdditionTest {

	@Test
	void testAddEmptyString() throws NegativesNotAllowedException { // Test for empty string
		StringCalculator calculate = new StringCalculator();
		assertEquals(0, calculate.Add(""), "Add() for empty string should return 0");
	}
	
	@Test
	void testAddStringWithOneNumber() throws NegativesNotAllowedException {		// Test for string with single number
		StringCalculator calculate = new StringCalculator();
		assertEquals(1, calculate.Add("1"), "Add() for String having 1 number should return the sum same as the number");
	}
	
	@Test
	void testAddStringWithMultipleNumber() throws NegativesNotAllowedException {	// Test for string with multiple number
		StringCalculator calculate = new StringCalculator();
		assertEquals(10, calculate.Add("1,2,3,4"), "Add() must return the sum of two numbers passed as input in the String");
	}
	
	@Test
	void testAddContainingNewLine() throws NegativesNotAllowedException {  // Test for string containing newline character.
		StringCalculator calculate = new StringCalculator();
		assertEquals(10, calculate.Add("1,2\n3,4"), "Add() must return the sum of two numbers passed as input in the String");
	}
	
	@Test
	void testAddContainingCustomDelimiter() throws NegativesNotAllowedException {	// Test for string containing custom delimiter.
		StringCalculator calculate = new StringCalculator();
		assertEquals(10, calculate.Add("//;\n1;2\n3;4"), "Add() must return the sum of two numbers passed as input in the String");
	}
	
	@Test
	void testAddNegativeNumberCheck() throws NegativesNotAllowedException {	// Test for string checking the presence of negative number in string.
		StringCalculator calculate = new StringCalculator();
		assertThrows(NegativesNotAllowedException.class, () -> calculate.Add("//;\n1;-2\n3;-4"), "Should throw negatives not allowed if any negative number is present in the string");
	}
	
	@Test
	void testAddNumberAboveThousand() throws NegativesNotAllowedException {	//Test for skipping the number above 1000.
		StringCalculator calculate = new StringCalculator();
		assertEquals(6, calculate.Add("//;\n1;2\n3;1001"), "Add() must return the sum of two numbers passed as input in the String");
	}
	
	@Test
	void testAddAnyLengthDelimiter() throws NegativesNotAllowedException {	//Test for providing any length custom delimiter.
		StringCalculator calculate = new StringCalculator();
		assertEquals(6, calculate.Add("//[***]\n1***2\n3***1001"), "Add() must return the sum of two numbers passed as input in the String");
	}
	
	@Test
	void testAddAnyLengthMultipleDelimiter() throws NegativesNotAllowedException {	//Test for providing multiple any length custom delimiter.
		StringCalculator calculate = new StringCalculator();
		assertEquals(6, calculate.Add("//[***][%%]\n1***2\n3%%1001"), "Add() must return the sum of two numbers passed as input in the String");
	}
}
