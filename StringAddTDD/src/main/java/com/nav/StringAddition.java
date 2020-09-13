package com.nav;

import java.util.Arrays;

public class StringAddition {

	public static final String DEFAULT_SPLITTER = ",\n";
	public static final String OPEN_BRACKET = "[";
	public static final String CLOSE_BRACKET = "]";
	
	public int Add(String numbers) throws NegativesNotAllowedException{
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
		int[] numbersToAdd = Arrays.asList(numbers.split(splitter.toString())).stream().mapToInt(Integer::parseInt).toArray();
		
		//Condition to handle String with only one number.
		if(numbersToAdd.length < 2)
			if(numbersToAdd[0] > 0)
				return numbersToAdd[0];
			else
				throw new NegativesNotAllowedException("Negatives not allowed. Found " + numbersToAdd[0]);
		else {
			int sum = 0;
			StringBuffer negativeNumbers = new StringBuffer();
			for(int number : numbersToAdd) {
				if(number < 0)
					negativeNumbers.append(" "+number);
				else
					sum += number;
			}
			if(negativeNumbers.length() > 0)
				throw new NegativesNotAllowedException("Negatives not allowed. Found" + negativeNumbers);
				
			return sum;
		}
			
			
	}
}
