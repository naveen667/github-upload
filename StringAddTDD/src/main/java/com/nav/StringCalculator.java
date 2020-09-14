package com.nav;

import java.util.Arrays;

/** 
* <h1>StringCalculator provides the sum of numbers</h1> 
* The StringCalculator implements a method 
* that calculates the sum of numbers provided 
* in the form of String input
* 
* @author  Naveen Choudhary
*/

public class StringCalculator {

	public static final String COMMA_SPLITTER = ",";
	public static final String NEWLINE_SPLITTER = "\n";
	public static final String OPEN_BRACKET = "[";
	public static final String CLOSE_BRACKET = "]";
	
	 /** 
		 * This method is used to find sum of numbers provided in the form of String as input.
		 * The default delimiter is ',' but the custom delimiter can be provided in the following format “//[delimiter]\n[numbers…]”.
		 * @param Numbers This parameters is a String which contains numbers seperated by delimiter 
		 * @return int This returns sum of numbers in the input String.
		 */
	
	public int Add(String numbers) throws NegativesNotAllowedException{
		
		if(numbers.equalsIgnoreCase(""))		//Condition to handle empty input String. 
			return 0;

		String customDelimiter = "";
		boolean customDelimiterPresent = false;
		
		//Condition to find custom delimiter and refactoring the string for splitting.
		if(numbers.startsWith("//")) {
			customDelimiter = numbers.substring(2, numbers.indexOf("\n"));
			int delimiterLen = ("//" + customDelimiter +"\n").length();
			numbers = numbers.substring(delimiterLen);
			customDelimiterPresent = true;
		}
		
		//Creating the splitting regex
		StringBuffer splitter = new StringBuffer();
		splitter.append(OPEN_BRACKET);
		
		if(customDelimiterPresent) {
			splitter.append(customDelimiter);
			splitter.append(NEWLINE_SPLITTER);
		}
		else {
			splitter.append(COMMA_SPLITTER);
			splitter.append(NEWLINE_SPLITTER);
		}
		splitter.append(CLOSE_BRACKET);
		
		String[] numbersToAddStrArr = numbers.split(splitter.toString());
		
		int[] numbersToAdd =  new int[numbersToAddStrArr.length];		//Initializing the integer array
		int idxnum = 0;
		
		//Parsing String array to integer.
		for(int index = 0; index < numbersToAddStrArr.length; index++) {
			if(!numbersToAddStrArr[index].equalsIgnoreCase(""))
				numbersToAdd[idxnum++] = Integer.parseInt(numbersToAddStrArr[index]);
		}
		
		
		if(numbersToAdd.length < 2) {						//Condition to handle String with only one number.				
			if(numbersToAdd[0] > 0)							//Verifying if the number is negative.
				return numbersToAdd[0];
			else
				throw new NegativesNotAllowedException("Negatives not allowed. Found " + numbersToAdd[0]);
		}
		else {
			int sum = 0;
			StringBuffer negativeNumbers = new StringBuffer();
			for(int number : numbersToAdd) {
				if(number < 0)
					negativeNumbers.append(" "+number);		//Searching for all negative numbers
				else if (number > 1000)						//Condition to skip numbers greater than 1000
					continue;
				else	
					sum += number;
			}
			if(negativeNumbers.length() > 0)
				throw new NegativesNotAllowedException("Negatives not allowed. Found" + negativeNumbers);
				
			return sum;
		}
			
			
	}
}
