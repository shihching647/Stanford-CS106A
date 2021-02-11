package ch5;/*
 * File: TemperatureConvertsionTable
 * Purpose: This program creates a table of Celsius to Fahrenheit
 * equivalents using a function to perform the conversion.
 */

import acm.program.*;

public class TemperatureConvertsionTable5_2 extends ConsoleProgram{
	
	public void run(){
		println("Celsius to Fahrenheit table.");
		for(int c = LOWER_LIMIT; c <= UPPER_LIMIT; c += STEP_SIZE) {
			int f = (int)celsiusToFahrenheit(c);
			println("C: " + c + "\tF: " + f);
		}
		
	}
	
	private double celsiusToFahrenheit(int c){
		return 9.0 / 5.0 * c + 32;  //回傳double,故要用9.0 / 5.0,不能用 9/5 
	}
	
	private static final int LOWER_LIMIT = 0;
	private static final int UPPER_LIMIT = 100;
	private static final int STEP_SIZE = 5;

}
