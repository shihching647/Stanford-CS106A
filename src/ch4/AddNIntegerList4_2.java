package ch4;/*
 * File: AddNIntegerList
 * Purpose: This program reads integers one per line until the 
 * user enters a special value(SENTINEL) to signal the end of the input.
 * At that point, the program prints the sum of the numbers entered so far.
 */

import acm.program.*;

public class AddNIntegerList4_2 extends ConsoleProgram{
	
	public void run(){
		
		println("This program adds any number of integers.(Enter 0 to exit and show the result)");
		
		int sum = 0;
		while(true) {
			int val = readInt("Enter integer: ");
			if(val == 0) break;
			sum += val;
		}
	
		println("The sum is " + sum + ".");

	}
	// The number of integers --> N_VALUES
	private static final int SENTINEL = 0;
	
}
