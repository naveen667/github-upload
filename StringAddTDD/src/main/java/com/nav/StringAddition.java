package com.nav;

public class StringAddition {

	public int Add(String numbers) {
		//Condition to handle empty input String. 
		if(numbers.equalsIgnoreCase(""))
			return 0;

		String[] numbersToAdd = numbers.split("[,\n]");
		
		//Condition to handle String with only one number.
		if(numbersToAdd.length < 2)
			return Integer.parseInt(numbersToAdd[0]);
		else {
			int sum = 0;
			for(String number : numbersToAdd) {
				sum += Integer.parseInt(number);
			}
			return sum;
		}
			
			
	}
}
