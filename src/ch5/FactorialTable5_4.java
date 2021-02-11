package ch5;/*
 * File: FactorialTable
 * Purpose: This program creates a table of Celsius to Fahrenheit
 * equivalents using a function to perform the conversion.
 */

import acm.program.*;

public class FactorialTable5_4 extends ConsoleProgram{
	
	public void run(){
		println("Factorial table");
		for(int i = LOWER_LIMIT; i <= UPPER_LIMIT; i++) {
			println(i + "! = " + factorial(i));
		}
		
		
	}
	
	private int factorial(int n) {
		int result = 1;
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
	
	private double celsiusToFahrenheit(int c){
		return 9.0 / 5.0 * c + 32;  //回傳double,故要用9.0 / 5.0,不能用 9/5 
	}
	
	private static final int LOWER_LIMIT = 0;
	private static final int UPPER_LIMIT = 10;

}
