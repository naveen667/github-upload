package com.nav;

public class StringAddition {

	public static final String DEFAULT_SPLITTER = ",\n";
	public static final String OPEN_BRACKET = "[";
	public static final String CLOSE_BRACKET = "]";
	
	public int Add(String numbers) {
		//Condition to handle empty input String. 
		if(numbers.equalsIgnoreCase(""))
			return 0;

		String customDelimiter = "";
		boolean customDelimiterPresent = false;
		//Condition to find custom delimiter and refactoring the string for splitting.
		if(numbers.startsWith("//")) {
			customDelimiter = numbers.substring(2, 3);
			numbers = numbers.replaceFirst("//"+customDelimiter, "");
			customDelimiterPresent = true;
		}
		
		//Creating the splitting regex
		StringBuffer splitter = new StringBuffer();
		splitter.append(OPEN_BRACKET);
		splitter.append(DEFAULT_SPLITTER);
		
		if(customDelimiterPresent)
			splitter.append(customDelimiter);
		
		splitter.append(CLOSE_BRACKET);
		String[] numbersToAdd = numbers.split(splitter.toString());
		
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
