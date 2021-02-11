package ch4;/*
 * File: LeapYear
 * Purpose: This program checks if the year is a leap year.
 * 閏年可以被4整除且不能被100整除 或 可以被400整除
 */

import acm.program.*;

public class LeapYear4_3 extends ConsoleProgram{
	
	public void run(){
		
		println("This program checks whether the year is a leap year.");
		int year = readInt("Please enter the year: ");
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			println(year + " is a leap year.");
		}else {
			println(year + " is not a leap year.");
		}
		
	}
	
}
